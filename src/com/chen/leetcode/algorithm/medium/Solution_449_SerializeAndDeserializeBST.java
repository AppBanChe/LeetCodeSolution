package com.chen.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * @author: chen
 * @date: 2019/1/3
 **/
public class Solution_449_SerializeAndDeserializeBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "$_";
        }
        //通过前序遍历
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String value : s) {
            queue.offer(value);
        }
        return decoding(queue);
    }

    private TreeNode decoding(Queue<String> queue) {
        String val = queue.poll();
        if ("$".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = decoding(queue);
        node.right = decoding(queue);
        return node;
    }
}
