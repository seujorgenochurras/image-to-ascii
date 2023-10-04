package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

public enum ColorType {

    NONE(new NoColorAlgorithm()),
    ANSI(new AnsiColorAlgorithm());

    private final AsciiColorAlgorithm algorithm;

    ColorType(AsciiColorAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public AsciiColorAlgorithm getAlgorithm() {
        return algorithm;
    }
}
