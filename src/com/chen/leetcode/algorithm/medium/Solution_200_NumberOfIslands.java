package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * 如，输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_200_NumberOfIslands {
    private static int[][] ways = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (process(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean process(char[][] grid, int x, int y) {
        if (x == -1 || x == grid.length
                || y == -1 || y == grid[0].length
                || grid[x][y] == '0') {
            return false;
        }
        grid[x][y] = '0';
        for (int i = 0; i < ways.length; i++) {
            process(grid, x + ways[i][0], y + ways[i][1]);
        }
        return true;
    }
}
