package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_303_RangeSumQueryImmutable {
    class NumArray {
        //mem[i]代表nums[0]+...+nums[i]
        int[] mem;

        public NumArray(int[] nums) {
            int len = nums.length;
            if (len == 0) return;
            mem = new int[len];
            mem[0] = nums[0];
            for (int i = 1; i < len; i++) {
                mem[i] = mem[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? mem[j] : mem[j] - mem[i - 1];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
