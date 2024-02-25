package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.HumanEyeAlgorithm;
import io.github.seujorgenochurras.image.pixel.color.PixelColor;

import static io.github.seujorgenochurras.image.ascii.AsciiParser.getSymbol;

public class AnsiColorWithTones implements ColorAlgorithm {

    private final PixelColor[] tones;

    /**
     * sorted automatically from brightest to darkest
     *
     * @param tones
     */
    public AnsiColorWithTones(PixelColor... tones) {
        this.tones = tones;
    }

    @Override
    public String getColorRepresentation(PixelColor color) {

        int red = color.getRed().asDecimal();
        int green = color.getGreen().asDecimal();
        int blue = color.getBlue().asDecimal();

        int pixelColorRepresentation = Math.toIntExact(new HumanEyeAlgorithm()
                .getBrightnessValue(red, green, blue));

        int symbolsGap = 256 / (tones.length);

        PixelColor tone = getSymbol(pixelColorRepresentation, symbolsGap, tones);

        return "\u001B[38;2;" + tone.getRed() + ";" + tone.getGreen() + ";" + tone.getBlue() + "m";
    }
}
