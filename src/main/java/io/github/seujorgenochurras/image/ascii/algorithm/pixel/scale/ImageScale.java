package io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale;

public class ImageScale {
    public final int width;
    public final int height;
    public final ImageScaleAlgorithm scaleAlgorithm;

    public ImageScale(int width, int height, ImageScaleAlgorithm scaleAlgorithm) {
        this.width = width;
        this.height = height;
        this.scaleAlgorithm = scaleAlgorithm;
    }


}