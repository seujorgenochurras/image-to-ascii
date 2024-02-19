package io.github.seujorgenochurras.image;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScale;
import io.github.seujorgenochurras.image.pixel.ImagePixelGroup;
import io.github.seujorgenochurras.util.FileUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

/**
 * A util class that adds more methods to the {@link BufferedImage} class
 */
public class BetterImage {

    private static final Logger logger = Logger.getLogger(BetterImage.class.getName());

    private final BufferedImage bufferedImage;

    private final ImagePixelGroup pixels;

    public BetterImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.pixels = new ImagePixelGroup(bufferedImage);
    }

    public BetterImage(String imagePath) {
        this.bufferedImage = FileUtils.tryGetImageFromPath(imagePath);
        this.pixels = new ImagePixelGroup(bufferedImage);
    }


    /**
     * @param scaleConfig the scale config
     * @return <b>A new instance</b> of {@link BetterImage} scaled according to {@code scaleConfig}
     */
    public BetterImage getScaledInstance(PixelScale scaleConfig) {
        int width = scaleConfig.width();
        int height = scaleConfig.height();
        int algorithm = scaleConfig.scaleAlgorithm().getId();

        var bufferedImage = getBufferedImage();

        Image scaledImage = bufferedImage.getScaledInstance(width, height, algorithm);

        BufferedImage scaledImageBuffer = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR_PRE);

        Graphics2D scaledImageGraphics = scaledImageBuffer.createGraphics();
        scaledImageGraphics.drawImage(scaledImage, 0, 0, null);
        scaledImageGraphics.dispose();

        return new BetterImage(scaledImageBuffer);
    }

    /**
     * @return BufferedImage that composed the BetterImage class
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    /**
     * @return image width
     */
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    /**
     * @return image height
     */
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    /**
     * @return An iterable list of pixels of this image
     */
    public ImagePixelGroup getPixels() {
        return pixels;
    }


    /**
     * @param x pixel position in the x-axis (left and right)
     * @param y pixel position in the y-axis (up and down)
     * @return true if pixel is exactly in any border, false otherwise
     */
    public boolean isBorderPixel(int x, int y) {
        return isLateralBorderPixel(x) || isVerticalBorderPixel(y);
    }


    /**
     * @param x pixel position in the x-axis (left and right)
     * @return true if pixel is exactly in any x-axis border, false otherwise
     */
    public boolean isLateralBorderPixel(int x) {
        return x == getWidth();
    }

    /**
     * @param y pixel position in the y-axis (up and down)
     * @return true if pixel is exactly in any y-axis border, false otherwise
     */
    public boolean isVerticalBorderPixel(int y) {
        return y == getHeight();
    }

}
