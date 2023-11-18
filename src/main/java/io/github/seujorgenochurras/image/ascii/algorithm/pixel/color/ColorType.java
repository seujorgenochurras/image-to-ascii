package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

public enum ColorType {

    NONE(new NoColorAlgorithm()),
    ANSI(new AnsiColorAlgorithm());

    private final ColorAlgorithm algorithm;

    ColorType(ColorAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public ColorAlgorithm getAlgorithm() {
        return algorithm;
    }
}
