package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * @author: chen
 * @date: 2019/1/5
 **/
public class Solution_061_RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        k %= len;
        if (k == 0) return head;
        ListNode fast = head, newHead;
        node = head;
        //右移k个位置，相当于将倒数第k个节点作为新的头结点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            node = node.next;
        }
        newHead = node.next;
        node.next = null;
        fast.next = head;
        return newHead;
    }
}
