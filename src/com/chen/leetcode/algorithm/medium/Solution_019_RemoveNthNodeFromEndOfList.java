package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 如，给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author: chen
 * @date: 2019/1/7
 **/
public class Solution_019_RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode quick = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            quick = quick.next;
        }

        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
