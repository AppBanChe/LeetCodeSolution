package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 如，输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * @author: chen
 * @date: 2019/2/8
 **/
public class Solution_039_CombinationSum {
    /**
     * 回溯
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        dfs(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> out, int start) {
        if (target == 0) res.add(new ArrayList<>(out));
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            out.add(candidates[i]);
            dfs(res, candidates, target - candidates[i], out, i);
            out.remove(out.size() - 1);
        }
    }
}
