package io.github.seujorgenochurras;

import com.sun.tools.jconsole.JConsoleContext;
import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;
import io.github.seujorgenochurras.video.buffer.BufferedAsciiVideoParser;
import io.github.seujorgenochurras.video.buffer.PixelAnalyzerBuffer;
import io.metaloom.video4j.Video4j;
import io.metaloom.video4j.VideoFile;
import io.metaloom.video4j.VideoStream;
import io.metaloom.video4j.Videos;
import io.metaloom.video4j.utils.ImageUtils;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            .withColor(ColorType.ANSI)
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
