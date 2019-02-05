package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_098_ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        int leftMax, rightMin;
        boolean[] valid = new boolean[]{true};
        if (root.left != null) {
            leftMax = dfs(root.left, valid)[1];
            //当前结点若小于等于左子树最大值
            if (!valid[0] || root.val <= leftMax) return false;
        }
        if (root.right != null) {
            rightMin = dfs(root.right, valid)[0];
            //当前结点若大于等于右子树最小值
            if (!valid[0] || root.val >= rightMin) return false;
        }
        return true;
    }

    private int[] dfs(TreeNode node, boolean[] valid) {
        //pair[0]是包括node结点的树中最小值，pair[1]是包括node结点的树中最大值.
        int[] pair = new int[]{node.val, node.val};
        if (!valid[0]) {
            return pair;
        }
        if (node.left != null) {
            int[] left = dfs(node.left, valid);
            pair[0] = left[0];
            if (node.val <= left[1]) valid[0] = false;
        }
        if (node.right != null) {
            int[] right = dfs(node.right, valid);
            pair[1] = right[1];
            if (node.val >= right[0]) valid[1] = false;
        }
        return pair;
    }*/


    /**
     * 更简洁
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);
    }
}
