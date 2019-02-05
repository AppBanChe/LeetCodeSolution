package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 如，输入: [1,1,2]
 * 输出:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 * @author: chen
 * @date: 2018/12/4
 **/
public class Solution_047_Permutations2 {
    public static List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        process(nums, 0);
        return res;
    }

    private void process(int[] nums, int n) {
        if (n == nums.length) {
            List<Integer> out = new ArrayList<>();
            for (int num : nums) {
                out.add(num);
            }
            res.add(out);
        } else {
            for (int i = n; i < nums.length; i++) {
                if (!isDuplicate(nums, n, i)) continue;
                swap(nums, n, i);
                process(nums, n + 1);
                swap(nums, n, i);
            }
        }
    }

    private boolean isDuplicate(int[] nums, int n, int i) {
        while (n < i) {
            if (nums[n] == nums[i]) return false;
            n++;
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
