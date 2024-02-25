package io.github.seujorgenochurras.demo;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class ScreenParser {
    public static final String[] symbols = BestSymbolPatternFinder.
            findBestPattern(2, 55, getUTFChars(32, 126)).toArray();


    public static final ParserBuilder defaultParserConfig = ParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(80)
            .width(400)
            .getScale()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .colorAlgorithm(DefaultColorType.ANSI);


    public static void main(String[] args) throws AWTException {
        if (args.length < 1) {
            args = new String[3];
            args[0] = "80";
            args[1] = "300";
            args[2] = "false";
        }


        final ParserBuilder defaultParserConfigBuilder = ParserBuilder.startBuild()
                .symbols(symbols)
                .scaled()
                .height(Integer.parseInt(args[1]))
                .width(Integer.parseInt(args[0]))
                .getScale()
                .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm());

        if (args[2].equals("true")) {
            defaultParserConfigBuilder.colorAlgorithm(new AnsiColorAlgorithm());
        }
        var defaultParserConfig = defaultParserConfigBuilder.build();

        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(screenDimension);
        Robot robot = new Robot();
        System.out.print("\u001b[2J");
        final double[] fps = {1};
        final int[] framesThisSecond = {0};
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                fps[0] = framesThisSecond[0];
                framesThisSecond[0] = 0;

            }
        };
        Timer timer = new Timer("Timer");
        int delay = 1000;
        timer.scheduleAtFixedRate(task, 0, delay);

        var screenShot = robot.createScreenCapture(screenRect);

        int i = 0;

        while (true) {
            if (i < 100) {
                screenShot = robot.createScreenCapture(screenRect);
                i = 0;
            }
            i++;
            framesThisSecond[0]++;
            System.out.print("\u001B[0;0H");
            System.out.print(AsciiParser.parse(new BetterImage(screenShot), defaultParserConfig).indexOf(i));
            System.out.println("\u001B[0;0H Current fps: " + fps[0]);
        }
    }

}
