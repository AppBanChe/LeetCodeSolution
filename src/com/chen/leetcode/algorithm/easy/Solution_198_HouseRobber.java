package com.chen.leetcode.algorithm.easy;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_198_HouseRobber {
    /*public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }*/

    public int rob(int[] nums) {
        int rob = 0, notRob = 0, preRob, preNotRob;
        for (int num : nums) {
            preRob = rob;
            preNotRob = notRob;
            rob = preNotRob + num;
            notRob = Math.max(preRob, preNotRob);
        }
        return Math.max(rob, notRob);
    }
}
