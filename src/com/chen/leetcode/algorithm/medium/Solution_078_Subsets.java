package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出:
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 *
 * @author: chen
 * @date: 2019/1/3
 **/
public class Solution_078_Subsets {
    /**
     * dfs
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> out, List<List<Integer>> res) {
        res.add(new ArrayList<>(out));
        for (int i = start; i < nums.length; i++) {
            out.add(nums[i]);
            dfs(nums, i + 1, out, res);
            out.remove(out.size() - 1);
        }
    }
    */

    /**
     * nums中所有数，有两种情况：在子集出现或不出现，可以对应二进制，1出现，0不出现，总共有2^n情况
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int max = 1 << nums.length;
        for (int i = 0; i < max; i++) {
            List<Integer> out = new ArrayList<>();
            int index = 0;
            for (int j = i; j > 0; j >>= 1) {
                if ((j & 1) == 1) {
                    out.add(nums[index]);
                }
                index++;
            }
            res.add(out);
        }
        return res;
    }
}
