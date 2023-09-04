package io.github.seujorgenochurras;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.AsciiAlgorithms;
import io.github.seujorgenochurras.util.ArrayUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BetterImage betterImage = createImage("src/main/resources/tojolo.png");
        String[] symbols = {"@", "$", "I", "1", "/", "-", ",", ".", " "};

        AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols(symbols)
                .scaled()
                .height(50)
                .width(65)
                .getScale()
                .parserAlgorithm(AsciiAlgorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())

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