package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_326_PowerOfThree {


    /*public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }*/

    /**
     * 抖机灵
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
