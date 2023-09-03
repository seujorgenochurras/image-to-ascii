package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.BetterImage;

public class AsciiParser {

    private AsciiParser(){}

    public static String parse(BetterImage betterImage, AsciiParserConfig parserConfig){
        return parserConfig.parse(betterImage);
    }
}
