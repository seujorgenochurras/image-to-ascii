package io.github.seujorgenochurras.demo;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;
import io.metaloom.video4j.Video4j;
import nu.pattern.OpenCV;
import org.opencv.videoio.VideoCapture;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class VideoToAsciiAnimation {


    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 55, getUTFChars(32, 126)).toArray();

    private static final long DESIRED_FPS = 30;

    private static final String VIDEO_PATH = "/home/little-jhey/Desktop/projetos/ascii-test/src/main/resources/video/out.mp4";
    private static final ParserConfig parserConfig = ParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(80)
            .width(180)
            .getScale()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .colorAlgorithm(DefaultColorType.ANSI)
            .reversed(false)
            .build();

    public static void main(String[] args) throws InterruptedException {
        System.loadLibrary("ffmepg");

        OpenCV.loadShared();
        OpenCV.loadLocally();
        Video4j.init();
        VideoCapture a = new VideoCapture(VIDEO_PATH);
        Thread.sleep(4000);
        System.out.println(a.isOpened());


//        VideoFile videoFile = Videos.get(VIDEO_PATH);
//
//
//        PixelAnalyzerBuffer pixelAnalyzerBuffer = new PixelAnalyzerBuffer(videoFile, 25);
//
//        pixelAnalyzerBuffer.startQueue();
//
//        var bufferedAsciiVideoParser = new BufferedAsciiVideoParser(parserConfig, pixelAnalyzerBuffer, 10);
//
//        bufferedAsciiVideoParser.startQueue();
//
//        System.out.print("\u001B[0J");
//        long videoLength = pixelAnalyzerBuffer.getVideoFileLength();
//        new Thread(() -> {
//            for (int i = 0; i < videoLength; i++) {
//                try {
//                    Thread.sleep(1000 / DESIRED_FPS);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                String asciiArt = bufferedAsciiVideoParser.getAsciiArtQueue().poll();
//                if (asciiArt == null) continue;
//                System.out.print("\u001B[1;1H");
//                System.out.print(asciiArt);
//            }
//        }).start();

    }

    public static String toAscii(BetterImage betterImage) {
        return AsciiParser.parse(betterImage, parserConfig);
    }
}
