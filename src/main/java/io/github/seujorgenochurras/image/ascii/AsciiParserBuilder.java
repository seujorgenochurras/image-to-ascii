package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.PixelScaleAlgorithm;

public class AsciiParserBuilder {
    private AsciiParserBuilder() {
    }

    private String[] brightnessSymbols = {"@", "#", "!", "."};

    private PixelScaleConfig pixelScaleConfig = PixelScaleConfig.defaultConfig();

    public static AsciiParserBuilder startBuild() {
        return new AsciiParserBuilder();
    }

    public AsciiParserBuilder symbols(String... brightnessSymbols) {
        this.brightnessSymbols = brightnessSymbols;
        return this;
    }

    public PixelScaleConfig scaled(){
        return new PixelScaleConfig(this);
    }

    public AsciiParserConfig build() {
        return new AsciiParserConfig(pixelScaleConfig, brightnessSymbols);
    }

    public static final class PixelScaleConfig {
        private final AsciiParserBuilder builder;

        private int width;
        private int height;
        private PixelScaleAlgorithm pixelScaleAlgorithm = PixelScaleAlgorithm.DEFAULT;


        private static PixelScaleConfig defaultConfig(){
            var defaultConf = new PixelScaleConfig(null);
            defaultConf.width = 140;
            defaultConf.height = 100;
            defaultConf.pixelScaleAlgorithm = PixelScaleAlgorithm.DEFAULT;
            return defaultConf;
        }

        public PixelScaleConfig(AsciiParserBuilder builder) {
            this.builder = builder;
        }

        public PixelScaleConfig width(int width){
            this.width = width;
            return this;
        }
        public PixelScaleConfig height(int height){
            this.height = height;
            return this;
        }
        public PixelScaleConfig algorithm(PixelScaleAlgorithm algorithm){
            this.pixelScaleAlgorithm = algorithm;
            return this;
        }
        public AsciiParserBuilder getScale(){
            builder.pixelScaleConfig = this;
            return builder;
        }
    }
}
