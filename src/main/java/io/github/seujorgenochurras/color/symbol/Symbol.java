package io.github.seujorgenochurras.color.symbol;

public class Symbol {
    private String data;
    private double brightness;

    public String getData() {
        return data;
    }

    public Symbol setData(String data) {
        this.data = data;
        return this;
    }

    public double getBrightness() {
        return brightness;
    }

    public Symbol setBrightness(double brightness) {
        this.brightness = brightness;
        return this;
    }

    public Symbol(String data, double brightness) {
        this.data = data;
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "data='" + data + '\'' +
                ", brightness=" + brightness +
                '}';
    }
}
