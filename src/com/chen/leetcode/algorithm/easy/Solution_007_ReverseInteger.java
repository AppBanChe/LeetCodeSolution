package com.chen.leetcode.algorithm.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_007_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int temp;
        while (x != 0) {
            temp = res * 10 + x % 10;
            //溢出
            if (temp / 10 != res) return 0;
            x /= 10;
            res = temp;
        }
        return res;
    }
}
