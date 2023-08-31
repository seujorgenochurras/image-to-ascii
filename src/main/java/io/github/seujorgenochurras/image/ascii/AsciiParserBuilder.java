package io.github.seujorgenochurras.image.ascii;

public class AsciiParserBuilder {
    private AsciiParserBuilder(){}

    private String[] brightnessSymbols = {"@", "#", "!", "."};

    public static AsciiParserBuilder startBuild(){
        return new AsciiParserBuilder();
    }
    public AsciiParserBuilder symbols(String ...brightnessSymbols){
        this.brightnessSymbols = brightnessSymbols;
        return this;
    }

    public AsciiParserConfig build(){
        return new AsciiParserConfig(4, brightnessSymbols);
    }

}
