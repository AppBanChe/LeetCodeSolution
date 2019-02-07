package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author: chen
 * @date: 2019/2/7
 **/
public class Solution_064_MinimumPathSum {

    /**
     * O(N)的空间复杂度
     */
    public int minPathSum(int[][] grid) {
        int row, col;
        if (grid == null || (row = grid.length) == 0 || (col = grid[0].length) == 0) return 0;
        int[] dp = new int[col];
        //初始化
        dp[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + grid[i][0];
            //从左向右更新，此时dp[j-1]相当于dp[i][j-1]，dp[j]相当于dp[i-1][j]
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[col - 1];
    }
}
