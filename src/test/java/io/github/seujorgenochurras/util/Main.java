package io.github.seujorgenochurras.util;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.color.symbol.SymbolList;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.AsciiAlgorithms;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class Main {
    public static void main(String[] args) throws IOException {
        BetterImage betterImage = createImage("src/main/resources/img_1.png");
      SymbolList symbols = BestSymbolPatternFinder.findBestPattern(1, 35, getUTFChars(32, 126));
        //SymbolList symbols = BestSymbolPatternFinder.findBestPattern(10, 255, new String[]{" ", "`", ".", "-", ":", "\"", "^", ";", "?", "r", "/", "1", "4", "3", "A", "O", "R", "6", "7", "8", "9", "@", "B", "D", "M", "Q", "W",});

        //SymbolList symbols = BestSymbolPatternFinder.findBestPattern(22, 255," "," ","͏","´","˙","ˆ","˚","-","¹","⁰","ª","¬","~",";","^","+","™","=",">","ſ","?","L","/","\"","ì","f","4","%","π","ý","я","9","S","E","K","&","Ё","8","0","M","D","H","N","@","Q","R","W","§","Ñ","Õ","Ø","Ŵ","ำ","Ẅ","┣","┫","╂","╉","╊","╋","","▀","▄","▌","▐","▒","▚","▞","","","▅","▋","▆","▊","▓","▙","▛","▜","▟","▉","▇","█");
      //  SymbolList symbols = BestSymbolPatternFinder.findBestPattern(0, 255," ","´","˙","ˆ","˚","-","¹","⁰","ª","¬","~",";","^","+","™","=",">","ſ","?","L","/","\"","ì","f","4","%","π","ý","я","9","S","E","K","&","Ё","8","0","M","D","H","N","@","Q","R","W","§","Ñ","Õ","Ø","Ŵ","ำ","Ẅ","┣","┫","╂","╉","╊","╋","","▀","▄","▌","▐","▒","▚","▞","","","▅","▋","▆","▊","▓","▙","▛","▜","▟","▉","▇","█");
        System.out.println(symbols.size());
        System.out.println(symbols);

        AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols(symbols.getSymbolsAsStringArray())
                .scaled()
                    .height(26)
                    .width(60)
                    .getScale()
                .parserAlgorithm(AsciiAlgorithms.LIGHTEST_PIXEL.getAlgorithm())
                .reversed(false)
                .build();


        FileWriter fileWriter = new FileWriter("src/main/resources/out.txt");
        fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
        fileWriter.flush();
    }

    private static BetterImage createImage(String imagePath) {
        File imageFile = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            return new BetterImage(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BetterImage(null);
    }
}