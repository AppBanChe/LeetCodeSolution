package com.chen.leetcode.algorithm.easy;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_160_IntersectionOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    //将长链表变短，即求出长度差值len，使长链表先走len步，再同时遍历判断
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1.next != null) {
            len++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            len--;
            p2 = p2.next;
        }
        if (p1.val != p2.val) {
            return null;
        }
        p1 = len > 0 ? headA : headB;
        p2 = p1 == headA ? headB : headA;
        len = Math.abs(len);
        while (len-- != 0) {
            p1 = p1.next;
        }
        while (p1!= p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }*/

    //遍历，当其中一条遍历到末尾时，跳到另一个条链表的开头继续遍历
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
