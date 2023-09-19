package io.github.seujorgenochurras.color;

import org.junit.jupiter.api.Test;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;
import static org.junit.jupiter.api.Assertions.*;

class FindBestSymbolPatternTest {
    @Test
    void isFindingBestPattern(){
        var symbols = BestSymbolPatternFinder.findBestPattern(10, 110, getUTFChars(32, 126));
        String[] expectedSymbols = {" ", "`", "'", ",", ":", "^", "*", "+", "-", ".", "r", ")", "/", "a", "E", "p", "G", "0", "1", "2", "3", "9", "@", "A", "B", "D", "H", "M", "W"};
        assertEquals(expectedSymbols, symbols.getSymbolsAsStringArray());
    }
}
