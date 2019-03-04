package com.chen.leetcode.algorithm.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_009_PalindromeNumber {
    public boolean IsPalindrome(int x) {
        //负数不为回文，并且个位数如果是0，那么最高位也应该是0：只有0满足条件
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        //位数可能为奇数或偶数
        return x == temp || x == temp / 10;
    }
}
