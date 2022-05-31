package com.oklimenko.interview.algo;

public class ArrayTasks {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        //0,1,4,0,3
        System.out.println(removeElement(arr, 2));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}