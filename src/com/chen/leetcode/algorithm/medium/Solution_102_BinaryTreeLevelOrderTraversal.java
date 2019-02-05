package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 如，给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_102_BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> out = new ArrayList<>();
            TreeNode first = null;
            while (queue.peek() != first) {
                TreeNode node = queue.poll();
                out.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    first = first == null ? node.left : first;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    first = first == null ? node.right : first;
                }
            }
            res.add(out);
        }
        return res;
    }
}
