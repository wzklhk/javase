package com.example.javase.algorithms.sort;

public class MergeSort {
    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[] lNums = new int[n1 + 1];
        int[] rNums = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            lNums[i] = nums[start + i];
        }
        for (int i = 0; i < n2; i++) {
            rNums[i] = nums[middle + i + 1];
        }
        lNums[n1] = Integer.MAX_VALUE;
        rNums[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = start; k <= end; k++) {
            if (lNums[i] <= rNums[j]) {
                nums[k] = lNums[i];
                i++;
            } else {
                nums[k] = rNums[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort p = new MergeSort();
        int[] nums = {2, 4, 5, 7, 1, 2, 3, 6};
        p.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
