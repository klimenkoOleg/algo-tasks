package com.oklimenko.interview.algo;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ArraysSquaresSortedArray {
    /*Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
    Example 2:

    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]*/

    public static void main(String[] args) {
//        [-4,-1,0,3,10]
//        int[] nums = {-4,-1,0,3,10};
//        int[] nums = {-3,-1,0};
//        int[] nums = {0,1,3,4};
//        int[] nums = {-4,-1,1,1,1,3,10};
//        int[] nums = {1, 2};
//        int[] nums = {-5,-3,-2,-1};
//        int[] nums = {-1,2,2};
        int[] nums = {-1};
//        int[] nums = {-4, -1, 0, 0, 1, 3, 10};
//        int[] nums = {16, 1, 0, 0, 1, 9, 100};
//        int[] nums = {0, 0, 16, 1, 1, 9, 100};


        int[] result = new ArraysSquaresSortedArray().sortedSquares(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] sortedSquares(int[] nums) {
        /*if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }*/

        int[] result = new int[nums.length];

        int midIdx = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                midIdx = i;
                break;
            }
        }

        int leftIxd = midIdx - 1;
        int rightIdx = midIdx;

        int k = 0;

        while (leftIxd >= 0 && rightIdx < nums.length) {
            int leftSq = nums[leftIxd] * nums[leftIxd];
            int rightSq = nums[rightIdx] * nums[rightIdx];
            if (leftSq < rightSq) {
                result[k++] = leftSq;
                leftIxd--;
            } else {
                result[k++] = rightSq;
                rightIdx++;
            }
        }
        while (leftIxd >= 0) {
            int leftSq = nums[leftIxd] * nums[leftIxd];
            result[k++] = leftSq;
            leftIxd--;
        }
        while (rightIdx < nums.length) {
            int rightSq = nums[rightIdx] * nums[rightIdx];
            result[k++] = rightSq;
            rightIdx++;
        }
        return result;
    }
}