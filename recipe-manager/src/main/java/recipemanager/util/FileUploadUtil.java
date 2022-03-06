package recipemanager.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;

public class FileUploadUtil {

    String path = "recipe-photos/";

    public static void saveFile(String uploadDir, byte[] fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(Arrays.toString(fileName));
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save file:" + fileName, e);
        }
    }

    public static void cleanDirectory(String dir) throws IOException {
        Path dirPath = Paths.get(dir);

        try{
            Files.list(dirPath).forEach(file -> {
                if(!Files.isDirectory(file)){
                    try {
                        Files.delete(file);
                    } catch (IOException e){
                        System.out.println("Could not delete file: " + file);
                    }
                }
            });
        } catch (IOException e){
            System.out.println("Could not list directory: " + dirPath);
        }
    }

    public byte[] imageToByte(String inputFile, byte[] data) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(inputFile));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        data = bos.toByteArray();
        return data;
    }

    public File getFileFromResources(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }
    }
    /*public Path fetchProfilePhotoByUserId(String recipeId) throws ImageRetrivalException {
        Path imagePath = null;

        Path rootLocation = Paths.get(getRootLocationForUserProfileImageUpload(recipeId));
        LOG.debug("Fetching profile image from " + rootLocation.toString());

        try {
            if (rootLocation.toFile().exists()) {
                Iterator<Path> iterator = Files.newDirectoryStream(rootLocation).iterator();

                if (iterator.hasNext()) {
                    imagePath = iterator.next();
                    LOG.debug("File name is " + imagePath);
                }
            }
        } catch (IOException ie) {
            throw new ImageRetrievalException(ie.getMessage());
        }

        return imagePath;
    }

    public String getRootLocationForUserProfileImageUpload(String recipeId) {
        if (StringUtils.isEmpty(recipeId)) throw new IllegalArgumentException("No user id!");

        String base = getRootLocationForUserUpload(recipeId);

        StringBuilder builder = new StringBuilder(base);
        builder.append("/");
        builder.append(PROFILE_DIR);

        String location = builder.toString();
        return location;
    }
    public String getRootLocationForUserUpload(Recipe recipe) {
        if (recipe == null) throw new IllegalArgumentException("No user provided!");
        return this.getRootLocationForUserUpload(recipe.getRecipeId());
    }
*/
}