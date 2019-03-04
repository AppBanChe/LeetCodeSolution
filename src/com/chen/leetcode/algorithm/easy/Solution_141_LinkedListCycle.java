package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_141_LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (low != null && fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) return true;
        }
        return false;
    }
}
