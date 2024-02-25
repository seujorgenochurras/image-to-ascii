package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import io.github.seujorgenochurras.util.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsciiParserTest {

    private static final String testImagePath = "src/test/resources/image/car.png";
    private static final BetterImage testBetterImage = new BetterImage(testImagePath);

    private final ParserBuilder testParserConfig = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM)
            .scaled()
            .height(50)
            .width(100)
            .getScale()
            .symbols("")
            .colorAlgorithm(new AnsiColorAlgorithm());

    @Test
    void givenTestImage_whenHasSymbol_thenParseAscii() {
        String[] symbols = new String[]{" ", ".", "-", "w", "W", "@"};
        final ParserConfig parserConfig = testParserConfig
                .symbols(" ", ".", "-", "w", "W", "@")
                .build();

        String asciiArt = AsciiParser.parse(testBetterImage, parserConfig);
        String asciiArt2 = AsciiParser.parse(testImagePath, parserConfig);

        boolean asciiUsesAllSymbols = StringUtils.containsAll(asciiArt, symbols);
        boolean ascii2UsesAllSymbols = StringUtils.containsAll(asciiArt2, symbols);

        assertTrue(asciiUsesAllSymbols);
        assertTrue(ascii2UsesAllSymbols);
    }

    @Test
    void givenImagePath_whenPathDoesntExist_thenThrowIOException() {
        final ParserConfig parserConfig = testParserConfig
                .symbols(" ", ".", "-", "w", "W", "@")
                .build();

        assertThrows(RuntimeException.class, () -> AsciiParser.parse("awd aw ", parserConfig));
    }


}
