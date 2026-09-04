package com.step.week4;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int leftProduct = 1;

        for (int index = 0; index < nums.length; index++) {
            result[index] = leftProduct;
            leftProduct = leftProduct * nums[index];
        }

        int rightProduct = 1;

        for (int index = nums.length - 1; index >= 0; index--) {
            result[index] = result[index] * rightProduct;
            rightProduct = rightProduct * nums[index];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println("Product Except Self: " + Arrays.toString(result));
    }
}
