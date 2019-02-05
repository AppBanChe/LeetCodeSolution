package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_515_FindLargestValueInEachTreeRow {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max;
        while (!queue.isEmpty()) {
            max = queue.peek().val;
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }

    /**
     * DFS
     */
    /*public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) return;
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }*/
}
