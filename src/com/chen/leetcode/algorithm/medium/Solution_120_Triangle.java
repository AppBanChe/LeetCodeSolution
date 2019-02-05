package com.chen.leetcode.algorithm.medium;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];

        for (List<Integer> list : triangle) {
            for (int size = list.size(), j = size - 1; j >= 0; j--) {
                if (size == 1) dp[0] = list.get(0);
                else if (j == 0) dp[0] = list.get(0) + dp[0];
                else if (j == size - 1) dp[size - 1] = list.get(size - 1) + dp[size - 2];
                else dp[j] = list.get(j) + Math.min(dp[j - 1], dp[j]);
            }
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
