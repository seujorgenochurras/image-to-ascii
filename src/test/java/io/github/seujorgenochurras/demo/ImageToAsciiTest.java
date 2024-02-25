package io.github.seujorgenochurras.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageToAsciiTest {


    @Test
    void givenImage_whenValuesAreRight_thenDoesntThrow() {
        String path = "src/test/resources/image/car.png";

        Assertions.assertDoesNotThrow(() -> ImageToAscii.asciifyFile(path));
    }
}
