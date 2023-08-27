package io.github.seujorgenochurras;

import io.github.seujorgenochurras.image.Image;
import io.github.seujorgenochurras.image.pixel.ImagePixels;
import io.github.seujorgenochurras.image.pixel.PixelBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File imageFile = new File("src/main/resources/buceta.png");
        BufferedImage bufferedImage = ImageIO.read(imageFile);
        Image image = new Image(bufferedImage);

        ImagePixels pixels = PixelBuilder.build(image);

        pixels.forEach(pixel -> {
            pixel.color.getRed().subtract(10);
            pixel.color.getGreen().add(10);
            pixel.color.getBlue().add(20);
        });

        image.setPixels(pixels);
        File imageOutput = new File("src/main/resources/out.png");
        ImageIO.write(image.getBufferedImage(), "png", imageOutput);
    }
}