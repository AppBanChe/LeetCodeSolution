package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * p = 2, q = 8
 * 输出: 6，解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_235_LowestCommonOfABinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 如果root小于p和q中最小值，那么p和q肯定在右子树；
     * 如果root大于p和q中最大值，那么p和q肯定在左子树；
     * 如果都不是，那么root是最小共同父节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /*
    //迭代写法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //因为该题必定有解，所以为死循环
        while (true) {
            if (root.val < Math.min(p.val, q.val)) {
                root = root.right;
            } else if (root.val > Math.max(p.val, q.val)) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }*/
}
