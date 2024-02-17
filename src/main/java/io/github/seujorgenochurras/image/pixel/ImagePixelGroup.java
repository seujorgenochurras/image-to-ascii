package io.github.seujorgenochurras.image.pixel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ImagePixelGroup extends ArrayList<ImagePixel> {
    private final BufferedImage bufferedImage;

    public ImagePixelGroup(int initialCapacity, BufferedImage bufferedImage) {
        super(initialCapacity);
        this.bufferedImage = bufferedImage;
    }

    public ImagePixelGroup(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

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

    @Override
    public int size() {
        return bufferedImage.getHeight() * bufferedImage.getWidth();
    }
}
