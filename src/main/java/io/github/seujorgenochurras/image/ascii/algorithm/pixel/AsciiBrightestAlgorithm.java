package io.github.seujorgenochurras.image.ascii.algorithm.std.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;

import static io.github.seujorgenochurras.util.MathUtils.max;

public class AsciiBrightestAlgorithm implements AsciiParserAlgorithm {
    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
       return max(red, blue, green);
    }
}
