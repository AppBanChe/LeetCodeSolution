package com.chen.leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 示例:
 * nums = [1, 2, 3]，target = 4
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * @author: chen
 * @date: 2019/2/8
 **/
public class Solution_377_CombinationSum4 {
    /**
     * 记忆化搜索
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
        int[] mem = new int[target + 1];
        Arrays.fill(mem, -1);
        return dfs(nums, mem, target);
    }

    private int dfs(int[] nums, int[] mem, int target) {
        if (target <= 0) return target == 0 ? 1 : 0;
        if (mem[target] == -1) {
            int res = 0;
            for (int num : nums) {
                res += dfs(nums, mem, target - num);
            }
            mem[target] = res;
        }
        return mem[target];
    }

    /**I
     * 动态规划
     */
    /*public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
    */
}
