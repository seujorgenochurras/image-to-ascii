package io.github.seujorgenochurras.image.ascii;


import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.ImageScale;
import io.github.seujorgenochurras.util.ArrayUtils;

import java.util.Arrays;

public class ParserConfig {
    private ImageScale scale;
    private String[] symbols;
    private BrightnessValueCalculator algorithm;
    private boolean isSymbolReversed;

    private ColorAlgorithm colorAlgorithm;

    public ParserConfig() {
    }

    public ImageScale getScale() {
        return scale;
    }

    public ParserConfig setScale(ImageScale scale) {
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
    public int hashCode() {
        int result = getScale() != null ? getScale().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getSymbols());
        result = 31 * result + (getAlgorithm() != null ? getAlgorithm().hashCode() : 0);
        result = 31 * result + (isSymbolReversed() ? 1 : 0);
        result = 31 * result + (getColorAlgorithm() != null ? getColorAlgorithm().hashCode() : 0);
        return result;
    }
}
