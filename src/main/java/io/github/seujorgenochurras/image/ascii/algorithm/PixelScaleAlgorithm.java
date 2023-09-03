package io.github.seujorgenochurras.image.ascii.algorithm;

public enum PixelScaleAlgorithm {
    DEFAULT(1),
    SMOOTH(4),
    FAST(2),
    REPLICATE(8),
    AVERAGE_PIXEL(16);

    private int algorithmId;

    PixelScaleAlgorithm(int algorithmId) {
        this.algorithmId = algorithmId;
    }
}
