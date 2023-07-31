package com.example.leetcode.structure;

import lombok.Data;

/**
 * @author wzklhk
 */
public class SegTree {
    private SegNode[] arr;

    public SegTree(int[] nums) {
        int n = nums.length;
        arr = new SegNode[n * 4 + 1];
        build(1, 0, n - 1, nums);
    }

    public int sumRange(int left, int right) {
        return query(1, left, right);
    }

    public void reverseRange(int left, int right) {
        modify(1, left, right);
    }

    private void build(int i, int l, int r, int[] nums) {
        arr[i] = new SegNode();
        arr[i].setLeft(l);
        arr[i].setRight(r);
        arr[i].setLazy(false);
        if (l == r) {
            arr[i].setSum(nums[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(2 * i, l, mid, nums);
        build(2 * i + 1, mid + 1, r, nums);
        arr[i].setSum(arr[2 * i].getSum() + arr[2 * i + 1].getSum());
    }

    /* pushdown函数：下传懒标记，即将当前区间的修改情况下传到其左右孩子结点 */
    private void pushDown(int i) {
        if (arr[i].isLazy() == true) {

            arr[2 * i].setLazy(!arr[2 * i].isLazy());
            arr[2 * i].setSum(arr[2 * i].getRight() - arr[2 * i].getLeft() + 1 - arr[2 * i].getSum());

            arr[2 * i + 1].setLazy(!arr[2 * i + 1].isLazy());
            arr[2 * i + 1].setSum(arr[2 * i + 1].getRight() - arr[2 * i + 1].getLeft() + 1 - arr[2 * i + 1].getSum());

            arr[i].setLazy(false);
        }
    }

    /* 区间修改 */
    private void modify(int i, int l, int r) {
        if (arr[i].getLeft() >= l && arr[i].getRight() <= r) {
            arr[i].setSum((arr[i].getRight() - arr[i].getLeft() + 1) - arr[i].getSum());
            arr[i].setLazy(!arr[i].isLazy());
            return;
        }
        pushDown(i);
        int mid = (arr[i].getLeft() + arr[i].getRight()) >> 1;
        if (arr[2 * i].getRight() >= l) {
            modify(2 * i, l, r);
        }
        if (arr[2 * i + 1].getLeft() <= r) {
            modify(2 * i + 1, l, r);
        }
        arr[i].setSum(arr[2 * i].getSum() + arr[2 * i + 1].getSum());
    }

    /* 区间查询 */

    /**
     * @param i index
     * @param l left
     * @param r right
     * @return sum from left to right
     */
    private int query(int i, int l, int r) {
        if (arr[i].getLeft() >= l && arr[i].getRight() <= r) {
            return arr[i].getSum();
        }
        if (arr[i].getRight() < l || arr[i].getLeft() > r) {
            return 0;
        }
        pushDown(i);
        int res = 0;
        if (arr[2 * i].getRight() >= l) {
            res += query(2 * i, l, r);
        }
        if (arr[2 * i + 1].getLeft() <= r) {
            res += query(2 * i + 1, l, r);
        }
        return res;
    }

}

@Data
class SegNode {
    private int left;
    private int right;
    private int sum;
    private boolean isLazy;

    public SegNode() {
        this.left = 0;
        this.right = 0;
        this.sum = 0;
        this.isLazy = false;
    }
}