package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiAlgorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.PixelScale;
import io.github.seujorgenochurras.image.ascii.algorithm.PixelScaleAlgorithm;

public class AsciiParserBuilder {
    private AsciiParserBuilder() {
    }

    private String[] brightnessSymbols = {"@", "#", "!", "."};

    private PixelScale pixelScale = new PixelScale(100, 100, PixelScaleAlgorithm.DEFAULT);
    public AsciiParserAlgorithm algorithm = AsciiAlgorithms.LIGHTEST_PIXEL.getAlgorithm();

    private boolean isSymbolReverted = false;

    public static AsciiParserBuilder startBuild() {
        return new AsciiParserBuilder();
    }

    public AsciiParserBuilder symbols(String... brightnessSymbols) {
        this.brightnessSymbols = brightnessSymbols;
        return this;
    }

    public PixelScaleConfig scaled() {
        return new PixelScaleConfig(this);
    }

    public AsciiParserBuilder parserAlgorithm(AsciiParserAlgorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public AsciiParserBuilder reversed(boolean isSymbolWhiteToBlack) {
        this.isSymbolReverted = isSymbolWhiteToBlack;
        return this;
    }

    public AsciiParserConfig build() {
        return new AsciiParserConfig(pixelScale, brightnessSymbols, algorithm, isSymbolReverted);
    }


    public static final class PixelScaleConfig {
        private final AsciiParserBuilder builder;

        private int width;
        private int height;
        private PixelScaleAlgorithm pixelScaleAlgorithm = PixelScaleAlgorithm.DEFAULT;


        private static PixelScaleConfig defaultConfig() {
            var defaultConf = new PixelScaleConfig(null);
            defaultConf.width = 140;
            defaultConf.height = 100;
            defaultConf.pixelScaleAlgorithm = PixelScaleAlgorithm.DEFAULT;
            return defaultConf;
        }

        public PixelScaleConfig(AsciiParserBuilder builder) {
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

        public AsciiParserBuilder getScale() {
            builder.pixelScale = new PixelScale(width, height, pixelScaleAlgorithm);
            return builder;
        }
    }
}
