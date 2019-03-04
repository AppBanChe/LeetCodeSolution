package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 *
 * @author: chen
 * @date: 2019/3/3
 **/
public class Solution_669_TrimABinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*    public TreeNode trimBST(TreeNode root, int L, int R) {
            while (root != null) {
                if (root.val > R) root = root.left;
                else if (root.val < L) root = root.right;
                else {
                    root.left = trimBST(root.left, L, R);
                    root.right = trimBST(root.right, L, R);
                    break;
                }
            }
            return root;
        }
        */

    /**
     * 更简短
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
