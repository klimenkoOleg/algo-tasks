package com.oklimenko.interview.algo;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ArrayUtils {
    /**
     * Returns intersection of 2 arrays.
     * Example:
     * nums1 = {1, 2, 2, 1};
     * nums2 = {2, 2};
     * <p>
     * intersection(nums1, nums2) => [2].
     */
    public Integer[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> num1set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Iterator<Integer> num1Iter = num1set.iterator();
        while (num1Iter.hasNext()) {
            Integer item = num1Iter.next();
            if (!num2set.contains(item)) {
                num1Iter.remove();
            }
        }
        return num1set.toArray(new Integer[0]);
    }

    public Integer[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> num1set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2set = Arrays.stream(nums2)
                .filter(num1set::contains)
                .boxed()
                .collect(Collectors.toSet());
        return num2set.toArray(new Integer[0]);
    }

    public Integer[] intersection4(int[] arr1, int[] arr2) {
        Set<Integer> hs = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < arr1.length; i++)
            hs.add(arr1[i]);

        for (int i = 0; i < arr2.length; i++)
            if (hs.contains(arr2[i])) {
                result.add(arr2[i]);
            }

        Integer[] finalResult = result.toArray(new Integer[result.size()]);
        return finalResult;
    }

    public Integer[] intersection5(int[] arr1, int[] arr2) {
        Map<Integer, Integer> intersection = new HashMap<>();

        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        for (int i = 0; i < arr2.length; i++) {
            int item = arr2[i];
            if (set1.contains(item)) {
                intersection.put(item, 1);
            }
        }
        return intersection.keySet().toArray(new Integer[0]);
    }

    public int majorityElement(int[] nums) {

        Random rnd = new Random();
        rnd.nextInt(10);
        Map<Integer, Integer> map = new HashMap<>();
        int majorElem = -1;
        int maxCount = -1;
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            Integer storedCount = map.get(item);
            if (storedCount == null) {
                storedCount = 1;
            } else {
                storedCount++;
            }
            map.put(item, storedCount);
            if ( storedCount > maxCount ) {
                maxCount = storedCount;
                majorElem = item;
            }
        }
        return majorElem;
//        Integer sorted[] = new Integer[map.keySet().size()];
//        map.keySet().toArray(sorted);
//        Arrays.sort(sorted);
//
//        if (  ) {
//
//        }
    }

}
