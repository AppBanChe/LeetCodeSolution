package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_137_SingleNumber2 {
    /**
     * 见 http://www.cnblogs.com/grandyang/p/4263927.html
     */
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; ++i) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
