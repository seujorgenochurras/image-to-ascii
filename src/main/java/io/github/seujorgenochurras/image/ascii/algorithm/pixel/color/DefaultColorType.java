package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

public enum DefaultColorType {

    NONE(new NoColorAlgorithm()),
    ANSI(new AnsiColorAlgorithm());

    private final ColorAlgorithm algorithm;

    DefaultColorType(ColorAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public ColorAlgorithm getAlgorithm() {
        return algorithm;
    }
}
