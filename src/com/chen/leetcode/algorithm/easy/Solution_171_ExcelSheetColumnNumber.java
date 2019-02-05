package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 如，输入: "A"，输出: 1
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
