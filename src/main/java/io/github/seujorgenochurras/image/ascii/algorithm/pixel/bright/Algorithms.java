package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;

public enum Algorithms {
    /***
     * Paints according to the rgb value that's the closest to white
     */
    BRIGHTEST_PIXEL(new BrightestAlgorithm()),


    /**
     * Paints according to the rgb value that's the lightest
     *
     * It finds the lightest pixel by getting the sum of the brightest and the darkest pixel divided by 2
     */
    LIGHTEST_PIXEL(new LightestAlgorithm()),

    DARKEST_PIXEL(new DarkestPixelAlgorithm()),

    /**
     * Uses dark magic to find the brightness of the pixel <br>
     * Dark magic = math involving human eye cells, too much for me, just accept that it's better
     */
    HUMAN_EYE_ALGORITHM(new HumanEyeAlgorithm());

    private final ParserAlgorithm algorithm;

    Algorithms(ParserAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public ParserAlgorithm getAlgorithm() {
        return algorithm;
    }
}
