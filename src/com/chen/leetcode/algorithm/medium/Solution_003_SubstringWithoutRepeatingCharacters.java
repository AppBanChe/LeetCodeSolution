package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"，输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_003_SubstringWithoutRepeatingCharacters {
    /*public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        int start = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer last = map.get(arr[i]);
            if (last == null || last < start) {
                map.put(arr[i], i);
                res = Math.max(res, ++len);
            } else {
                start = last + 1;
                map.replace(arr[i], i);
                len = i - start + 1;
            }
        }
        return res;
    }
*/
    //更简洁
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;
        int[] index = new int[256];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            res = Math.max(res, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return res;
    }
}
