package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author: chen
 * @date: 2019/4/17
 **/
public class Solution_114_FlattenBinaryTreeToLinkedList {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        //将左右子树，展开
        flatten(root.left);
        flatten(root.right);

        //将已展开的左子树插入到根节点右侧
        if (root.left != null) {
            TreeNode leftNode = root.left;
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
