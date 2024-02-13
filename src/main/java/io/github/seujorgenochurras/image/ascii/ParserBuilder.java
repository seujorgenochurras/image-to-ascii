package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;


public class ParserBuilder {
    private String[] brightnessSymbols = {"@", "#", "!", "."};
    private PixelScale pixelScale = new PixelScale(100, 100, PixelScaleAlgorithm.DEFAULT);
    private ParserAlgorithm algorithm = Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm();
    private ColorAlgorithm colorizeAlgorithm = DefaultColorType.NONE.getAlgorithm();
    private boolean isSymbolReverted = false;

    private ParserBuilder() {
    }

    public static ParserBuilder startBuild() {
        return new ParserBuilder();
    }

    /**
     * Sets the symbols to be used in the ascii art
     * @param symbols from darkest to brightest
     *
     */
    public ParserBuilder symbols(String... symbols) {
        this.brightnessSymbols = symbols;
        return this;
    }

    /**
     * Starts the image scale builder
     * @return PixelScaleBuilder
     */
    public PixelScaleConfig scaled() {
        return new PixelScaleConfig(this);
    }

    public ParserBuilder parserAlgorithm(ParserAlgorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public ParserBuilder parserAlgorithm(Algorithms algorithm) {
        this.algorithm = algorithm.getAlgorithm();
        return this;
    }
    public ParserBuilder reversed(boolean isSymbolWhiteToBlack) {
        this.isSymbolReverted = isSymbolWhiteToBlack;
        return this;
    }

    public ParserBuilder colorAlgorithm(DefaultColorType defaultColorType) {
        colorAlgorithm(defaultColorType.getAlgorithm());
        return this;
    }

    /**
     * Sets the pixel to be colored
     * @param colorAlgorithm the algorithm to colorize your characters
     * @return builder
     */
    public ParserBuilder colorAlgorithm(ColorAlgorithm colorAlgorithm) {
        this.colorizeAlgorithm = colorAlgorithm;
        return this;
    }

    /**
     *
     * @return your pixelParserConfig ready to be used
     */
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

        /**
         * Sets the image scaling algorithm, this doesn't change much
         * @param algorithm
         * @return
         */
        public PixelScaleConfig algorithm(PixelScaleAlgorithm algorithm) {
            this.pixelScaleAlgorithm = algorithm;
            return this;
        }

        /**
         *
         * @return the built pixelScaleConfig
         */
        public ParserBuilder getScale() {
            builder.pixelScale = new PixelScale(width, height, pixelScaleAlgorithm);
            return builder;
        }
    }
}
