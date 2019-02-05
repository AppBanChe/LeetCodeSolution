package com.chen.leetcode.algorithm.medium;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 输入: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_337_HouseRobber3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
    //可以偷时，所能取得的最大值
    public static Map<TreeNode, Integer> robCache;
    //不能偷时，所能取得的最大值
    public static Map<TreeNode, Integer> notRobCache;

    public int rob(TreeNode root) {
        robCache = new HashMap<>();
        notRobCache = new HashMap<>();
        return process(root, true);
    }

    private int process(TreeNode node, boolean canRob) {
        if (node == null) {
            return 0;
        }
        if (canRob && robCache.containsKey(node)) {
            return robCache.get(node);
        } else if (!canRob && notRobCache.containsKey(node)) {
            return notRobCache.get(node);
        }

        int robbedVal, notRobbedVal, res;
        if (!canRob) {
            //上个结点被偷，此时只能不偷
            notRobbedVal = process(node.left, true) + process(node.right, true);
            notRobCache.put(node, notRobbedVal);
            return notRobbedVal;
        } else {
            //此时可以偷也可以不偷
            robbedVal = node.val + process(node.left, false) + process(node.right, false);
            notRobbedVal = process(node.left, true) + process(node.right, true);
            res = Math.max(robbedVal, notRobbedVal);
            robCache.put(node, res);
            return res;
        }
    }*/

    //更优解
    public int rob(TreeNode root) {
        //res[0]表示不包含当前节点值的最大值，res[1]表示包含当前值的最大值
        int[] res = process(root);
        return Math.max(res[0], res[1]);
    }

    private int[] process(TreeNode node) {
        int[] res = new int[]{0, 0};
        if (node == null) {
            return res;
        }
        int[] left = process(node.left);
        int[] right = process(node.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //包含当前结点值时，左、右孩子值不能被包含
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}
