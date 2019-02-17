package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * @author: chen
 * @date: 2019/2/6
 **/
public class Solution_005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) return "";
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            i = expand(s, i, range);
        }
        return s.substring(range[0], range[1]);
    }

    private int expand(String s, int left, int[] range) {
        int right = left;
        //回文向右扩充，跳过重复项，以此忽略回文奇偶
        while (right < s.length() - 1 && s.charAt(right + 1) == s.charAt(left)) {
            right++;
        }
        int next = right;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > range[1] - range[0]) {
            range[1] = right;
            range[0] = left + 1;
        }
        return next;
    }
}
