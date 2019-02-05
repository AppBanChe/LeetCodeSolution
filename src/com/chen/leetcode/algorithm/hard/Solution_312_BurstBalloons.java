package com.chen.leetcode.algorithm.hard;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * 如，输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_312_BurstBalloons {

    /**
     * 记忆化搜索，参考 https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
     * 思路：在[0,n-1]范围中，正向思考是复杂的，即先扎破i号气球，再去穷举，效率太低。
     * 而如果逆向思考，考虑i号气球是最后扎破，此时值为nums[0]*nums[i]*nums[n-1]，并且将整个气球序列划分为[0,i]和[i,n]，再去考虑子问题即可。
     */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 2];
        System.arraycopy(nums, 0, temp, 1, len);
        temp[0] = temp[len + 1] = 1;
        int[][] mem = new int[len + 2][len + 2];
        return process(mem, temp, 0, len + 1);
    }

    private int process(int[][] mem, int[] temp, int left, int right) {
        //left和right之间至少有一个气球
        if (left + 1 == right) return 0;
        if (mem[left][right] > 0) return mem[left][right];
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, temp[left] * temp[i] * temp[right]
                    + process(mem, temp, left, i)
                    + process(mem, temp, i, right));
        }
        mem[left][right] = res;
        return res;
    }

    /**
     * dp
     */
    /*public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 2];
        System.arraycopy(nums, 0, temp, 1, len);
        temp[0] = temp[len + 1] = 1;
        len += 2;

        int[][] dp = new int[len][len];
        //k即[left,right]区间大小
        for (int k = 2; k < len; ++k)
            for (int left = 0; left < len - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            temp[left] * temp[i] * temp[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][len - 1];
    }*/
}
