package io.github.seujorgenochurras.util;

import java.util.stream.IntStream;

public class StringUtils {
    public static String[] getUTFChars(int start, int finish) {
        finish++;
        String[] utfChars = new String[finish - start];
        IntStream.range(start, finish)
                .forEach(i -> utfChars[i - start] = new String(Character.toChars(i)));

        return utfChars;
    }

    public static boolean containsAll(String s, String... elements){
        boolean containsAll = true;
        for(String element : elements){
            containsAll = s.contains(element);
            if(!containsAll) break;
        }
        return containsAll;
    }
}
