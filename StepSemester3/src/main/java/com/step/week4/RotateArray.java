package com.step.week4;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] rotatedArray = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            int newIndex = (index + k) % nums.length;
            rotatedArray[newIndex] = nums[index];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(result));
    }
}
