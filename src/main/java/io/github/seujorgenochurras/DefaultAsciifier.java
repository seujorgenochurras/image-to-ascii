package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class DefaultAsciifier {

    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 55, getUTFChars(32, 126)).toArray();

    private DefaultAsciifier() {
        //Utility class
    }


    public static String toAscii(String imagePath) {
        ParserConfig parserConfig = ParserBuilder.startBuild()
                .symbols(symbols)
                .colorAlgorithm(DefaultColorType.ANSI)
                .build();
        return toAscii(new BetterImage(imagePath), parserConfig);
    }


    public static String toAscii(String imagePath, int width, int height, boolean withAnsiColor) {
        ParserBuilder parserBuilder = ParserBuilder.startBuild()
                .symbols(symbols)
                .scaled()
                .height(height)
                .width(width)
                .getScale();

        if (Boolean.TRUE.equals(withAnsiColor)) {
            parserBuilder.colorAlgorithm(DefaultColorType.ANSI);
        }
        ParserConfig parserConfig = parserBuilder.build();

        return toAscii(new BetterImage(imagePath), parserConfig);
    }

    public static String toAscii(BetterImage betterImage, ParserConfig parserConfig) {
        return AsciiParser.parse(betterImage, parserConfig);
    }

}
