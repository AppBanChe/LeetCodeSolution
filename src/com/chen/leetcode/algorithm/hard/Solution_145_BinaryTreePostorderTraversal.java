package com.chen.leetcode.algorithm.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [3,2,1]
 *
 * @author: chen
 * @date: 2019/2/3
 **/
public class Solution_145_BinaryTreePostorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代，后序遍历是左右根，可以利用前序遍历(LeetCode 144)得到根右左，再通过栈逆序可得结果。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.push(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return res;
    }
}
