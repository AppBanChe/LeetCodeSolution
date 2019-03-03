package com.chen.leetcode.algorithm.medium;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author: chen
 * @date: 2019/3/3
 **/
public class Solution_106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历（左右根）的最后一个结点是根节点，而中序遍历（左根右）通过根节点得到左右子树，再对左右子树进行递归操作
     */
    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) return null;
        int i;
        for (i = iStart; i <= iEnd; i++) {
            if (postorder[pEnd] == inorder[i]) break;
        }
        TreeNode node = new TreeNode(inorder[i]);
        node.left = build(inorder, iStart, i - 1, postorder, pStart, pStart + i - iStart - 1);
        node.right = build(inorder, i + 1, iEnd, postorder, pStart + i - iStart, pEnd - 1);
        return node;
    }*/

    /**
     * 优化
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] post, int[] in, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int i;
        for (i = inEnd; i >= inStart; i--) {
            if (root.val == in[i]) break;
        }
        root.left = build(post, in, postEnd - 1 + i - inEnd, inStart, i - 1);
        root.right = build(post, in, postEnd - 1, i + 1, inEnd);
        return root;
    }

}
