package io.github.seujorgenochurras.image.pixel.color;

public class Alpha extends ModifiableColor {
    public Alpha(int colorValue) {
        super(colorValue);
    }

    @Override
    public String toString() {
        return String.valueOf(colorValue);
    }
}
