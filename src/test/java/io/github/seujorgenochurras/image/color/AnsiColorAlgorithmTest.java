package io.github.seujorgenochurras.image.color;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import io.github.seujorgenochurras.image.pixel.color.PixelColor;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnsiColorAlgorithmTest {

    @Test
    void givenColor_whenColorHasRGBValues_thenReturnAnsiRepresentation(){
        int red = 120;
        int green = 32;
        int blue = 90;

        PixelColor pixelColor = new PixelColor(new Color(red, green, blue));

        AnsiColorAlgorithm colorAlgorithm = new AnsiColorAlgorithm();

        String ansifiedColor = colorAlgorithm.getColorRepresentation(pixelColor);

        assertEquals("\u001B[38;2;" + red + ";" + green + ";" + blue + "m", ansifiedColor );
    }

}
