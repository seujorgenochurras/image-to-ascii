package io.github.seujorgenochurras.image.pixel.color;

public abstract class ModifiableColor {
    protected int colorValue;

    protected ModifiableColor(int colorValue) {
        this.colorValue = colorValue;
    }

    public int getColorValue() {
        return colorValue;
    }

    public ModifiableColor setColorValue(int colorValue) {
        this.colorValue = colorValue;
        validateAndHandleCurrentColor();
        return this;
    }

    private void validateAndHandleCurrentColor(){
        if(colorValue > 255){
            this.colorValue = 255;
            return;
        }
        if(colorValue < 0){
            this.colorValue = 0;
        }
    }
    public void add(int amount){
        this.colorValue += amount;
        validateAndHandleCurrentColor();
    }
    public void subtract(int amount){
        this.colorValue -= amount;
        validateAndHandleCurrentColor();
    }
    public void divide(double divisor){
        this.colorValue /= divisor;
        validateAndHandleCurrentColor();
    }
    public void multiply(double multiplier){
        this.colorValue *= multiplier;
        validateAndHandleCurrentColor();
    }

    @Override
    public String toString() {
        return "ModifiableColor{" +
                "colorValue=" + colorValue +
                '}';
    }
}
