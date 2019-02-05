package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_257_BinaryTreePaths {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String out = root.val + "";
        process(root.left, res, out);
        process(root.right, res, out);
        if (root.left == null && root.right == null) {
            res.add(out);
        }
        return res;
    }

    private void process(TreeNode node, List<String> res, String out) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(out + "->" + node.val);
            return;
        }

        process(node.left, res, out + "->" + node.val);
        process(node.right, res, out + "->" + node.val);
    }

}
