package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;

public class AsciiParserBuilder {
    private AsciiParserBuilder() {
    }

    private String[] brightnessSymbols = {"@", "#", "!", "."};

    private int pixelScaleBefore = 1;
    private int pixelScaleAfter = 1;

  //  private AsciiParserAlgorithm algorithm = AsciiParserAlgorithm.Algorithms.DEFAULT_ALGORITHM;


    public static AsciiParserBuilder startBuild() {
        return new AsciiParserBuilder();
    }

    public AsciiParserBuilder symbols(String... brightnessSymbols) {
        this.brightnessSymbols = brightnessSymbols;
        return this;
    }

    public PixelScaleConfig pixelScale(int originalScale){
        this.pixelScaleBefore = originalScale;
        return new PixelScaleConfig(this);
    }

//    public AsciiParserBuilder algorithm(AsciiParserAlgorithm parserAlgorithm){
//        this.algorithm = parserAlgorithm;
//    }

    public AsciiParserConfig build() {
        return new AsciiParserConfig(pixelScaleBefore, pixelScaleAfter, brightnessSymbols);
    }

    public static final class PixelScaleConfig {
        private final AsciiParserBuilder builder;

        public PixelScaleConfig(AsciiParserBuilder builder) {
            this.builder = builder;
        }

        public AsciiParserBuilder to(int scale){
            builder.pixelScaleAfter = scale;
            return builder;
        }
    }
}
