package com.chen.leetcode.algorithm.medium;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * @author: chen
 * @date: 2019/2/16
 **/
public class Solution_006_ZigZagConversion {

    /**
     * 画图，列举出图形的下标，可以找到规律
     */
    public String convert(String s, int numRows) {
        int len;
        if (s == null || numRows == 0 || numRows == 1 || (len = s.length()) <= numRows) return s;
        StringBuilder res = new StringBuilder();
        int gap = (numRows << 1) - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += gap) {
                res.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + gap - (i << 1) < len)
                    res.append(s.charAt(j + gap - (i << 1)));
            }
        }
        return res.toString();
    }
}
