package com.example.javase.algorithms.sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public void quicksort(Integer[] nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quicksort(nums, p, q - 1);
            quicksort(nums, q + 1, r);

        }
    }

    public void quicksort(List<Integer> nums, int p, int r) {
        if (p < r) {
            int q = partition(nums, p, r);
            quicksort(nums, p, q - 1);
            quicksort(nums, q + 1, r);
        }
    }

    private int randomPartition(Integer[] nums, int p, int r) {
        int i = (int) (p + Math.random() * (r - p + 1));
        exchange(nums, i, r);
        return partition(nums, p, r);
    }

    private int randomPartition(List<Integer> nums, int p, int r) {
        int i = (int) (p + Math.random() * (r - p + 1));
        exchange(nums, i, r);
        return partition(nums, p, r);
    }

    private int partition(Integer[] nums, int p, int r) {
        Integer x = nums[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (nums[j] <= x) {
                i++;
                exchange(nums, i, j);
            }
        }

        exchange(nums, i + 1, r);
        return i + 1;
    }

    private int partition(List<Integer> nums, int p, int r) {
        Integer x = nums.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (nums.get(j) <= x) {
                i++;
                exchange(nums, i, j);
            }
        }
        exchange(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 交换位置元素
     *
     * @param nums 数组
     * @param i    位置i索引
     * @param j    位置j索引
     */
    private void exchange(Integer[] nums, int i, int j) {
        Integer tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 交换位置元素
     *
     * @param nums 列表
     * @param i    位置i索引
     * @param j    位置j索引
     */
    private void exchange(List<Integer> nums, int i, int j) {
        Integer tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    /**
     * 返回数组nums中第i小的数
     *
     * @param nums 数组
     * @param p    数组起始索引
     * @param r    数组终止索引
     * @param i    第i小索引
     * @return 第i小的数
     */
    public Integer randomSelect(Integer[] nums, int p, int r, int i) {
        if (p == r) {
            return nums[p];
        }
        int q = randomPartition(nums, p, r);
        int k = q - p + 1;
        if (i == k) {
            return nums[q];
        } else if (i < k) {
            return randomSelect(nums, p, q - 1, i);
        } else {
            return randomSelect(nums, q + 1, r, i - k);
        }
    }


    public static void main(String[] args) {
        QuickSort p = new QuickSort();
        java.lang.Integer[] integerArray = {2, 8, 7, 1, 3, 5, 6, 4};
        List<java.lang.Integer> integerList = Arrays.asList(integerArray);
        p.quicksort(integerArray, 0, integerArray.length - 1);
        p.quicksort(integerList, 0, integerList.size() - 1);

        integerList.stream().forEach(System.out::println);
        System.out.println(integerList);
    }
}
