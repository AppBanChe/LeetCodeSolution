package com.chen.leetcode.algorithm.medium;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 如，s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * @author: chen
 * @date: 2019/1/10
 **/
public class Solution_392_IsSubsequence {
    /*public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        int cur = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(cur) == t.charAt(i)) cur++;
            if (cur == s.length()) return true;
        }
        return false;
    }*/

    /**
     * 利用String.indexOf()方法
     */
    public boolean isSubsequence(String s, String t) {
        int curr = -1;
        for (int i = 0; i < s.length(); i++) {
            curr = t.indexOf(s.charAt(i), curr + 1);
            if (curr < 0) {
                return false;
            }
        }
        return true;
    }
}
