package com.step.week4;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                if (nums[firstIndex] + nums[secondIndex] == target) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
