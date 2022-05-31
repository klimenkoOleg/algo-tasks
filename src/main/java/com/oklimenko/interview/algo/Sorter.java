package com.oklimenko.interview.algo;

import java.util.Arrays;

public class Sorter {

    public static void main(String[] args) {
        int[] heights = {5,1,2,3,4};
        System.out.println(new Sorter().heightChecker(heights));
    }


    public int heightChecker(int[] heights) {
        int[] newArr = Arrays.copyOf(heights, heights.length);

        quickSort(newArr, 0, heights.length - 1);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != newArr[i]) {
                count++;
            }
        }
        return count;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
