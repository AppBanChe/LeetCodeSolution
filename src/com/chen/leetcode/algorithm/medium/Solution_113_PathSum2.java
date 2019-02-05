package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 如，给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_113_PathSum2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        find(root, res, new ArrayList<>(), sum);
        return res;
    }

    private void find(TreeNode node, List<List<Integer>> res, List<Integer> out, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        out.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(out));
        }
        find(node.left, res, out, sum);
        find(node.right, res, out, sum);
        //不是所求路径时，将node节点删除
        out.remove(out.size() - 1);
    }
}
