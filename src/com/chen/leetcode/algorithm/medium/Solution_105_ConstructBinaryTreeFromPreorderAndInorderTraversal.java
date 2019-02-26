package com.chen.leetcode.algorithm.medium;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author: chen
 * @date: 2019/2/25
 **/
public class Solution_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 递归
     */
    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;

        //此时preorder[pStart]为根节点，找到inorder中对应节点分割为两个区间，左边为左子树，右边为右子树
        int i;
        for (i = iStart; i < iEnd; i++) {
            if (preorder[pStart] == inorder[i]) break;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = build(preorder, pStart + 1, pStart + i - iStart, inorder, iStart, i - 1);
        root.right = build(preorder, pStart + i - iStart + 1, pEnd, inorder, i + 1, iEnd);
        return root;
    }
}
