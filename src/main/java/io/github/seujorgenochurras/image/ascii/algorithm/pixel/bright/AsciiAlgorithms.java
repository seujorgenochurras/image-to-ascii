package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;

public enum AsciiAlgorithms {
    /***
     * Paints according to the rgb value that's the closest to white
     */
    BRIGHTEST_PIXEL(new AsciiBrightestAlgorithm()),


    /**
     * Paints according to the rgb value that's the lightest
     *
     * It finds the lightest pixel by getting the sum of the brightest and the darkest pixel divided by 2
     */
    LIGHTEST_PIXEL(new AsciiLightestAlgorithm()),

    DARKEST_PIXEL(new AsciiDarkestPixelAlgorithm()),

    /**
     * Uses dark magic to find the brightness of the pixel <br>
     * Dark magic = math involving human eye cells, too much for me, just accept that it's better
     */
    HUMAN_EYE_ALGORITHM(new AsciiHumanEyeAlgorithm());

    private final AsciiParserAlgorithm algorithm;

    AsciiAlgorithms(AsciiParserAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public AsciiParserAlgorithm getAlgorithm() {
        return algorithm;
    }
}
