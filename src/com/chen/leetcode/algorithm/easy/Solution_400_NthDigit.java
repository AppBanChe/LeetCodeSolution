package com.chen.leetcode.algorithm.easy;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 输入:3 输出:3
 * 输入:11 输出:0
 * 其实是把整数序列看成一个长的字符串，如10，变成'1'、'0'这样的字符，问第n个字符是什么
 *
 * @author: chen
 * @date: 2019/1/1
 **/
public class Solution_400_NthDigit {
    public int findNthDigit(int n) {
        //len为位数，cnt是区间数字个数，start是区间起始数字
        long len = 1, cnt = 9, start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            ++len;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String t = start + "";
        return t.charAt((int) ((n - 1) % len)) - '0';
    }
}
