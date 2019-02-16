package com.chen.leetcode.algorithm.medium;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 如，输入: dividend = 10, divisor = 3，输出: 3
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-2147483648, 2147483647]。
 * 本题中，如果除法结果溢出，则返回 2147483647。
 *
 * @author: chen
 * @date: 2019/2/16
 **/
public class Solution_029_DivideTwoIntegers {
    /**
     * 求 dividend，除以 divisor，如 10/3，其实是求10中3的个数，最简单的方法，循环减去3，小于3则停止，得到循环次数；
     * 但这样时间效率太低，可以通过位运算快速逼近被除数。
     */
    public int divide(int dividend, int divisor) {
        long m = Math.abs((long) dividend), n = Math.abs((long) divisor), res = 0;
        if (m < n) return 0;
        while (m >= n) {
            //curRes 可以理解为除数 divisor 个数
            long temp = n, curRes = 1;
            while (m > (temp << 1)) {
                temp <<= 1;
                curRes <<= 1;
            }
            res += curRes;
            m -= temp;
        }
        res = (dividend < 0) ^ (divisor < 0) ? -res : res;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
}
