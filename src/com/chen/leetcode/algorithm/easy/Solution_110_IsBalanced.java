package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_110_IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[]{true};
        process(root, 1, flag);
        return flag[0];
    }

    private int process(TreeNode node, int level, boolean[] flag) {
        if (node == null) {
            return level;
        }
        int leftHeight = process(node.left, level + 1, flag);
        int rightHeight = process(node.right, level + 1, flag);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
