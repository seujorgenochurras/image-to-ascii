package io.github.seujorgenochurras;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String imagePath = "src/main/resources/image/jorge.png";
        boolean withColor = false;

        String imageAsciiArt = DefaultAsciifier.toAscii(imagePath, 40, 100, withColor);

        FileWriter fileWriter = new FileWriter("myAsciiArt.txt");
        fileWriter.write(imageAsciiArt);
        fileWriter.flush();

    }
}
