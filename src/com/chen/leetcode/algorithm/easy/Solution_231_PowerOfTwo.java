package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 如，输入: 4
 * 输出: true，解释：2*2=4
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
