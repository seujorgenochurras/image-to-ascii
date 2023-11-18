package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AsciiParser {

    private AsciiParser(){}

    public static String parse(BetterImage betterImage, ParserConfig parserConfig){
        var pixelLightSymbols = parserConfig.getSymbols();
        int symbolsGap = 256 / (pixelLightSymbols.length);

        BetterImage scaledImage = scaleImage(betterImage, parserConfig.getScale());


        StringBuilder builder = new StringBuilder();
        scaledImage.getPixels().forEach(pixel -> {
            var color = pixel.color;

            int red = color.getRed().getColorValue();
            int green = color.getGreen().getColorValue();
            int blue = color.getBlue().getColorValue();

            int pixelColorRepresentation =(int) parserConfig.getAlgorithm().getPixelRepresentation(red, green, blue);

            String symbol = getSymbol(pixelColorRepresentation, symbolsGap, pixelLightSymbols);
            String symbolColorRepresentation = parserConfig.getColorAlgorithm().getColorRepresentation(color);

            builder.append(symbolColorRepresentation).append(symbol);

            if (isBorderPixel(pixel.x, scaledImage)) builder.append("\n");

        });
        return builder.toString();
    }

    private static String getSymbol(int brightness, int symbolsGap, String[] pixelLightSymbols){
        int symbolIndex = (int) (brightness / (float) symbolsGap) ;

        if(symbolIndex < 0 ){
            symbolIndex = 0;
        }else if (symbolIndex > pixelLightSymbols.length -1){
            symbolIndex = pixelLightSymbols.length -1;
        }

        return pixelLightSymbols[symbolIndex];
    }

    private static boolean isBorderPixel(int width, BetterImage betterImage){
        return width == betterImage.getBufferedImage().getWidth() -1;
    }

    private static BetterImage scaleImage(BetterImage image, PixelScale scale){
        int width = scale.width();
        int height = scale.height();
        int algorithm = scale.scaleAlgorithm().getId();

        var bufferedImage = image.getBufferedImage();

        Image scaledImage = bufferedImage.getScaledInstance(width, height, algorithm);

        BufferedImage scaledImageBuffer = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        Graphics2D scaledImageGraphics = scaledImageBuffer.createGraphics();
        scaledImageGraphics.drawImage(scaledImage, 0, 0, null);
        scaledImageGraphics.dispose();

        return new BetterImage(scaledImageBuffer);
    }
}
