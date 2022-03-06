package recipemanager.controller;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import recipemanager.dto.Mapper;
import recipemanager.dto.RecipeDTO;
import recipemanager.entity.Recipe;
import recipemanager.service.RecipeService;
import recipemanager.util.FileUploadUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin
@RequestMapping(value = "/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private Mapper mapper;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getRecipes() throws SQLException, IOException {
        List<Recipe> recipes = this.recipeService.findAll();
        for(Recipe recipe : recipes){
            decompressBytes(recipe.getImage());
        }

        if(recipes == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recipes.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public List<RecipeDTO> getAllRecipes(){
        return this.recipeService.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @GetMapping(value = "/{recipeId}", produces = "application/json")
    public ResponseEntity<?> getRecipe(@PathVariable("recipeId") Long recipeId){
        Recipe recipe = this.recipeService.findById(recipeId).get();
        if(recipe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe,
                                       @Param("image")MultipartFile file,
                                       UriComponentsBuilder ucBuilder) throws IOException {
        HttpHeaders header = new HttpHeaders();
        if(!file.isEmpty()){
            byte[] fileName = ByteArrayUtil.hexStringToByteArray(file.getOriginalFilename());

            recipe.setImage(fileName);
            compressBytes(fileName);

            String uploadDir = "users-photos/";

            FileUploadUtil.cleanDirectory(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, file);


            if(recipe.getRecipeId() != null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            compressBytes(recipe.getImage());
        } else{
            if(recipe.getImage() == null){
                recipe.setImage(null);
            }
        }
        if(recipe.getRecipeId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.recipeService.save(recipe);
        header.setLocation(ucBuilder.path("/recipe/{recipeId}").buildAndExpand(recipe.getRecipeId()).toUri());
        return new ResponseEntity<>(recipe, header, HttpStatus.CREATED);
    }

    // compress the image bytes before storing it in the database
    public static void compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static void decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        outputStream.toByteArray();
    }
}
