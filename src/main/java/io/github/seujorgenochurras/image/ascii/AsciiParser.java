package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.Image;

public class AsciiParser {

    private AsciiParser(){}

    public static String parse(Image image, AsciiParserConfig parserConfig){
        return parserConfig.parse(image);
    }
}
