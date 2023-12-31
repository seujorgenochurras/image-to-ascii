package io.github.seujorgenochurras.image.ascii;


import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AsciiColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.util.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class AsciiParserConfig {
   private PixelScale scale;
   private String[] symbols;
   private AsciiParserAlgorithm algorithm;
   private boolean isSymbolReversed;

   private AsciiColorAlgorithm colorAlgorithm;

    public AsciiParserConfig() {
    }

    public PixelScale getScale() {
        return scale;
    }

    public AsciiParserConfig setScale(PixelScale scale) {
        this.scale = scale;
        return this;
    }

    public String[] getSymbols() {
        return isSymbolReversed? ArrayUtils.reverse(symbols) : symbols;
    }

    public AsciiColorAlgorithm getColorAlgorithm() {
        return colorAlgorithm;
    }

    public AsciiParserConfig setColorAlgorithm(AsciiColorAlgorithm colorAlgorithm) {
        this.colorAlgorithm = colorAlgorithm;
        return this;
    }

    public AsciiParserConfig setSymbols(String[] symbols) {
        this.symbols = symbols;
        return this;
    }

    public AsciiParserAlgorithm getAlgorithm() {
        return algorithm;
    }

    public AsciiParserConfig setAlgorithm(AsciiParserAlgorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public boolean isSymbolReversed() {
        return isSymbolReversed;
    }

    public AsciiParserConfig setSymbolReversed(boolean symbolReversed) {
        isSymbolReversed = symbolReversed;
        return this;
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
