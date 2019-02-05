package com.chen.leetcode.algorithm.easy;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 如，n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * @author: chen
 * @date: 2019/1/2
 **/
public class Solution_441_ArrangingCoins {
    /**
     * 暴力减
     */
    /*public int arrangeCoins(int n) {
        int cur = 1, rem = n - 1;
        while (rem >= cur + 1) {
            ++cur;
            rem -= cur;
        }
        return n == 0 ? 0 : cur;
    }*/

    /**
     * 二分搜索
     */
    public int arrangeCoins(int n) {
        if (n <= 1) return n;
        long left = 1, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long val = mid * (mid + 1) / 2;
            if (val == n) {
                return (int) mid;
            } else if (val < n) {
                if (val + mid + 1 > n) {
                    return (int) mid;
                }
                left = mid + 1;
            } else {
                if (val - mid < n) {
                    return (int) (mid - 1);
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 求根公式
     */
    /*public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }*/
}
