package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 给定二叉树 [3,9,20,null,null,15,7],
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_111_MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, 1);
    }

    private int process(TreeNode node, int level) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return level;
        }
        int left = process(node.left, level + 1);
        int right = process(node.right, level + 1);
        return Math.min(left, right);
    }*/

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
