package io.github.seujorgenochurras;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File image = new File("src/main/resources/73082261.png");
        BufferedImage bufferedImage = ImageIO.read(image);
        Graphics imageGraphs = bufferedImage.getGraphics();



        int rawColor = bufferedImage.getRGB(1, 1);
        Color color = new Color(rawColor, true);
        System.out.println(rawColor);
        System.out.println(color.getRed() + ", " +  color.getGreen()+ ", " + color.getBlue());



        imageGraphs.setColor(Color.BLUE);
        imageGraphs.drawRect(10, 20, 20, 20);

        File imageOutput = new File("src/main/resources/out.png");
        ImageIO.write(bufferedImage, "png", imageOutput);
    }
}