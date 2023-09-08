package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.color.symbol.SymbolList;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.AsciiAlgorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class Main {
    public static void main(String[] args) throws IOException {
        BetterImage betterImage = createImage("src/main/resources/jorge.png");
       SymbolList symbols = BestSymbolPatternFinder.findBestPattern(4, 55, getUTFChars(32, 129));
        System.out.println(symbols);
        System.out.println(symbols.size());

       AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols(symbols.getSymbolsAsStringArray())
                .scaled()
                .height(20)
                .width(50)
                .getScale()
                .parserAlgorithm(AsciiAlgorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
                .reversed(false)
                .withColor(ColorType.ANSI_LINUX)
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