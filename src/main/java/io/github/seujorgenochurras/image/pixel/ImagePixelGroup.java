package io.github.seujorgenochurras.image.pixel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ImagePixelGroup extends ArrayList<ImagePixel> {
    private final BufferedImage bufferedImage;

    public ImagePixelGroup(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    /**
     * @param imagePixelConsumer The action to be performed for each pixel
     */
    @Override
    public void forEach(Consumer<? super ImagePixel> imagePixelConsumer) {
        int imageWidth = bufferedImage.getWidth();
        int imageHeight = bufferedImage.getHeight();
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {

                Color pixelColor = new Color(bufferedImage.getRGB(x, y));
                ImagePixel pixel = new ImagePixel(pixelColor, x, y);
                imagePixelConsumer.accept(pixel);
            }
        }

    }

    /**
     * @return quantity of pixels in this group
     */
    @Override
    public int size() {
        return bufferedImage.getHeight() * bufferedImage.getWidth();
    }
}
