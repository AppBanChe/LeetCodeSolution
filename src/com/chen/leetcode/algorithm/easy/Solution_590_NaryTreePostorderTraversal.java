package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * @author: chen
 * @date: 2019/2/3
 **/
public class Solution_590_NaryTreePostorderTraversal {
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
    /*public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.push(root.val);
            for (Node child : root.children) {
                if (child != null) stack.push(child);
            }
        }
        return res;
    }*/

    /**
     * 递归
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node child : root.children) {
                postorder(child);
            }
            res.add(root.val);
        }
        return res;
    }
}
