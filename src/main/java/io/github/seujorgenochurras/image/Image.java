package io.github.seujorgenochurras.image;

import io.github.seujorgenochurras.image.pixel.ImagePixel;
import io.github.seujorgenochurras.image.pixel.ImagePixels;

import java.awt.image.BufferedImage;

public class Image {
    private final BufferedImage bufferedImage;

    public Image(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setPixel(ImagePixel imagePixel){
        bufferedImage.setRGB(imagePixel.x, imagePixel.y, imagePixel.color.getRGB());
    }
    public void setPixels(ImagePixels pixels){
        pixels.forEach(this::setPixel);
    }
}
