package com.chen.leetcode.algorithm.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int res = 0;
        int len = (int) Math.sqrt(n);
        for (int i = 2; i <= len; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < n; ++i) {
            if (!isPrime[i]) res++;
        }
        return res;
    }
}
