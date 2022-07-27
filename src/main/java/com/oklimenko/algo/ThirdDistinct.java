package com.oklimenko.algo;

public class ThirdDistinct {


    public static void main(String args[]) {
//System.out.println(removeDuplicates(nums));
//print(Input:
//        int[] nums = {2, 2, 1, 3};//3,2,1};
        int[] nums = {3, 2, 1};//3,2,1};
//        int[] nums = {2, 1};//3,2,1};
//Output: [1,3,12,0,0]
//sortArrayByParity(nums);
//print(nums);
        ThirdDistinct thirdDistinct = new ThirdDistinct();
        System.out.println(thirdDistinct.thirdMax(nums));
    }

    public int thirdMax(int[] nums) {
        int[] max = new int[3];
        int maxLen = 1;
        System.out.println("maxLen initt=" + maxLen);
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            System.out.println("i=" + i + ", val = " + nums[i]);
            maxLen = movePush(max, maxLen, nums[i]);
            //printMax(max, maxLen);
        }
        System.out.println("maxLen end" + maxLen);
        if (maxLen == 3) {
            return max[maxLen - 1];
        }
        return max[0];
    }


    private int movePush(int[] max, int maxLen, int val) {
        for (int i = 0; i < maxLen; i++) {
            if (val == max[i]) {
                return maxLen;
            }
            if (val > max[i]) {
// shift
                for (int j = max.length - 1; j >= i + 1; j--) {
                    max[j] = max[j - 1];
                }
                max[i] = val;
                return maxLen < 3 ? maxLen + 1 : 3;
            }
        }
        if (maxLen < 3) {
            max[maxLen] = val;
            return maxLen + 1;
        }
        return maxLen;
    }

    /*private void printMax(int[] max, int maxLen) {
        System.out.println("<<<<  ");
        System.out.println("maxLen=" + maxLen);
        for (int i = 0; i < maxLen; i++) {
            System.out.println(max[i]);
        }
        System.out.println(">>>");
    }*/
}
