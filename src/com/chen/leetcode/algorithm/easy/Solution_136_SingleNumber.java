package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 如，输入: [2,2,1]
 * 输出: 1
 *
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_136_SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        return xor;
    }
}
