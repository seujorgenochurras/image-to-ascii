package io.github.seujorgenochurras.image;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.ImageScale;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.ImageScaleAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BetterImageTest {

    private static final String testImagePath = "src/test/resources/image/car.png";
    private static final BetterImage testBetterImage = new BetterImage(testImagePath);

    @Test
    void givenPixelPosition_whenIsBorder_thenReturnTrue() {
        int pixelPositionX = testBetterImage.getWidth() - 1;
        int pixelPositionY = testBetterImage.getHeight() - 1;

        assertTrue(testBetterImage.isBorderPixel(pixelPositionX, pixelPositionY));
        assertTrue(testBetterImage.isLateralBorderPixel(pixelPositionX));
        assertTrue(testBetterImage.isVerticalBorderPixel(pixelPositionY));

    }

    @Test
    void givenPixelPosition_whenIsNotOnBorder_thenReturnFalse() {
        int pixelPositionX = testBetterImage.getWidth() - 50;
        int pixelPositionY = testBetterImage.getHeight() - 123;

        assertFalse(testBetterImage.isBorderPixel(pixelPositionX, pixelPositionY));
        assertFalse(testBetterImage.isLateralBorderPixel(pixelPositionX));
        assertFalse(testBetterImage.isVerticalBorderPixel(pixelPositionY));

    }

    @Test
    void givenImage_whenScaled_thenReturnAccurateScaledInstance() {
        int initialWidth = testBetterImage.getWidth();
        int initialHeight = testBetterImage.getHeight();

        ImageScale pixelDownscaleConfig = new ImageScale(200, 100, ImageScaleAlgorithm.SMOOTH);
        ImageScale pixelUpscaleConfig = new ImageScale(initialWidth + 100, initialHeight + 160, ImageScaleAlgorithm.SMOOTH);

        BetterImage scaledDownImage = testBetterImage.getScaledInstance(pixelDownscaleConfig);

        BetterImage scaledUpImage = testBetterImage.getScaledInstance(pixelUpscaleConfig);

        assertEquals(200, scaledDownImage.getWidth());
        assertEquals(100, scaledDownImage.getHeight());

        assertEquals(initialWidth + 100, scaledUpImage.getWidth());
        assertEquals(initialHeight + 160, scaledUpImage.getHeight());

    }


}
