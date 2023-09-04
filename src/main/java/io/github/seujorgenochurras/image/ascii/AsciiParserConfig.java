package io.github.seujorgenochurras.image.ascii;


import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.PixelScale;

public record AsciiParserConfig(PixelScale scale, String[] symbols, AsciiParserAlgorithm algorithm) {
}
