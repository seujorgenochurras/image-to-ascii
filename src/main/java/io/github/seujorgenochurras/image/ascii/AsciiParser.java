package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.exception.NoSymbolException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsciiParser {

    private static final Logger logger = Logger.getLogger("AsciiParser");

    private AsciiParser() {
    }


    /**
     * Overloaded method of {@link AsciiParser#parse(BetterImage, ParserConfig)}
     */
    public static String parse(String imagePath, ParserConfig parserConfig) {
        File imageFile = new File(imagePath);
        try {
            BetterImage betterImage = new BetterImage(ImageIO.read(imageFile));
            return parse(betterImage, parserConfig);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Generates ASCII art from your image by going through each pixel and
     * calculating its representation according to the algorithm defined in {@link ParserConfig}.<br><br>
     * <p>
     * If your ParserConfig have less than 256 symbols, then the symbol representation will be defined in a symbolGap. <br>
     * A symbolGap is how many brightness values one character might represent:<br>
     * For instance, if you have a list with 128 symbols, then you have a symbol gap of 256 / 128 which is 2
     * so this means that each symbol represents 2 brightness units.<br>
     * A brightness unit is defined by the shades of white to black,
     * the maximum brightness a pixel/symbol can reach is 255, and the minimum 0.
     *
     * @param betterImage  image instance
     * @param parserConfig AsciiParserConfig, must be built with {@link ParserBuilder}
     * @return ASCII art
     */
    public static String parse(BetterImage betterImage, ParserConfig parserConfig) {
        String[] pixelLightSymbols = parserConfig.getSymbols();
        //TODO validator
        if (pixelLightSymbols.length <= 1) {
            throw new NoSymbolException("No symbols provided");
        }

        int symbolsGap = 255 / pixelLightSymbols.length;

        BetterImage scaledImage = betterImage.getScaledInstance(parserConfig.getScale());

        StringBuilder builder = new StringBuilder();
        scaledImage.getPixels().forEach(pixel -> {
            var color = pixel.getColor();

            int red = color.getRed().getColorValue();
            int green = color.getGreen().getColorValue();
            int blue = color.getBlue().getColorValue();

            int pixelBrightness = parserConfig.getAlgorithm().getPixelRepresentation(red, green, blue);

            String symbol = getSymbol(pixelBrightness, symbolsGap, pixelLightSymbols);
            String symbolColorRepresentation = parserConfig.getColorAlgorithm().getColorRepresentation(color);

            builder.append(symbolColorRepresentation).append(symbol);

            if (scaledImage.isLateralBorderPixel(pixel.x)) builder.append("\n");

        });
        return builder.toString();
    }


    /**
     * Calculates and returns an element according to a brightness value on an element array.
     *
     * @param brightness        element brightness value, should not pass 256 and should not be negative
     * @param symbolsGap        how many brightness units a symbol can represents, see {@link AsciiParser#parse}
     * @param pixelLightSymbols Array containing all the possible symbols
     * @return The element according to the given brightness value
     */
    public static <T> T getSymbol(int brightness, int symbolsGap, T[] pixelLightSymbols) {
        int symbolIndex = brightness / symbolsGap;

        int symbolsLastIndex = pixelLightSymbols.length - 1;

        if (symbolIndex < 0) {
            symbolIndex = 0;
        } else if (symbolIndex > symbolsLastIndex) {
            symbolIndex = symbolsLastIndex;
        }

        return pixelLightSymbols[symbolIndex];
    }

}
