package com.chen.leetcode.algorithm.hard;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 如，输入: [2,4,1], k = 2，输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * @author: chen
 * @date: 2019/1/11
 **/
public class Solution_188_BestTimeToBuyAndSellStock4 {
    /**
     * 暴力
     */
    /*public int maxProfit(int k, int[] prices) {
        return dfs(k, prices, 0, Integer.MAX_VALUE);
    }

    private int dfs(int k, int[] prices, int start, int min) {
        if (start == prices.length || k == 0) return 0;
        min = Math.min(min, prices[start]);
        return Math.max(dfs(k, prices, start + 1, min), prices[start] - min + dfs(k - 1, prices, start + 1, prices[start]));
    }*/



}
