package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> initList = new ArrayList<>();
        initList.add(1);
        res.add(initList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> oldList = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(oldList.get(j - 1) + oldList.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
