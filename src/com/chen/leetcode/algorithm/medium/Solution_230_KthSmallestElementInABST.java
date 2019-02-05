package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 如，输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 *
 * @author: chen
 * @date: 2018/12/29
 **/
public class Solution_230_KthSmallestElementInABST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;

    /**
     * 中序遍历，用count记录经过的节点数
     */
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        if (root == null) return res;
        res = kthSmallest(root.left, k);
        if (count == k) return res;
        if (++count == k) return root.val;
        return kthSmallest(root.right, k);
    }
}
