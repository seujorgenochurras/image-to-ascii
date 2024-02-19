package io.github.seujorgenochurras.util;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

    private FileUtils() {
        //Util class
    }

    /**
     * @param path to the image
     * @return A {@link BufferedImage} instance of your path or null if image doesn't exist
     */
    public static BufferedImage tryGetImageFromPath(String path) {
        File imageFile = new File(path);
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
