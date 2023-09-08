package io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale;

public enum PixelScaleAlgorithm {
    DEFAULT(1),
    SMOOTH(4),
    FAST(2),
    REPLICATE(8),
    AVERAGE_PIXEL(16);

    private final int id;

    PixelScaleAlgorithm(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
