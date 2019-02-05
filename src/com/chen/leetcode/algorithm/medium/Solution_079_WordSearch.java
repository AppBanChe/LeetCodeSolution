package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * @author: chen
 * @date: 2019/1/5
 **/
public class Solution_079_WordSearch {
    private static int[][] ways = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(visit, board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visit, char[][] board, int x, int y, String word, int cur) {
        if (cur == word.length()) {
            return true;
        }
        if (x == -1 || x == board.length || y == -1 || y == board[0].length ||
                visit[x][y] || board[x][y] != word.charAt(cur)) {
            return false;
        }

        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (dfs(visit, board, x + ways[i][0], y + ways[i][1], word, cur + 1)) {
                return true;
            }
        }
        //如果往四个方向遍历都无法匹配，则擦除此节点的访问记录
        visit[x][y] = false;
        return false;
    }
}
