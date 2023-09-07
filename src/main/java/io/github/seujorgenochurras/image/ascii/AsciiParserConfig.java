package io.github.seujorgenochurras.image.ascii;


import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.PixelScale;
import io.github.seujorgenochurras.util.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public record AsciiParserConfig(PixelScale scale, String[] symbols, AsciiParserAlgorithm algorithm, boolean isSymbolReversed) {
    @Override
    public String[] symbols() {
        return isSymbolReversed? ArrayUtils.reverse(symbols) : symbols;
    }

    @Override
    public String toString() {
        return "AsciiParserConfig{" +
                "scale=" + scale +
                ", symbols=" + Arrays.toString(symbols) +
                ", algorithm=" + algorithm +
                ", isSymbolReversed=" + isSymbolReversed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsciiParserConfig that = (AsciiParserConfig) o;
        return isSymbolReversed == that.isSymbolReversed && Objects.equals(scale, that.scale) && Arrays.equals(symbols, that.symbols) && Objects.equals(algorithm, that.algorithm);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(scale, algorithm, isSymbolReversed);
        result = 31 * result + Arrays.hashCode(symbols);
        return result;
    }
}
