package io.github.seujorgenochurras.image;
import static org.junit.jupiter.api.Assertions.*;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;
import org.junit.jupiter.api.Test;

public class BetterImageTest {

    private static final String testImagePath = "src/test/resources/image/car.png";
    private static final BetterImage testBetterImage = new BetterImage(testImagePath);

    @Test
    void givenPixelPosition_whenIsBorder_thenReturnTrue(){
        int pixelPositionX = testBetterImage.getWidth();
        int pixelPositionY = testBetterImage.getHeight();

        assertTrue(testBetterImage.isBorderPixel(pixelPositionX, pixelPositionY));
        assertTrue(testBetterImage.isLateralBorderPixel(pixelPositionX));
        assertTrue(testBetterImage.isVerticalBorderPixel(pixelPositionY));

    }
    @Test
    void givenPixelPosition_whenIsNotOnBorder_thenReturnFalse(){
        int pixelPositionX = testBetterImage.getWidth() - 50;
        int pixelPositionY = testBetterImage.getHeight() - 123;

        assertFalse(testBetterImage.isBorderPixel(pixelPositionX, pixelPositionY));
        assertFalse(testBetterImage.isLateralBorderPixel(pixelPositionX));
        assertFalse(testBetterImage.isVerticalBorderPixel(pixelPositionY));

    }

    @Test
    void givenImage_whenScaled_thenReturnAccurateScaledInstance(){
        int initialWidth = testBetterImage.getWidth();
        int initialHeight = testBetterImage.getHeight();

        PixelScale pixelDownscaleConfig = new PixelScale(200, 100, PixelScaleAlgorithm.SMOOTH);
        PixelScale pixelUpscaleConfig = new PixelScale(initialWidth+100, initialHeight+160, PixelScaleAlgorithm.SMOOTH);

        BetterImage scaledDownImage = testBetterImage.getScaledInstance(pixelDownscaleConfig);

        BetterImage scaledUpImage = testBetterImage.getScaledInstance(pixelUpscaleConfig);

        assertEquals(200, scaledDownImage.getWidth());
        assertEquals(100, scaledDownImage.getHeight());

        assertEquals(initialWidth+100, scaledUpImage.getWidth());
        assertEquals(initialHeight+160, scaledUpImage.getHeight());

    }


}
