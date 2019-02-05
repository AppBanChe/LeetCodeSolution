package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * @author: chen
 * @date: 2019/2/3
 **/
public class Solution_589_NaryTreePreorderTraversal {
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
    /*public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            //逆序
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.push(root.children.get(i));
            }
        }
        return res;
    }
*/

    /**
     * 递归
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return res;
    }
}
