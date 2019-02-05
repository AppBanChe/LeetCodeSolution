package com.chen.leetcode.algorithm.hard;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 如，输入: 13,输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 *
 * @author: chen
 * @date: 2019/1/11
 **/
public class Solution_233_NumberOfDigitOne {
    /**
     * 使用数组，超出内存限制
     */
    /*public int countDigitOne(int n) {
        int[] mem = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            mem[i] = mem[i / 10] + (i % 10 == 1 ? 1 : 0);
            res += mem[i];
        }
        return res;
    }*/

    /**
     * 通过规律，1-99中，1、10、21、31...91出现10个'1'，加上10-19中额外有10个'1'，总共20个1
     * 类似地，在100-199中每10个数的区间都有11个'1'，除去110-119额外10个'1'，所以是11*9+21
     */
    public int countDigitOne(int n) {
        int res = 0, a = 1, b = 1;
        while (n > 0) {
            res += (n + 8) / 10 * a + (n % 10 == 1 ? b : 0);
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return res;
    }


}
