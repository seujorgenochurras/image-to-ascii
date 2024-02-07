package io.github.seujorgenochurras;

import io.github.seujorgenochurras.color.BestSymbolPatternFinder;
import io.github.seujorgenochurras.image.BetterImage;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.ParserConfig;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.scale.PixelScaleAlgorithm;
import io.github.seujorgenochurras.image.pixel.color.PixelColor;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;

public class Main {
    private static final String[] symbols = BestSymbolPatternFinder.findBestPattern(3, 150, getUTFChars(32, 1632)).getSymbolsAsStringArray();
    //private static final String[] symbols = {"L", "U", "C", "A", "S"};
    private static final ParserConfig parserConfig = ParserBuilder.startBuild().parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM.getAlgorithm()).scaled().algorithm(PixelScaleAlgorithm.SMOOTH).height(30).width(80).getScale().symbols(symbols).withColor(new AnsiColorAlgorithm()).build();
    private static PixelColor[] tones;

    static {
//        ArrayList<PixelColor> tonesList = new ArrayList<>();
//        for(int g = 0; g < 0xff; g++){
//            tonesList.add(new PixelColor(new Color(0, g, 0)));
//        }
//        tones = new PixelColor[tonesList.size()-1];
//        tones = tonesList.toArray(tones);
    }

    public static void main(String[] args) throws IOException {
        asciifyFile("/home/thiago/Desktop/projects/image-to-ascii/src/main/resources/img_4.png");


        //   asciifyInDir("/home/thiago/IdeaProjects/image-to-ascii/src/main/resources/image");
    }

    public static void asciifyInDir(String dirPath) throws IOException, InterruptedException {

        File[] images = new File(dirPath).listFiles();


        for (File image : images) {
            if (image.isFile()) {
                Thread.sleep(200);

                asciifyFile(image.getAbsolutePath());
            }
        }
    }


    public static void asciifyFile(String fileName) throws IOException {
        File image = new File(fileName);
        BetterImage betterImage = new BetterImage(ImageIO.read(image));

        //File newFile = new File("/home/thiago/.neofetch/ascii/" + image.getName().replaceAll("png|jpg|jpeg", "txt"));
        File newFile = new File("/home/thiago/Desktop/projects/image-to-ascii/src/main/resources/" + image.getName().replaceAll("png|jpg|jpeg", "txt"));
        FileWriter fileWriter = new FileWriter(newFile);
        fileWriter.write(AsciiParser.parse(betterImage, parserConfig));
        fileWriter.flush();
    }
}
