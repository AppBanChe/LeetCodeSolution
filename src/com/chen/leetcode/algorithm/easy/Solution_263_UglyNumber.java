package com.chen.leetcode.algorithm.easy;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 输入: 6，输出: true
 * 解释: 6 = 2 × 3
 *
 * @author: chen
 * @date: 2019/1/2
 **/
public class Solution_263_UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
