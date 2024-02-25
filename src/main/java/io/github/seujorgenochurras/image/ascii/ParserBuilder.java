package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.ColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.ImageScale;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.ImageScaleAlgorithm;
import io.github.seujorgenochurras.validator.ParserBuilderValidator;


public class ParserBuilder {
    private String[] brightnessSymbols = {"@", "#", "!", "."};
    private ImageScale imageScale = new ImageScale(100, 100, ImageScaleAlgorithm.DEFAULT);
    private BrightnessValueCalculator algorithm = Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm();
    private ColorAlgorithm colorizeAlgorithm = DefaultColorType.NONE.getAlgorithm();
    private boolean isSymbolReverted = false;

    private ParserBuilder() {
    }

    public static ParserBuilder startBuild() {
        return new ParserBuilder();
    }

    /**
     * Sets the symbols to be used in the ascii art
     *
     * @param symbols from darkest to brightest
     */
    public ParserBuilder symbols(String... symbols) {
        this.brightnessSymbols = symbols;
        return this;
    }

    /**
     * Starts the image scale builder
     *
     * @return PixelScaleBuilder
     */
    public ImageScaleConfig scaled() {
        return new ImageScaleConfig(this);
    }

    /**
     * Sets the Brightness value algorithm
     *
     * @param algorithm Brightness value algorithm
     * @return builder
     */
    public ParserBuilder parserAlgorithm(BrightnessValueCalculator algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    /**
     * Sets the Brightness value algorithm
     *
     * @param algorithm Brightness value algorithm
     * @return builder
     */
    public ParserBuilder parserAlgorithm(Algorithms algorithm) {
        this.algorithm = algorithm.getAlgorithm();
        return this;
    }

    /**
     * Reverses the brightness value meaning.<br> So a value of 1 means bright, and 255 means dark
     *
     * @param whiteToBlack if true then 1 = bright and 255 = dark
     * @return builder
     */
    public ParserBuilder reversed(boolean whiteToBlack) {
        this.isSymbolReverted = whiteToBlack;
        return this;
    }

    /**
     * Sets the symbol color algorithm
     *
     * @param defaultColorType color algorithm
     * @return builder
     */
    public ParserBuilder colorAlgorithm(DefaultColorType defaultColorType) {
        colorAlgorithm(defaultColorType.getAlgorithm());
        return this;
    }

    /**
     * Sets the pixel to be colored
     *
     * @param colorAlgorithm the algorithm to colorize your characters
     * @return builder
     */
    public ParserBuilder colorAlgorithm(ColorAlgorithm colorAlgorithm) {
        this.colorizeAlgorithm = colorAlgorithm;
        return this;
    }

    /**
     * @return your pixelParserConfig ready to be used
     */
    public ParserConfig build() {
        validateFields();

        return new ParserConfig()
                .setScale(imageScale)
                .setSymbols(brightnessSymbols)
                .setAlgorithm(algorithm)
                .setSymbolReversed(isSymbolReverted)
                .setColorAlgorithm(colorizeAlgorithm);

    }

    /**
     * Validate {@link ParserBuilder} fields
     */
    private void validateFields() {
        //Unless you've defined fields as null, there really isn't much to validate
        new ParserBuilderValidator()
                .validateSymbols(brightnessSymbols);
    }


    /**
     * Image scaling configurator <br>
     * This class is used to configure your image scale
     */
    public static final class ImageScaleConfig {

        private final ParserBuilder builder;
        private int width;
        private int height;
        private ImageScaleAlgorithm imageScaleAlgorithm = ImageScaleAlgorithm.DEFAULT;

        public ImageScaleConfig(ParserBuilder builder) {
            this.builder = builder;
        }

        /**
         * Sets the width of new image
         *
         * @param width new image width
         * @return builder
         */
        public ImageScaleConfig width(int width) {
            this.width = width;
            return this;
        }

        /**
         * Sets the scale height
         *
         * @param height new image height
         * @return builder
         */
        public ImageScaleConfig height(int height) {
            this.height = height;
            return this;
        }

        /**
         * Sets the image scaling algorithm, this doesn't change much
         *
         * @param algorithm scale algorithm
         * @return builder
         */
        public ImageScaleConfig algorithm(ImageScaleAlgorithm algorithm) {
            this.imageScaleAlgorithm = algorithm;
            return this;
        }

        /**
         * @return the built pixelScaleConfig
         */
        public ParserBuilder getScale() {
            builder.imageScale = new ImageScale(width, height, imageScaleAlgorithm);
            return builder;
        }
    }
}
