package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。
 * 2--abc
 * 3--def
 * ...
 * 8--tuv
 * z--wxyz
 * 注意 1 不对应任何字母。
 *
 * @author: chen
 * @date: 2019/1/7
 **/
public class Solution_017_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(res, digits, 0, new char[digits.length()]);
        return res;
    }

    private void dfs(List<String> res, String digits, int start, char[] out) {
        if (start == digits.length()) {
            res.add(String.valueOf(out));
        } else {
            int c = digits.charAt(start) - '0';
            int len = c == 9 || c == 7 ? 4 : 3;
            c = c > 7 ? (c - 2) * 3 + 1 : (c - 2) * 3;
            for (int i = 0; i < len; i++) {
                out[start] = (char) ('a' + c + i);
                dfs(res, digits, start + 1, out);
            }
        }
    }
}
