package io.github.seujorgenochurras.util;

import java.util.Arrays;

public class ArrayUtils {
    private ArrayUtils() {
    }


    public static <T> T[] reverse(T[] arr) {
        T[] reversedArray = Arrays.copyOf(arr, arr.length);

        int arrLastIndex = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            reversedArray[i] = arr[arrLastIndex - i];
            reversedArray[arrLastIndex - i] = arr[i];
        }
        return reversedArray;
    }

}
