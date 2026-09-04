package com.step.week4;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        while (firstIndex < arr1.length && secondIndex < arr2.length) {

            if (arr1[firstIndex] <= arr2[secondIndex]) {
                result[resultIndex] = arr1[firstIndex];
                firstIndex++;
            } else {
                result[resultIndex] = arr2[secondIndex];
                secondIndex++;
            }

            resultIndex++;
        }

        while (firstIndex < arr1.length) {
            result[resultIndex] = arr1[firstIndex];
            firstIndex++;
            resultIndex++;
        }

        while (secondIndex < arr2.length) {
            result[resultIndex] = arr2[secondIndex];
            secondIndex++;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] result = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(result));
    }
}
