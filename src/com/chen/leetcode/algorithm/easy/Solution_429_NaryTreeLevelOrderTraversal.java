package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * @author: chen
 * @date: 2019/1/3
 **/
public class Solution_429_NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 迭代
     */
    /*public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> out = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.poll();
                out.add(node.val);
                queue.addAll(node.children);
            }
            res.add(out);
        }
        return res;
    }*/

    /**
     * 递归
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(Node node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() == level) res.add(new ArrayList<>());

        res.get(level).add(node.val);
        for (Node child : node.children) {
            helper(child, level + 1, res);
        }
    }
}
