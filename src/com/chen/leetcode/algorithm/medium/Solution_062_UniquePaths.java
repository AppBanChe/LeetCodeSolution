package com.chen.leetcode.algorithm.medium;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 如：
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * @author: chen
 * @date: 2019/4/16
 **/
public class Solution_062_UniquePaths {

    /**
     * 滚动数组
     */
    public int uniquePaths(int m, int n) {
        if (m == 0) return 0;
        int[][] dp = new int[2][m];
        for (int i = 0; i < n; i++) {
            dp[0][0] = 1;
            dp[1][0] = 1;
            for (int j = 1; j < m; j++) {
                dp[i % 2][j] = dp[(i + 1) % 2][j] + dp[i % 2][j - 1];
            }
        }

        return Math.max(dp[0][m - 1], dp[1][m - 1]);
    }
}
