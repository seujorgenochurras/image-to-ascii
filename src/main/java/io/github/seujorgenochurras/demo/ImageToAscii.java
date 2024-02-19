package io.github.seujorgenochurras.demo;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import io.github.seujorgenochurras.image.pixel.color.PixelColor;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class ImageToAscii {

    private static final String[] unorderedSymbols = getUTFChars(32, 123);
    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(100, unorderedSymbols).toArray();


    private static final ParserConfig parserConfig = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM)
            .scaled()
            .height(50)
            .width(100)
            .getScale()
            .symbols(symbols)
            .colorAlgorithm(new AnsiColorAlgorithm())
            .build();
    private static PixelColor[] tones;

    public static void main(String[] args) throws IOException {
        asciifyFile("/home/thiagoelias/IdeaProjects/image-to-ascii/src/main/resources/image/car.png");
    }

    public static void asciifyFile(String fileName) throws IOException {
        File image = new File(fileName);
        BetterImage betterImage = new BetterImage(ImageIO.read(image));

        String asciiArt = AsciiParser.parse(betterImage, parserConfig);

        File newFile = new File("myAscii.txt");
        FileWriter fileWriter = new FileWriter(newFile);
        fileWriter.write(asciiArt);
        fileWriter.flush();
    }
}
