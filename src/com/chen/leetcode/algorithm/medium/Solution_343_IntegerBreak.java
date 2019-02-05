package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 输入: 2，输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * @author: chen
 * @date: 2019/1/10
 **/
public class Solution_343_IntegerBreak {
    /**
     * 将多个数举例可以看到从5开始，需要先拆出所有的3，一直拆到剩下一个数为2或者4
     */
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    /**
     * 优化
     */
    /*public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        if (n == 4) return 4;
        n -= 5;
        return (int) Math.pow(3, (n / 3 + 1)) * (n % 3 + 2);
    }*/
}
