package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @author: chen
 * @date: 2019/1/6
 **/
public class Solution_077_Combinations {
    /**
     * dfs
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int remain, int start, ArrayList<Integer> out, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(out));
        } else {
            // 判断条件使用了n - remain + 1，因为如果n=10，k=3，那么i=8时，只可能有7、8、9的情况；
            // 当i=9时，此时剩余数已经无法满足题意了，所以这样可以避免无用的递归
            for (int i = start; i <= n - remain + 1; i++) {
                out.add(i);
                dfs(n, remain - 1, i + 1, out, res);
                out.remove(out.size() - 1);
            }
        }
    }
}
