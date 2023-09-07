package io.github.seujorgenochurras.util;

import java.util.stream.IntStream;

public class StringUtils {
    public static String[] getUTFChars(int start, int finish) {
        String[] utfChars = new String[finish - start];
        IntStream.range(start, finish)
                .forEach(i -> utfChars[i - start] = new String(Character.toChars(i)));

        return utfChars;
    }
}
