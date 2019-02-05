package com.chen.leetcode.algorithm.medium;

import java.util.LinkedList;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * @author: chen
 * @date: 2019/1/15
 **/
public class Solution_150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> digit = new LinkedList<>();
        int a, b;
        for (String token : tokens) {
            if ("+".equals(token)) {
                digit.push(digit.pop() + digit.pop());
            } else if ("-".equals(token)) {
                a = digit.pop();
                b = digit.pop();
                digit.push(b - a);
            } else if ("*".equals(token)) {
                a = digit.pop();
                b = digit.pop();
                digit.push(a * b);
            } else if ("/".equals(token)) {
                a = digit.pop();
                b = digit.pop();
                digit.push(b / a);
            } else {
                digit.push(Integer.parseInt(token));
            }
        }
        return digit.pop();
    }
}
