package io.github.seujorgenochurras;

import io.github.seujorgenochurras.image.Image;
import io.github.seujorgenochurras.image.ascii.AsciiParser;
import io.github.seujorgenochurras.image.ascii.AsciiParserBuilder;
import io.github.seujorgenochurras.image.ascii.AsciiParserConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Image image = createImage("src/main/resources/tijolo.png");

        AsciiParserConfig parserConfig = AsciiParserBuilder.startBuild()
                .symbols( "@", "$", "/", ",", ".", " ")
                .pixelScale(4).to(1)
                .build();


        FileWriter fileWriter = new FileWriter("src/main/resources/out.txt");
        fileWriter.write(AsciiParser.parse(image, parserConfig));
        fileWriter.flush();



    }

    private static Image createImage(String imagePath) {
        File imageFile = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            return new Image(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Image(null);
    }
}