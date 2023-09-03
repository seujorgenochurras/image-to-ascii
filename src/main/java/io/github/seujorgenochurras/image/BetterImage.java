package io.github.seujorgenochurras.image;

import io.github.seujorgenochurras.image.pixel.ImagePixel;
import io.github.seujorgenochurras.image.pixel.ImagePixelGroup;
import io.github.seujorgenochurras.image.pixel.PixelBuilder;

import java.awt.image.BufferedImage;

public class BetterImage {
    private final BufferedImage bufferedImage;

    private final ImagePixelGroup pixels;

    public BetterImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        pixels = PixelBuilder.build(this);

    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void updateCurrentPixels(){
        this.setPixels(pixels);
    }
    public void setPixel(ImagePixel imagePixel){
        bufferedImage.setRGB(imagePixel.x, imagePixel.y, imagePixel.color.getRGB());

    }
    public void setPixels(ImagePixelGroup pixels){
        pixels.forEach(this::setPixel);
    }

    public ImagePixelGroup getPixels() {
        return pixels;
    }
}
