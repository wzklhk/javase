package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标
 * 从 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= seats.length <= 2 * 10⁴
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 * <p>
 * <p>
 * Related Topics 数组 👍 272 👎 0
 */
public class Problem849MediumMaxDustTiClosestTest {
    public int maxDistToClosest(int[] seats) {
        int maxDist = Integer.MIN_VALUE;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                int dist = 1;
                while (i - dist >= 0 || i + dist < n) {
                    if (i - dist >= 0 && i + dist < n) {
                        if (seats[i - dist] == 1 || seats[i + dist] == 1) {
                            break;
                        }
                        dist++;
                    } else if (i - dist >= 0 && i + dist >= n) {
                        if (seats[i - dist] == 1) {
                            break;
                        }
                        dist++;
                    } else if (i - dist <= 0 && i + dist < n) {
                        if (seats[i + dist] == 1) {
                            break;
                        }
                        dist++;
                    }
                }
                maxDist = Math.max(maxDist, dist);
            }
        }
        return maxDist;
    }


    @Test
    public void test() {
        int[] seats = {1, 0, 0, 0};
        int i = maxDistToClosest(seats);
        System.out.println(i);
    }
}
