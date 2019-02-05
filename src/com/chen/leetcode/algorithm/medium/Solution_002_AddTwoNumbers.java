package com.chen.leetcode.algorithm.medium;


/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author: chen
 * @date: 2018/12/2
 */
public class Solution_002_AddTwoNumbers {
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode next = head;
        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            carry = l1.val / 10;
            l1.val %= 10;

            next.next = l1;
            next = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            l1.val += carry;
            carry = l1.val / 10;
            l1.val %= 10;

            next.next = l1;
            next = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            l2.val += carry;
            carry = l2.val / 10;
            l2.val %= 10;

            next.next = l2;
            next = l2;
            l2 = l2.next;
        }

        if (carry != 0) {
            next.next = new ListNode(carry);
        }
        return head.next;
    }

    //递归思想
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        addTwoNumbers(l1, l2, l3);
        return l3;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode l3) {
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + l3.val;
        int a = sum/10;
        int b = sum%10;
        l3.val = b;
        if(l1.next != null || l2.next != null || a != 0){
            ListNode next = new ListNode(a);
            l3.next = next;
            addTwoNumbers(l1.next, l2.next, l3.next);
        }
    }*/
}
