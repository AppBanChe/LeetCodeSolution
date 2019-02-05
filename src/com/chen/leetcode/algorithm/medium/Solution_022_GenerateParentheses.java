package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，
 * 请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_022_GenerateParentheses {
    private static List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        process(n, n, "");
        return res;
    }

    private void process(int left, int right, String s) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(s);
        } else {
            if (left > 0) process(left - 1, right, s + "(");
            if (right > 0) process(left, right - 1, s + ")");
        }
    }
}
