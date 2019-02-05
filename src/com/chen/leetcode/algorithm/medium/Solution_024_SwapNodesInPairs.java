package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 如，给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author: chen
 * @date: 2019/1/11
 **/
public class Solution_024_SwapNodesInPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy, temp;
        //last.next和last.next.next交换
        while (last.next != null && last.next.next != null) {
            temp = last.next.next;
            last.next.next = temp.next;
            temp.next = last.next;
            last.next = temp;
            last = temp.next;
        }
        return dummy.next;
    }
}
