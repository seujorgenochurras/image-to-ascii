package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.Image;
import io.github.seujorgenochurras.util.MathUtils;

import java.util.HashMap;
import java.util.function.Function;

public class AsciiParserConfig {
    private final int pixelScale;

    private final String[] pixelLightSymbols;

    private Function<Image, String> parseMethod;

    public AsciiParserConfig(int pixelScale, String[] symbols) {
        this.pixelScale = pixelScale;

        this.pixelLightSymbols =symbols;
    }

    private HashMap<Integer, String> constructSymbols(String... symbols) {
        int brightnessGap = Math.round((float) 256 / symbols.length);
        int currentGap = brightnessGap;
        HashMap<Integer, String> brightnessSymbols = new HashMap<>();
        for (String symbol : symbols) {
            brightnessSymbols.put(currentGap, symbol);
            currentGap += brightnessGap;
        }

        return brightnessSymbols;
    }

    String parse(Image image) {
        StringBuilder builder = new StringBuilder();



        image.getPixels().forEach(pixel -> {
            int red = pixel.color.getRed().getColorValue();
            int green = pixel.color.getGreen().getColorValue();
            int blue = pixel.color.getBlue().getColorValue();

            int maxBright = MathUtils.max(red, green, blue);

            String symbol = pixelLightSymbols[(Math.round((float) 256 / maxBright)) -1];
            builder.append(symbol);

            if (pixel.x == image.getBufferedImage().getHeight() -1) {
                builder.append("\n");
            }
        });
        return builder.toString();
    }
}
