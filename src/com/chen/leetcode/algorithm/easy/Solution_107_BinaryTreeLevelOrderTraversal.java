package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_107_BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> out = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    helper.offer(node.left);
                }
                if (node.right != null) {
                    helper.offer(node.right);
                }
                out.add(node.val);
            }
            res.add(0, out);
            Queue<TreeNode> tmp = queue;
            queue = helper;
            helper = tmp;
        }
        return res;
    }
}
