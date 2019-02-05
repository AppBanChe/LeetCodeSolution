package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 如，输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @author: chen
 * @date: 2018/12/4
 **/
public class Solution_046_Permutations {
    public static List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
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
            //nums[n]与从nums[n...length-1]的所有元素交换，以此穷举所有情况
            for (int i = n; i < nums.length; i++) {
                swap(nums, n, i);
                process(nums, n + 1);
                swap(nums, n, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
