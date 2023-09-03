package io.github.seujorgenochurras;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.PixelScaleAlgorithm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BetterImage betterImage = createImage("src/main/resources/tojolo.png");
        Image scaledImage = betterImage.getBufferedImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH);
        BufferedImage scaledImageBuffer = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D scaledImageGraphics = scaledImageBuffer.createGraphics();
        scaledImageGraphics.drawImage(scaledImage, 0, 0, null);
        scaledImageGraphics.dispose();


        betterImage = new BetterImage(scaledImageBuffer);

        AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols("@", "$", "/", ",", ".", " ")
                .scaled()
                    .height(70)
                    .width(100)
                    .algorithm(PixelScaleAlgorithm.FAST)
                .getScale()

                .build();


        FileWriter fileWriter = new FileWriter("src/main/resources/out.txt");
        fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
        fileWriter.flush();


    }

    private static BetterImage createImage(String imagePath) {
        File imageFile = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            return new BetterImage(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BetterImage(null);
    }
}