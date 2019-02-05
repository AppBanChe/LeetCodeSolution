package com.chen.leetcode.algorithm.medium;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 如，输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author: chen
 * @date: 2019/1/12
 **/
public class Solution_238_ProductOfArrayExceptSelf {
    /**
     * 从左向右遍历，得到左边的乘积；再从右向左遍历，通过变量保存右边的乘积。
     */
    public int[] productExceptSelf(int[] nums) {
        int len, right = 1;
        if (nums == null || (len = nums.length) == 0) return new int[0];
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
