package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_104_MaximumDepthofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return process(root, 0);
    }

    private int process(TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        return Math.max(process(node.left, height + 1),
                process(node.right, height + 1));
    }
}
