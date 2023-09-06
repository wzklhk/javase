package com.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author wzklhk
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * <p>
 * <p>
 * 实现 MedianFinder 类:
 * <p>
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * 提示:
 * <p>
 * <p>
 * -10⁵ <= num <= 10⁵
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 10⁴ 次调用 addNum 和 findMedian
 * <p>
 * <p>
 * Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 867 👎 0
 */

public class Problem295HardMedianFinderClassTest {

}

class MedianFinder {

    private PriorityQueue<Integer> pqGreat;
    private PriorityQueue<Integer> pqLess;

    public MedianFinder() {
        pqGreat = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pqLess = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (pqLess.isEmpty() || num <= pqLess.peek()) {
            pqLess.offer(num);
            if (pqGreat.size() + 1 < pqLess.size()) {
                pqGreat.offer(pqLess.poll());
            }
        } else {
            pqGreat.offer(num);
            if (pqGreat.size() > pqLess.size()) {
                pqLess.offer(pqGreat.poll());
            }
        }
    }

    public double findMedian() {
        if (pqLess.size() > pqGreat.size()) {
            return pqLess.peek();
        }
        return (pqLess.peek() + pqGreat.peek()) / 2.0;
    }
}
