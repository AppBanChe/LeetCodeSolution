package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个非空数组，返回此数组中第三大的数。
 * 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 输入: [3, 2, 1]
 * 输出: 1，解释: 第三大的数是 1.
 *
 * @author: chen
 * @date: 2019/1/1
 **/
public class Solution_414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, medium = Long.MIN_VALUE, res = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == max || num == medium || num == res) {
                continue;
            }
            if (num > max) {
                res = medium;
                medium = max;
                max = num;
            } else if (num > medium) {
                res = medium;
                medium = num;
            } else if (num > res) {
                res = num;
            }
        }
        return (int) ((res == Long.MIN_VALUE) ? max : res);
    }
}
