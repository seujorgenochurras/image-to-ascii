package io.github.seujorgenochurras.util;

import java.util.Arrays;

public class MathUtils {
    private MathUtils() {

    }

    public static int max(int... numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}
