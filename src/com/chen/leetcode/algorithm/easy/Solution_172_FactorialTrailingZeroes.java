package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 输入: 3，输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_172_FactorialTrailingZeroes {
    /**
     * 一个数可以被拆分成多个因数相乘，而n!结尾有多少个0，即有多少个因数10
     * 而10取决于2和5这两个质因数相乘，2的数量远远大于5，所以找5的数量即可
     * 迭代
     */
    /*public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }*/

    /**
     * 递归
     */
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}
