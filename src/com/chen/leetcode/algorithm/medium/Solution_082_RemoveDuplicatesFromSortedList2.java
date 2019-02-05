package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_082_RemoveDuplicatesFromSortedList2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy;
        while (last.next != null && last.next.next != null) {
            if (last.next.val == last.next.next.val) {
                while (last.next.next != null && last.next.val == last.next.next.val) {
                    last.next = last.next.next;
                }
                last.next = last.next.next;
            } else {
                last = last.next;
            }
        }

        return dummy.next;
    }
}
