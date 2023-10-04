package io.github.seujorgenochurras.util;

import java.util.Arrays;

public class ArrayUtils {
    private ArrayUtils(){}


    public static <T> T[]  reverse(T[] arr){
        T[] reversedArray = Arrays.copyOf(arr, arr.length);

        for(int i = 0; i < arr.length / 2; i++){
            reversedArray[i] = arr[arr.length - 1 - i];
            reversedArray[arr.length -1 -i] = arr[i];
         }
        return reversedArray;
    }

}
