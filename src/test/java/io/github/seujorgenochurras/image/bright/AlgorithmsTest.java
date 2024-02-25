package io.github.seujorgenochurras.image.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.BrightestAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.DarkestPixelAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.HumanEyeAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.LightestAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgorithmsTest {

    private static final HumanEyeAlgorithm humanEyeAlgorithm = new HumanEyeAlgorithm();
    private static final BrightestAlgorithm brightestAlgorithm = new BrightestAlgorithm();
    private static final DarkestPixelAlgorithm darkestPixelAlgorithm = new DarkestPixelAlgorithm();
    private static final LightestAlgorithm lightestAlgorithm = new LightestAlgorithm();

    @Test
    void givenColor_whenIsDark_thenReturnLowBrightnessValue() {
        int red = 3;
        int green = 12;
        int blue = 21;

        int humanEye = humanEyeAlgorithm.getBrightnessValue(red, green, blue);
        int brightestAlgo = brightestAlgorithm.getBrightnessValue(red, green, blue);
        int darkest = darkestPixelAlgorithm.getBrightnessValue(red, green, blue);
        int lightest = lightestAlgorithm.getBrightnessValue(red, green, blue);

        assertTrue(humanEye < 50);
        assertTrue(brightestAlgo < 50);
        assertTrue(darkest < 50);
        assertTrue(lightest < 50);

    }

    @Test
    void givenColor_whenIsWhite_thenReturnHighBrightnessValue() {
        int red = 200;
        int green = 122;
        int blue = 221;

        int humanEye = humanEyeAlgorithm.getBrightnessValue(red, green, blue);
        int brightestAlgo = brightestAlgorithm.getBrightnessValue(red, green, blue);
        int darkest = darkestPixelAlgorithm.getBrightnessValue(red, green, blue);
        int lightest = lightestAlgorithm.getBrightnessValue(red, green, blue);

        assertTrue(humanEye > 70);
        assertTrue(brightestAlgo > 70);
        assertTrue(darkest > 70);
        assertTrue(lightest > 70);

    }
}
