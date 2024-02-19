package io.github.seujorgenochurras.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void givenRange_whenRangeAreAllASCIIChars_thenReturnAllChars(){
        int firstAsciiChar = 33;
        int lastAsciiChar = 126;

        String[] allAsciiChars = new String[]{"!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+",",",
                "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">",
                "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b",
                "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "{", "|", "}", "~"};

        String[] allAsciiCharsFromStringUtils = StringUtils.getUTFChars(firstAsciiChar, lastAsciiChar);

        assertArrayEquals(allAsciiChars, allAsciiCharsFromStringUtils);

    }

}
