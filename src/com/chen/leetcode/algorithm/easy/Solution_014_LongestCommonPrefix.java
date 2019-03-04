package com.chen.leetcode.algorithm.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明: 所有输入只包含小写字母 a-z 。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String res = strs[0];
        int len = res.length();
        for (int i = 1; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
            for (int j = 0; j < len; j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    len = j;
                    break;
                }
            }

        }
        return res.substring(0, len);
    }
}
