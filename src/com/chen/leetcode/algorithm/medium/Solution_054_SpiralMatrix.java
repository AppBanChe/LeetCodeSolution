package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * @author: chen
 * @date: 2019/2/5
 **/
public class Solution_054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row, col;
        if (matrix == null || (row = matrix.length) == 0 || (col = matrix[0].length) == 0) return res;
        //左上->右下
        int beginX = 0, beginY = 0, endX = row - 1, endY = col - 1;
        while (beginX <= endX && beginY <= endY) {
            //边界条件
            if (beginX == endX) {
                for (int i = beginY; i <= endY; i++) res.add(matrix[beginX][i]);
                break;
            } else if (beginY == endY) {
                for (int i = beginX; i <= endX; i++) res.add(matrix[i][beginY]);
                break;
            }
            for (int i = beginY; i < endY; i++) res.add(matrix[beginX][i]);
            for (int i = beginX; i < endX; i++) res.add(matrix[i][endY]);
            for (int i = endY; i > beginY; i--) res.add(matrix[endX][i]);
            for (int i = endX; i > beginX; i--) res.add(matrix[i][beginY]);
            beginX++;
            beginY++;
            endX--;
            endY--;
        }
        return res;
    }
}
