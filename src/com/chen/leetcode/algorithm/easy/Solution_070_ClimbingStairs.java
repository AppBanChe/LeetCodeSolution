package com.chen.leetcode.algorithm.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 如，输入： 2，输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * @author: chen
 * @date: 2019/1/12
 **/
public class Solution_070_ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return n < 2 ? a : b;
    }
}
