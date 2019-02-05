package com.chen.leetcode.algorithm.hard;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4,解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * @author: chen
 * @date: 2018/12/23
 **/
public class Solution_329_LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //以matrix[i][j]为路径尾元素向前搜索
                res = Math.max(res, process(matrix, i, j));
            }
        }
        return res;
    }

    private static int[][] ways = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] mem;

    private int process(int[][] matrix, int x, int y) {
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        int max = 1;
        for (int[] way : ways) {
            int newX = x + way[0];
            int nexY = y + way[1];
            if (check(matrix, newX, nexY) && matrix[x][y] > matrix[newX][nexY]) {
                max = Math.max(max, process(matrix, newX, nexY) + 1);
            }
        }
        mem[x][y] = max;
        return max;
    }

    private boolean check(int[][] matrix, int x, int y) {
        return (x != -1 && x != matrix.length) && (y != -1 && y != matrix[0].length);
    }

    //test
    public static void main(String[] args) {
        System.out.println(new Solution_329_LongestIncreasingPath().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
