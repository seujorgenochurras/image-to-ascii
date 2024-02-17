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
        this.pixels = new ImagePixelGroup(bufferedImage);
    }

    public BetterImage(String imagePath) {
        this.bufferedImage = tryGenerateImageFromPath(imagePath);
        this.pixels = new ImagePixelGroup(bufferedImage);
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

    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }

    public ImagePixelGroup getPixels() {
        return pixels;
    }



}
