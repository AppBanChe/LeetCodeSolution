package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * @author: chen
 * @date: 2019/2/8
 **/
public class Solution_216_CombinationSum3 {

    /**
     * 回溯
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        //因为不存在重复，所以k最大9个，n最大45
        if (k == 0 || n == 0 || k > 9 || n > 45) return res;
        dfs(k, n, res, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(int k, int n, List<List<Integer>> res, ArrayList<Integer> out, int start) {
        if (k < 0) return;
        if (k == 0 && n == 0) res.add(new ArrayList<>(out));
        for (int i = start; i <= 9 && n >= i; i++) {
            out.add(i);
            dfs(k - 1, n - i, res, out, i + 1);
            out.remove(out.size() - 1);
        }
    }
}
