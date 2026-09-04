package com.step.week4;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (nums[middleIndex] > nums[rightIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }

        return nums[leftIndex];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);
    }
}
