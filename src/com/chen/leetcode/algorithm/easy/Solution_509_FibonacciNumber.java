package com.chen.leetcode.algorithm.easy;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_509_FibonacciNumber {
    public int fib(int N) {
        int a = 0, b = 1, temp;
        for (int i = 2; i <= N; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return N == 0 ? a : b;
    }
}
