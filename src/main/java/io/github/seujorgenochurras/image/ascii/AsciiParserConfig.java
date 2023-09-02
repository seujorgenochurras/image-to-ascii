package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.Image;
import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;
import io.github.seujorgenochurras.util.ArrayUtils;

public class AsciiParserConfig {
    private final int pixelScaleBefore;

    private final int pixelScaleAfter;

    private final String[] pixelLightSymbols;

   // private final AsciiParserAlgorithm parserAlgorithm;

    public AsciiParserConfig(int pixelScaleBefore, int pixelScaleAfter, String[] symbols) {
        this.pixelScaleBefore = pixelScaleBefore;
        this.pixelScaleAfter = pixelScaleAfter;

        this.pixelLightSymbols = ArrayUtils.reverse(symbols);
        symbolsGap = 256 / (getPixelLightSymbols().length);
    }

    private final int symbolsGap;
    private String getSymbol(int brightness){
        int symbolIndex = (int) (brightness / (float) symbolsGap) ;

        if(symbolIndex < 0 ){
            symbolIndex = 0;
        }else if (symbolIndex > pixelLightSymbols.length -1){
            symbolIndex = pixelLightSymbols.length -1;
        }

        return pixelLightSymbols[symbolIndex];
    }

    String parse(Image image) {
        StringBuilder builder = new StringBuilder();

        image.getPixels().forEach(pixel -> {
            int maxBright = pixel.getBrightestPixel();

            String symbol = getSymbol(maxBright);
            builder.append(symbol);

            if (isBorderPixel(pixel.x, image)) builder.append("\n");
        });
        return builder.toString();
    }
    private boolean isBorderPixel(int pixelPosition, Image image){

        return pixelPosition == image.getBufferedImage().getWidth() -1;
    }

    public int getPixelScaleBefore() {
        return pixelScaleBefore;
    }

    public String[] getPixelLightSymbols() {
        return pixelLightSymbols;
    }

}
