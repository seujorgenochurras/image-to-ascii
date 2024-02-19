package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;

public enum Algorithms {

    /**
     * Paints according to the rgb value that's the closest to white
     */
    BRIGHTEST_PIXEL(new BrightestAlgorithm()),


    /**
     * Paints according to the rgb value that's the lightest
     * <p>
     * It finds the lightest pixel by getting the sum of the brightest and the darkest pixel divided by 2
     */
    LIGHTEST_PIXEL(new LightestAlgorithm()),

    /**
     * Paints according to the darkest pixel color value
     */
    DARKEST_PIXEL(new DarkestPixelAlgorithm()),

    /**
     * Uses dark magic to find the brightness of the pixel <br>
     * Dark magic = math involving human eye cells, too much for me, just accept that it's better
     */
    HUMAN_EYE_ALGORITHM(new HumanEyeAlgorithm());

    private final BrightnessValueCalculator algorithm;

    Algorithms(BrightnessValueCalculator algorithm) {
        this.algorithm = algorithm;
    }


    public BrightnessValueCalculator getAlgorithm() {
        return algorithm;
    }
}
