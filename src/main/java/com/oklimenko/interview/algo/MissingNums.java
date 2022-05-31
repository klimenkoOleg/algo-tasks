package com.oklimenko.interview.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNums {

//    Input: nums = [4,3,2,7,8,2,3,1]
//    Output: [5,6]
//    Example 2:
//
//    Input: nums = [1,1]
//    Output: [2]

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        int[] nums = {1, 1};
        List<Integer> res = new MissingNums().findDisappearedNumbers(nums);
        res.forEach(System.out::println);

    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = java.lang.Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = - nums[idx];
            }
        }
        int positivesIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[positivesIdx] = i + 1;
                positivesIdx++;
            }
        }
        List<Integer> result = new ArrayList<>(positivesIdx);
        for (int i = 0; i < positivesIdx; i++) {
            result.add(nums[i]);
        }
        return result;
    }
}
