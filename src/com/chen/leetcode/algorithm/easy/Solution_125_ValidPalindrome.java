package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)
                    || Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(j))) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
