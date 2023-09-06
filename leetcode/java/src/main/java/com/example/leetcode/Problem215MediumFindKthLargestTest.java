package com.example.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wzklhk
 */
public class Problem215MediumFindKthLargestTest {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();

    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int i = findKthLargest(nums, k);
        System.out.println(i);
    }
}
