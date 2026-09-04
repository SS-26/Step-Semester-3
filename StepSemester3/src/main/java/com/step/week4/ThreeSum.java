package com.step.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        List<int[]> triplets = new ArrayList<>();

        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {

            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            int leftIndex = firstIndex + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int sum = nums[firstIndex] + nums[leftIndex] + nums[rightIndex];

                if (sum == 0) {
                    triplets.add(new int[]{
                            nums[firstIndex],
                            nums[leftIndex],
                            nums[rightIndex]
                    });

                    leftIndex++;
                    rightIndex--;

                    while (leftIndex < rightIndex
                            && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++;
                    }

                    while (leftIndex < rightIndex
                            && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--;
                    }

                } else if (sum < 0) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        System.out.println("Three Sum Triplets:");

        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
