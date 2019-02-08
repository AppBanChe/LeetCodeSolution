package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * @author: chen
 * @date: 2019/2/8
 **/
public class Solution_040_CombinationSum2 {

    /**
     * 回溯
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> out, int start) {
        if (target == 0) res.add(new ArrayList<>(out));
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            //保证不重复
            if (i > start && candidates[i - 1] == candidates[i]) continue;
            out.add(candidates[i]);
            dfs(res, candidates, target - candidates[i], out, i + 1);
            out.remove(out.size() - 1);
        }
    }
}
