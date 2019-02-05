package com.chen.leetcode.algorithm.easy;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 输入: "Hello, my name is John"，输出: 5
 *
 * @author: chen
 * @date: 2019/1/3
 **/
public class Solution_434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            while (i + 1 < len && s.charAt(++i) != ' ') ;
            res++;
        }
        return res;
    }
}
