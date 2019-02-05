package com.chen.leetcode.algorithm.medium;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 如，输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_074_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从右上角开始搜索
        int m = 0, n = matrix[0].length;
        while (m != matrix.length && n != -1) {
            int val = matrix[m][n];
            if (val == target) return true;
            else if (val < target) m++;
            else n--;
        }
        return false;
    }
}
