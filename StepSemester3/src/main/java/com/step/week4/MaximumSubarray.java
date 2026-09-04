package com.step.week4;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maximumSum = nums[0];

        for (int index = 1; index < nums.length; index++) {
            currentSum = Math.max(nums[index], currentSum + nums[index]);
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
