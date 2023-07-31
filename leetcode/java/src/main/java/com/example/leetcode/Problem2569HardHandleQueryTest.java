package com.example.leetcode;

import com.example.leetcode.structure.SegTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzklhk
 * <p>
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
 * <p>
 * <p>
 * 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成
 * 0 。l 和 r 下标都从 0 开始。
 * 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] +
 * nums1[i] * p 。
 * 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
 * <p>
 * <p>
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
 * 输出：[3]
 * 解释：第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
 * 输出：[5]
 * 解释：第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length,nums2.length <= 10⁵
 * nums1.length = nums2.length
 * 1 <= queries.length <= 10⁵
 * queries[i].length = 3
 * 0 <= l <= r <= nums1.length - 1
 * 0 <= p <= 10⁶
 * 0 <= nums1[i] <= 1
 * 0 <= nums2[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 线段树 数组 👍 66 👎 0
 */


public class Problem2569HardHandleQueryTest {
    public long[] handleQuerySegTree(int[] nums1, int[] nums2, int[][] queries) {
        SegTree tree = new SegTree(nums1);

        long sum = 0;
        for (int num : nums2) {
            sum += num;
        }

        List<Long> list = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                tree.reverseRange(l, r);
            } else if (query[0] == 2) {
                sum += (long) tree.sumRange(0, nums1.length) * query[1];
            } else {
                list.add(sum);
            }
        }

        long[] ans = new long[list.size()];
        return ans;

    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
//        List<Integer> nums1Arr = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> nums1Arr = new ArrayList<>();
        List<Long> nums2Arr = new ArrayList<>();
        List<Long> resArr = new ArrayList<>();

        for (int i : nums1) {
            nums1Arr.add(i);
        }
        for (int i : nums2) {
            nums2Arr.add((long) i);
        }


        for (int[] query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; i++) {
                    nums1Arr.set(i, nums1Arr.get(i) == 1 ? 0 : 1);
                }
            } else if (query[0] == 2) {
                for (int i = 0; i < nums2Arr.size(); i++) {
                    nums2Arr.set(i, nums2Arr.get(i) + (long) nums1Arr.get(i) * query[1]);
                }
            } else {
                long sum = 0;
                for (Long i : nums2Arr) {
                    sum += i;
                }
                resArr.add(sum);
            }
        }


        long res[] = new long[resArr.size()];
        for (int i = 0; i < resArr.size(); i++) {
            res[i] = resArr.get(i);
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {0, 0, 0};
        int[][] queries = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        long[] longs = handleQuery(nums1, nums2, queries);

        for (long i : longs) {
            System.out.println(i);
        }
    }
}


