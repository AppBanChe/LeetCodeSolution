package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_053_MaximumSubarray {
    /**
     * O(N)
     */
/*    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            //cur是以i结尾的子数组的最大和
            cur = cur > 0 ? cur + nums[i] : nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }
    */

    /**
     * 分治
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftMax = helper(nums, left, mid - 1);
        int rightMax = helper(nums, mid + 1, right);
        int centerMax = nums[mid], temp = centerMax;
        for (int i = mid - 1; i >= left; --i) {
            temp += nums[i];
            centerMax = Math.max(centerMax, temp);
        }
        temp = centerMax;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            centerMax = Math.max(centerMax, temp);
        }
        return Math.max(centerMax, Math.max(leftMax, rightMax));
    }
}
