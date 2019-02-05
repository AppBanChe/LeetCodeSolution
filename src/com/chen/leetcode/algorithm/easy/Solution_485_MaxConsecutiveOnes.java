package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                res = res > count ? res : count;
                count = 0;
            } else
                count++;
        }
        return res > count ? res : count;
    }
}
