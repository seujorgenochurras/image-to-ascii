package io.github.seujorgenochurras.image;

import io.github.seujorgenochurras.image.pixel.ImagePixel;
import io.github.seujorgenochurras.image.pixel.ImagePixelGroup;
import io.github.seujorgenochurras.image.pixel.PixelBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BetterImage {
    private final BufferedImage bufferedImage;

    private final ImagePixelGroup pixels;

    public BetterImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        pixels = PixelBuilder.build(this);
    }

    public BetterImage(String imagePath){
       this.bufferedImage = tryGenerateImageFromPath(imagePath);
       pixels = PixelBuilder.build(this);
    }

    public BufferedImage tryGenerateImageFromPath(String imagePath) {
        File imageFile = new File(imagePath);

        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Image File not found", e);
        }
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void updateCurrentPixels() {
        this.setPixels(pixels);
    }

    public void setPixel(ImagePixel imagePixel) {
        bufferedImage.setRGB(imagePixel.x, imagePixel.y, imagePixel.color.getRGB());

    }

    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }

    public ImagePixelGroup getPixels() {
        return pixels;
    }

    public void setPixels(ImagePixelGroup pixels) {
        pixels.forEach(this::setPixel);
    }
}
