package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;

import java.awt.*;
import java.awt.image.BufferedImage;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class DefaultAsciifier {
    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 55, getUTFChars(32, 126)).getSymbolsAsStringArray();
    public static final ParserConfig defaultParserConfig = ParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(120)
            .width(180)
            .getScale()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .withColor(ColorType.ANSI)
            .reversed(false)
            .build();

    public static String toAscii(BetterImage betterImage) {
        return AsciiParser.parse(betterImage, defaultParserConfig);
    }
    public static String toAscii(Image image){
        return AsciiParser.parse(new BetterImage(toBufferedImage(image)), defaultParserConfig);
    }
    public static String toAscii(BetterImage betterImage, ParserConfig parserConfig) {
        return AsciiParser.parse(betterImage, parserConfig);
    }
    public static String toAscii(Image image, ParserConfig parserConfig){
        return AsciiParser.parse(new BetterImage(toBufferedImage(image)), parserConfig);
    }


    private static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bufferedImage;
    }
}
