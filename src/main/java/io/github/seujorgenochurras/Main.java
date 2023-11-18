package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class Main {
    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 1500, getUTFChars(32, 8555)).getSymbolsAsStringArray();

    public static void main(String[] args) throws IOException {
        asciifyFile("/home/thiagoelias/Pictures/Screenshots/Screenshot from 2023-10-12 20-37-34.png");
    }
    public static void asciifyInDir() throws IOException {

        File[] images = new File("src/main/resources/image/").listFiles();


        for (File image : images) {
            BetterImage betterImage = new BetterImage(ImageIO.read(image));

            ParserConfig parserConfig = ParserBuilder.startBuild()
                    .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
                    .scaled()
                    .algorithm(PixelScaleAlgorithm.SMOOTH)
                    .height(betterImage.getHeight() / 8)
                    .width(betterImage.getWidth() / 4)
                    .getScale()
                    .symbols(symbols)
                    .withColor(ColorType.ANSI)
                    .build();

            FileWriter fileWriter = new FileWriter("/home/thiagoelias/.neofetch/ascii/" + image.getName().replaceAll("png|jpg", "txt"));
            fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
            fileWriter.flush();
        }
    }


    public static void asciifyFile(String fileName) throws IOException {
        File image = new File(fileName);
            BetterImage betterImage = new BetterImage(ImageIO.read(image));

            ParserConfig parserConfig = ParserBuilder.startBuild()
                    .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
                    .scaled()
                    .algorithm(PixelScaleAlgorithm.SMOOTH)
                    .height(betterImage.getHeight() / 6)
                    .width(200)
                    .getScale()
                    .symbols(symbols)
                    .withColor(ColorType.ANSI)
                    .build();

            FileWriter fileWriter = new FileWriter("/home/thiagoelias/.neofetch/ascii/" + image.getName().replaceAll("png|jpg", "txt"));
            fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
            fileWriter.flush();
    }
}
