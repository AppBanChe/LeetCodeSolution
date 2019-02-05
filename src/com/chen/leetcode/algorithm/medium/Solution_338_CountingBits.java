package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 输入: 5，输出: [0,1,1,2,1,2]
 *
 * @author: chen
 * @date: 2019/1/10
 **/
public class Solution_338_CountingBits {
    /**
     * 利用i&(i-1)，可以得到去掉最后一位1的数，如1010，变为1000,
     */
    /*public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }*/

    /**
     * 二进制数，如11010，1的个数等于1101的个数加上最后一位
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
