package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorWithTones;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.DefaultColorType;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;
import io.github.seujorgenochurras.image.pixel.color.PixelColor;
import io.github.seujorgenochurras.util.ArrayUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class Main {
    //private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(50, 150, getUTFChars(32, 300)).getSymbolsAsStringArray();
    private static final String[] symbols = {"0", "1"};

    private static PixelColor[] tones;
    static {
        ArrayList<PixelColor> tonesList = new ArrayList<>();
        for(int g = 0; g < 0xff; g++){
            tonesList.add(new PixelColor(new Color(0, g, 0)));
        }
        tones = new PixelColor[tonesList.size()-1];
        tones = tonesList.toArray(tones);
    }
    private static final   ParserConfig parserConfig = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm())
            .scaled()
            .algorithm(PixelScaleAlgorithm.SMOOTH)
            .height(30)
            .width(60)
            .getScale()
            .symbols(symbols)
            .withColor(new AnsiColorWithTones(tones))
            .build();
    public static void main(String[] args) throws IOException, InterruptedException {
        asciifyInDir("/home/thiago/IdeaProjects/image-to-ascii/src/main/resources/image");
    }
    public static void asciifyInDir(String dirPath) throws IOException, InterruptedException {

        File[] images = new File(dirPath).listFiles();


        for (File image : images) {
            if(image.isFile()){
                Thread.sleep(200);

                asciifyFile(image.getAbsolutePath());
            }
        }
    }


    public static void asciifyFile(String fileName) throws IOException {
        File image = new File(fileName);
            BetterImage betterImage = new BetterImage(ImageIO.read(image));

            File newFile = new File("/home/thiago/.neofetch/ascii/" + image.getName().replaceAll("png|jpg|jpeg", "txt"));
            FileWriter fileWriter = new FileWriter(newFile);
            fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
            fileWriter.flush();
    }
}
