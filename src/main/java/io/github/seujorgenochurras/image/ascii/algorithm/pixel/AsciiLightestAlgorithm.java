package io.github.seujorgenochurras.image.ascii.algorithm.std.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import static io.github.seujorgenochurras.util.MathUtils.max;
import static io.github.seujorgenochurras.util.MathUtils.min;

public class AsciiLightestAlgorithm implements AsciiParserAlgorithm {

    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return max(red, green, blue) / 2 + min(red, green, blue) / 2;
    }
}
