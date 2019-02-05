package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @author: chen
 * @date: 2019/1/13
 **/
public class Solution_383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mem = new int[26];
        for (char c : magazine.toCharArray()) {
            mem[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--mem[c - 'a'] < 0) return false;
        }
        return true;
    }
}
