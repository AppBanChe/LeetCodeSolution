package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 如，输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 不使用循环或者递归，且在 O(1) 时间复杂度内解决
 *
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_258_AddDigits {

    /**
     * 当num为11时，输出2；为17时，输出8，多举几例，可以看出规律。
     * 结果是个周期为9的循环，即num%9
     * 因为num为9时，结果为9，为了处理该情况，采用这样的形式
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
