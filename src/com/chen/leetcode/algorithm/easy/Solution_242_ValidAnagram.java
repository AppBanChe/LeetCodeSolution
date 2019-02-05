package com.chen.leetcode.algorithm.easy;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 如，输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明: 你可以假设字符串只包含小写字母。
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author: chen
 * @date: 2019/1/13
 **/
public class Solution_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] mem = new int[26];
        for (char c : s.toCharArray()) {
            mem[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            mem[c - 'a']--;
        }
        for (int i : mem) {
            if (i != 0) return false;
        }
        return true;
    }
}
