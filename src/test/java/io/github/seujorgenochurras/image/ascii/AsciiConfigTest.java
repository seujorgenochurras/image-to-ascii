package io.github.seujorgenochurras.image.ascii;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;
import io.github.seujorgenochurras.image.ascii.algorithm.pixel.color.AnsiColorAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsciiConfigTest {

    final ParserConfig testConfig1 = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM)
            .scaled()
            .height(50)
            .width(100)
            .getScale()
            .symbols("")
            .colorAlgorithm(new AnsiColorAlgorithm())
            .build();

    final ParserConfig testConfig2 = ParserBuilder.startBuild()
            .parserAlgorithm(Algorithms.HUMAN_EYE_ALGORITHM)
            .scaled()
            .height(50)
            .width(100)
            .getScale()
            .symbols("")
            .colorAlgorithm(new AnsiColorAlgorithm())
            .build();
    @Test
    void givenTwoConfigs_whenConfigsAreEqual_thenEqualsShouldReturnTrue() {
        assertEquals(testConfig1, testConfig2);

    }
    @Test
    void givenTwoConfigs_whenConfigsAreNotEqual_thenEqualsShouldReturnFalse() {
        final ParserConfig testConfig3 = ParserBuilder.startBuild()
                .parserAlgorithm(Algorithms.BRIGHTEST_PIXEL)
                .scaled()
                .height(150)
                .width(300)
                .getScale()
                .symbols("a", "b")
                .colorAlgorithm(new AnsiColorAlgorithm())
                .build();

        assertNotEquals(testConfig1, testConfig3);
        assertNotEquals(testConfig1, new Object());
        assertNotEquals(testConfig1, testConfig3);
        assertNotEquals(testConfig1, null);

    }

}
