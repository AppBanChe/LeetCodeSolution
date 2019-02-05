package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 如，输入: [10,9,2,5,3,7,101,18]，输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @author: chen
 * @date: 2018/12/23
 **/
public class Solution_300_LongestIncreasingSubsequence {

    /*
    //记忆性数组递归搜索
    private int[] mem;

    public int lengthOfLIS(int[] nums) {
        mem = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, process(nums, i));
        }
        return res;
    }

    //以tmp[idx]为末尾的子序列最长长度
    private int process(int[] nums, int idx) {
        if (mem[idx] != 0) {
            return mem[idx];
        }

        int res = 1;
        for (int i = 0; i < idx; i++) {
            if (nums[idx] > nums[i]) {
                res = Math.max(res, 1+process(nums, i));
            }
        }
        mem[idx] = res;
        return res;
    }*/

   /*
   //迭代
   public int lengthOfLIS(int[] nums) {
        int[] mem = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, mem[j]+1);
                }
            }
            mem[i] = tmp;
            res = Math.max(res, tmp);
        }
        return res;
    }*/

    //binarySearch
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[res - 1]) {
                dp[res++] = nums[i];
                continue;
            }
            int left = 0, right = res - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //此时dp[left]是第一个比nums[i]大的元素
            dp[left] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_300_LongestIncreasingSubsequence()
                .lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
