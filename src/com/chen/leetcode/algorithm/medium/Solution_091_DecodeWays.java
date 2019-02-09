package com.chen.leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 如：
 * 输入: "12"，输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * @author: chen
 * @date: 2019/2/6
 **/
public class Solution_091_DecodeWays {
    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return process(s, mem, 0);
    }

    private int process(String s, int[] mem, int cur) {
        int len = s.length();
        if (cur == len) return 1;
        if (mem[cur] == -1) {
            if (s.charAt(cur) == '0') return (mem[cur] = 0);
            mem[cur] = process(s, mem, cur + 1);
            if (cur + 1 < len && check(s, cur)) {
                mem[cur] += process(s, mem, cur + 2);
            }
        }
        return mem[cur];
    }

    private boolean check(String s, int cur) {
        return s.charAt(cur) == '1' || (s.charAt(cur) == '2' && s.charAt(cur + 1) <= '6');
    }
}
