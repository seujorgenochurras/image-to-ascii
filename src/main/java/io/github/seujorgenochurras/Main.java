package io.github.seujorgenochurras;

import io.github.seujorgenochurras.image.Image;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.pixel.ImagePixelGroup;
import io.github.seujorgenochurras.image.pixel.PixelBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Image image = createImage("src/main/resources/out.png");

        image.getPixels().forEach(pixel -> {
            pixel.color.getRed().subtract(10);
            pixel.color.getGreen().add(10);
            pixel.color.getBlue().add(20);
        });


        AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols("@", "#", "!", ".")
                .build();


        System.out.println();
        FileWriter fileWriter =new FileWriter(new File("src/main/resources/out.txt"));
        fileWriter.write(AsciiParser.parse(image, parserConfig));
        fileWriter.flush();

//        image.updateCurrentPixels();
//
//        rewriteImage(image);
    }

    private static void rewriteImage(Image image) {
        File imageOutput = new File("src/main/resources/out.png");
        try {
            ImageIO.write(image.getBufferedImage(), "png", imageOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Image createImage(String imagePath) {
        File imageFile = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            return new Image(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Image(null);
    }
}