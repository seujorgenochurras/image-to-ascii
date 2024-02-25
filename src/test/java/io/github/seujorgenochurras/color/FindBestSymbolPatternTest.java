package io.github.seujorgenochurras.color;

import io.github.seujorgenochurras.util.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FindBestSymbolPatternTest {


    @Test
    void givenSomeChars_whenFindBestPattern_thenReturnBestPattern() {
        String[] providedBestPattern = BestSymbolPatternFinder.findBestPattern("W", " ", "|", "w", ".").toArray();
        String[] expectedPattern = new String[]{" ", ".", "|", "w", "W"};
        assertEquals(Arrays.toString(expectedPattern), Arrays.toString(providedBestPattern));

    }

    @Test
    void givenALotOfChars_whenFindBestPattern_thenReturnInsideListSizeRange() {
        String[] unsortedChars = StringUtils.getUTFChars(126, 1000);
        int maxSymbols = 200;

        String[] providedBestPattern = BestSymbolPatternFinder.findBestPattern(100, maxSymbols, unsortedChars).toArray();
        assertTrue(providedBestPattern.length <= maxSymbols);

    }
}
