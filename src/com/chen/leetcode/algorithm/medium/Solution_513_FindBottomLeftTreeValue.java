package com.chen.leetcode.algorithm.medium;

import java.util.LinkedList;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 如，输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:1
 * 
 * @author: chen
 * @date: 2018/12/17
 **/
public class Solution_513_FindBottomLeftTreeValue {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode res = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (last == node) {
                res = queue.peek() == null ? res : queue.peek();
                last = queue.peekLast();
            }
        }
        return res.val;
    }

    /*
    递归，每进入新的一层，layer会大于maxLayer，此时node为头结点
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int layer) {
        if (node == null) return;
        ++layer;
        if (layer > maxLayer) {
            maxLayer = layer;
            res = node.val;
        }
        helper(node.left, layer);
        helper(node.right, layer);
    }
    */

    /*
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode firstNode = null;
        while (!queue.isEmpty()) {
            firstNode = queue.poll();
            int size = queue.size();
            if (firstNode.left != null) queue.offer(firstNode.left);
            if (firstNode.right != null) queue.offer(firstNode.right);
            //加速遍历
            for (int idx = 0; idx < size; idx++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return firstNode.val;
    }*/
}
