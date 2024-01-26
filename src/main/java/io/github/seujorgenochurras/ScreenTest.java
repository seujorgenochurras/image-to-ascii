package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;

import java.awt.*;
import java.awt.image.BufferedImage;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class ScreenTest {
    public static final String[] symbols = BestSymbolPatternFinder.
            findBestPattern(1, 55, getUTFChars(32, 126)).getSymbolsAsStringArray();

    public static final ParserConfig defaultParserConfig = ParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(100)
            .width(600)
            .getScale()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .withColor(DefaultColorType.ANSI)
            .reversed(false)
            .build();


    public static void main(String[] args) throws AWTException {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Robot robot = new Robot();
        System.out.print("\u001b[2J");

        while (true) {
            BufferedImage capture = robot.createScreenCapture(screenRect);
            System.out.print("\u001B[1;1H");
            System.out.print(DefaultAsciifier.toAscii(capture, defaultParserConfig));

        }

    }

}
