package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorType;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;


public class ParserBuilder {
    private ParserBuilder() {
    }

    private String[] brightnessSymbols = {"@", "#", "!", "."};

    private PixelScale pixelScale = new PixelScale(100, 100, PixelScaleAlgorithm.DEFAULT);
    private ParserAlgorithm algorithm = Algorithms.LIGHTEST_PIXEL.getAlgorithm();

    private ColorAlgorithm colorizeAlgorithm = ColorType.NONE.getAlgorithm();

    private boolean isSymbolReverted = false;

    public static ParserBuilder startBuild() {
        return new ParserBuilder();
    }

    public ParserBuilder symbols(String... brightnessSymbols) {
        this.brightnessSymbols = brightnessSymbols;
        return this;
    }

    public PixelScaleConfig scaled() {
        return new PixelScaleConfig(this);
    }

    public ParserBuilder parserAlgorithm(ParserAlgorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public ParserBuilder reversed(boolean isSymbolWhiteToBlack) {
        this.isSymbolReverted = isSymbolWhiteToBlack;
        return this;
    }

    public ParserBuilder withColor(ColorType colorType){
        this.colorizeAlgorithm = colorType.getAlgorithm();
        return this;
    }

    public ParserConfig build() {

        return new ParserConfig()
                .setScale(pixelScale)
                .setSymbols(brightnessSymbols)
                .setAlgorithm(algorithm)
                .setSymbolReversed(isSymbolReverted)
                .setColorAlgorithm(colorizeAlgorithm);

    }


    public static final class PixelScaleConfig {
        private final ParserBuilder builder;

        private int width;
        private int height;
        private PixelScaleAlgorithm pixelScaleAlgorithm = PixelScaleAlgorithm.DEFAULT;

        public PixelScaleConfig(ParserBuilder builder) {
            this.builder = builder;
        }

        public PixelScaleConfig width(int width) {
            this.width = width;
            return this;
        }

        public PixelScaleConfig height(int height) {
            this.height = height;
            return this;
        }

        public PixelScaleConfig algorithm(PixelScaleAlgorithm algorithm) {
            this.pixelScaleAlgorithm = algorithm;
            return this;
        }

        public ParserBuilder getScale() {
            builder.pixelScale = new PixelScale(width, height, pixelScaleAlgorithm);
            return builder;
        }
    }
}
