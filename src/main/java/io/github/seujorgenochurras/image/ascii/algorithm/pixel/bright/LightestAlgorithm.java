package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;
import static io.github.seujorgenochurras.util.MathUtils.max;
import static io.github.seujorgenochurras.util.MathUtils.min;

public class LightestAlgorithm implements ParserAlgorithm {

    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return max(red, green, blue) / 2 + min(red, green, blue) / 2;
    }
}
