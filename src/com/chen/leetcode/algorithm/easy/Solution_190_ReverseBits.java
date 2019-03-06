package com.chen.leetcode.algorithm.easy;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 如，输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_190_ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
