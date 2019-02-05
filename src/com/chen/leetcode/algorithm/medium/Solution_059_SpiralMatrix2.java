package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author: chen
 * @date: 2019/2/5
 **/
public class Solution_059_SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //因为是正方形，对角线对称，所以cur对应n-cur-1
        int val = 1, cur = 0;
        while (val <= n * n) {
            if (val == n * n) {
                res[cur][cur] = val;
                break;
            }
            for (int i = cur; i < n - cur - 1; i++) res[cur][i] = val++;
            for (int i = cur; i < n - cur - 1; i++) res[i][n - cur - 1] = val++;
            for (int i = n - cur - 1; i > cur; i--) res[n - cur - 1][i] = val++;
            for (int i = n - cur - 1; i > cur; i--) res[i][cur] = val++;
            cur++;
        }
        return res;
    }
}
