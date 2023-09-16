package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.AsciiAlgorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;
import io.metaloom.video4j.Video4j;
import io.metaloom.video4j.VideoFile;
import io.metaloom.video4j.Videos;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class VideoTest {


    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(1, 55, getUTFChars(32, 126)).getSymbolsAsStringArray();

    private static final long DESIRED_FPS = 9;

    public static void main(String[] args) throws InterruptedException {
        Video4j.init();

        for (int i = 0; i < 10; i++) {
            VideoFile videoFile = Videos.open("/home/little-jhey/Desktop/projetos/ascii-test/src/main/resources/video/boobs.gif");

            while (videoFile.currentFrame() < videoFile.length()) {
                System.out.print("\u001B[1;1H");
                var betterImage = new BetterImage(videoFile.frameToImage());
                System.out.print(toAscii(betterImage));
                Thread.sleep(1000 / DESIRED_FPS);
            }
        }
    }

    private static final AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
            .symbols(symbols)
            .scaled()
            .height(80)
            .width(160)
            .getScale()
            .parserAlgorithm(AsciiAlgorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .withColor(ColorType.ANSI)
            .build();

    public static String toAscii(BetterImage betterImage) {
        return AsciiParser.parse(betterImage, parserConfig);
    }
}
