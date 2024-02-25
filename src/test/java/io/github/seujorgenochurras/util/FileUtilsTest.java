package io.github.seujorgenochurras.util;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileUtilsTest {

    private static final String testImagePath = "src/test/resources/image/car.png";

    @Test
    void givenImagePath_whenFileExists_thenReturnImageInstance() {
        BufferedImage image = FileUtils.tryGetImageFromPath(testImagePath);

        assertNotNull(image);
    }

    @Test
    void givenImagePath_whenFileDoesNotExists_thenGiveErrorMessage() {
        assertThrows(RuntimeException.class, () -> FileUtils.tryGetImageFromPath("oiuahwdohawdoiawh"));

    }
}
