package com.chen.leetcode.algorithm.easy;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_020_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        LinkedList<Character> stack = new LinkedList<>();

        char[] chars = s.toCharArray();

        for (char cur : chars) {
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.size() == 0) return false;

                Character last = stack.pop();
                if (last == '(' && cur != ')') return false;
                else if (last == '{' && cur != '}') return false;
                else if (last == '[' && cur != ']') return false;
            }
        }
        return stack.size() == 0;
    }
}
