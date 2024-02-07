package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;
import io.github.seujorgenochurras.video.buffer.BufferedAsciiVideoParser;
import io.github.seujorgenochurras.video.buffer.PixelAnalyzerBuffer;
import io.metaloom.video4j.Video4j;
import io.metaloom.video4j.VideoFile;
import io.metaloom.video4j.Videos;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class VideoTest {


    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 55, getUTFChars(32, 126)).getSymbolsAsStringArray();

    private static final long DESIRED_FPS = 30;

    private static final String VIDEO_PATH = "/home/little-jhey/Desktop/projetos/ascii-test/src/main/resources/video/out.mp4";

    public static void main(String[] args) throws InterruptedException {
        Video4j.init();
        VideoFile videoFile = Videos.open(VIDEO_PATH);

        PixelAnalyzerBuffer pixelAnalyzerBuffer = new PixelAnalyzerBuffer(videoFile, 25);

        pixelAnalyzerBuffer.startQueue();

        var bufferedAsciiVideoParser = new BufferedAsciiVideoParser(parserConfig, pixelAnalyzerBuffer,10);

        bufferedAsciiVideoParser.startQueue();

        System.out.print("\u001B[0J");
        Thread.sleep(5000);
        long videoLength = pixelAnalyzerBuffer.getVideoFileLength();
        new Thread(() -> {
            for(int i = 0; i < videoLength; i++){
                try {
                    Thread.sleep(1000 / DESIRED_FPS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String asciiArt = bufferedAsciiVideoParser.getAsciiArtQueue().poll();
                if (asciiArt == null) continue;
                System.out.print("\u001B[1;1H");
                System.out.print(asciiArt);
            }
        }).start();

    }

    private static final ParserConfig parserConfig = ParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(80)
            .width(180)
            .getScale()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .withColor(DefaultColorType.ANSI)
            .reversed(false)
            .build();

    public static String toAscii(BetterImage betterImage) {
        return AsciiParser.parse(betterImage, parserConfig);
    }
}
