package com.chen.leetcode.algorithm.easy;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_234_PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            if (fast.next.val == slow.val) {
                if (fast.next.next != null) return false;
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if (fast == null || fast.val == slow.val) return true;
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
}
