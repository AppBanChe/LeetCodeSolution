package com.chen.leetcode.algorithm.easy;

/**
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author: chen
 * @date: 2019/1/16
 **/
public class Solution_404_SumOfLeftLeaves {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
