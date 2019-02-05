package com.chen.leetcode.algorithm.hard;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 如，输入: [3,3,5,0,0,3,1,4]，输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * @author: chen
 * @date: 2019/1/11
 **/
public class Solution_123_BestTimeToBuyAndSellStock3 {
    /**
     * 暴力
     */
    /*public int maxProfit(int[] prices) {
        return dfs(2, prices, 0, Integer.MAX_VALUE);
    }

    private int dfs(int k, int[] prices, int start, int min) {
        if (start == prices.length || k == 0) return 0;
        min = Math.min(min, prices[start]);
        return Math.max(dfs(k, prices, start + 1, min), prices[start] - min + dfs(k - 1, prices, start + 1, prices[start]));
    }*/

    /**
     * 两次交易，划分两个区间：prices[0...i]到prices[i...len-1]，求左区间最大利润leftProfit+右区间最大利润rightProfit。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length, res = 0;
        int[] leftProfit = new int[len];
        int[] rightProfit = new int[len];

        // 记录当前结点左边的最小价格
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(prices[i], min);
            leftProfit[i] = Math.max(prices[i] - min, leftProfit[i - 1]);
        }

        // 记录当前结点右边的最大价格
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            rightProfit[i] = Math.max(max - prices[i], rightProfit[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, leftProfit[i] + rightProfit[i]);
        }
        return res;
    }
}
