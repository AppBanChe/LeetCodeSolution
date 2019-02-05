package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 如，输入: 1->1->2
 * 输出: 1->2
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_083_RemoveDuplicatesFromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
