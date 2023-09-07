package io.github.seujorgenochurras.color;

import org.junit.jupiter.api.Test;

import static io.github.seujorgenochurras.util.StringUtils.getUTFChars;
import static org.junit.jupiter.api.Assertions.*;

public class FindBestSymbolPatternTest {
    @Test
    void isFindingBestPattern(){
        var symbols = BestSymbolPatternFinder.findBestPattern(10, 110, getUTFChars(32, 126));
        System.out.println(symbols);

    }
}
