package io.github.seujorgenochurras.util;

import org.junit.jupiter.api.Test;

import static io.github.seujorgenochurras.util.ArrayUtils.reverse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayUtilsTest {


    @Test
    void isRevertingArray() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer[] reversedArr = reverse(arr);

        Integer[] expectedReversedArr = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        assertArrayEquals(reversedArr, expectedReversedArr);
    }
}