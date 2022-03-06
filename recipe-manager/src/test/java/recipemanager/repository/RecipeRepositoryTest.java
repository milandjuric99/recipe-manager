package recipemanager.repository;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import recipemanager.dto.Mapper;
import recipemanager.dto.RecipeDTO;
import recipemanager.entity.*;
import recipemanager.util.FileUploadUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private DifficultyRepository difficultyRepository;
    @Autowired
    private CuisineRepository cuisineRepository;
    @Autowired
    private RecipeTypeRepository recipeTypeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;


    @Test
    public void createRecipe() throws IOException, URISyntaxException {

        FileUploadUtil util = new FileUploadUtil();

        List<Ingredients> ingredients = this.ingredientRepository.findAll();
        Difficulty difficulty = this.difficultyRepository.getById(3L);
        RecipeType recipeType = this.recipeTypeRepository.getById(2L);
        Cuisine cuisine = this.cuisineRepository.getById(1L);
        String inputFilePath = "recipe-photos/pilav.jpg";


        File inputFile =  util.getFileFromResources(inputFilePath);
        byte[] imageData = FileUtils.readFileToByteArray(inputFile);

        Recipe recipe = new Recipe("Pilav", "Serbian rice and chicken", 5.0f, "30 min", imageData,
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ingredients, difficulty, recipeType, cuisine);

        this.recipeRepository.save(recipe);

        assertThat(recipe.getRecipeId()).isGreaterThan(0);
    }

    @Test
    public void testImageEncoding(){

        ModelMapper modelMapper = new ModelMapper();
        Mapper mapper = new Mapper();


        Recipe recipe = this.recipeRepository.findById(2L).get();
        RecipeDTO dto = mapper.toDto(recipe);
        /*RecipeDTO dto = modelMapper.map(recipe, RecipeDTO.class)*/;

        System.out.println(recipe);
        System.out.println(dto);
    }

}
