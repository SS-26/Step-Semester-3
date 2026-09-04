package com.step.week4;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {

                if (nums[firstIndex] == nums[secondIndex]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }
}
