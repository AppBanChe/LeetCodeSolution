package com.chen.leetcode.algorithm.easy;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_067_AddBinary {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder res = new StringBuilder(Math.max(aLen, bLen) + 1);
        int carry = 0, i = aLen - 1, j = bLen - 1;
        while (i >= 0 || j >= 0) {
            int aTmp = i == -1 ? 0 : a.charAt(i--) - '0';
            int bTmp = j == -1 ? 0 : b.charAt(j--) - '0';
            int sum = aTmp + bTmp + carry;
            carry = sum / 2;
            res.insert(0, sum % 2);
        }
        if (carry != 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
