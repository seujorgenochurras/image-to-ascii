package io.github.seujorgenochurras.image.ascii.algorithm.std.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;

import static io.github.seujorgenochurras.util.MathUtils.min;

public class AsciiDarkestPixelAlgorithm implements AsciiParserAlgorithm {
    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return min(red, green, blue);
    }
}
