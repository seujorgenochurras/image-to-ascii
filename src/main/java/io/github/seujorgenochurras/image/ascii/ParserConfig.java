package io.github.seujorgenochurras.image.ascii;


import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.util.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class ParserConfig {
    private PixelScale scale;
    private String[] symbols;
    private BrightnessValueCalculator algorithm;
    private boolean isSymbolReversed;

    private ColorAlgorithm colorAlgorithm;

    public ParserConfig() {
    }

    public PixelScale getScale() {
        return scale;
    }

    public ParserConfig setScale(PixelScale scale) {
        this.scale = scale;
        return this;
    }

    public String[] getSymbols() {
        return isSymbolReversed() ? ArrayUtils.reverse(symbols) : symbols;
    }

    public ParserConfig setSymbols(String[] symbols) {
        this.symbols = symbols;
        return this;
    }

    public ColorAlgorithm getColorAlgorithm() {
        return colorAlgorithm;
    }

    public ParserConfig setColorAlgorithm(ColorAlgorithm colorAlgorithm) {
        this.colorAlgorithm = colorAlgorithm;
        return this;
    }

    public BrightnessValueCalculator getAlgorithm() {
        return algorithm;
    }

    public ParserConfig setAlgorithm(BrightnessValueCalculator algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public boolean isSymbolReversed() {
        return isSymbolReversed;
    }

    public ParserConfig setSymbolReversed(boolean symbolReversed) {
        isSymbolReversed = symbolReversed;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParserConfig that = (ParserConfig) o;
        return isSymbolReversed == that.isSymbolReversed &&
                Objects.equals(getScale(), that.getScale()) &&
                Arrays.equals(getSymbols(), that.getSymbols()) &&
                Objects.equals(getAlgorithm(), that.getAlgorithm());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(scale, algorithm, isSymbolReversed);
        result = 31 * result + Arrays.hashCode(symbols);
        return result;
    }
}
