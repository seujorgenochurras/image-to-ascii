package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.util.ArrayUtils;

import static io.github.seujorgenochurras.image.ascii.AsciiParserBuilder.PixelScaleConfig;

public class AsciiParserConfig {

    private final PixelScaleConfig pixelScaleConfig;
    private final String[] pixelLightSymbols;


    public AsciiParserConfig(PixelScaleConfig pixelScaleConfig, String[] symbols) {
        this.pixelScaleConfig = pixelScaleConfig;

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

    String parse(BetterImage betterImage) {
        StringBuilder builder = new StringBuilder();

        betterImage.getPixels().forEach(pixel -> {
            int maxBright = pixel.getBrightestPixel();

            String symbol = getSymbol(maxBright);
            builder.append(symbol);

            if (isBorderPixel(pixel.x, betterImage)) builder.append("\n");
        });
        return builder.toString();
    }
    private boolean isBorderPixel(int pixelPosition, BetterImage betterImage){
        return pixelPosition == betterImage.getBufferedImage().getWidth() -1;
    }

    public String[] getPixelLightSymbols() {
        return pixelLightSymbols;
    }

}
