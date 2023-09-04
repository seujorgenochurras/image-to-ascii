package io.github.seujorgenochurras.image.ascii.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.AsciiBrightestAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.AsciiDarkestPixelAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.AsciiHumanEyeAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.AsciiLightestAlgorithm;

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

    HUMAN_EYE_ALGORITHM(new AsciiHumanEyeAlgorithm());

    private final AsciiParserAlgorithm algorithm;

    AsciiAlgorithms(AsciiParserAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public AsciiParserAlgorithm getAlgorithm() {
        return algorithm;
    }
}
