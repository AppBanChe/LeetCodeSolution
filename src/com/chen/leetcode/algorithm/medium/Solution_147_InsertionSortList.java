package com.chen.leetcode.algorithm.medium;

/**
 * 对链表进行插入排序。
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * @author: chen
 * @date: 2019/1/5
 **/
public class Solution_147_InsertionSortList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = head;
        head = node;

        ListNode cur, insert, last = head.next;
        while (last.next != null) {
            cur = last.next;
            insert = head;
            while (insert != last) {
                if (insert.val <= cur.val && insert.next.val > cur.val) {
                    last.next = cur.next;
                    cur.next = insert.next;
                    insert.next = cur;
                    break;
                }
                insert = insert.next;
            }
            //判断是否插入过
            if (last.next != cur) {
                continue;
            }
            last = last.next;
        }
        return head.next;
    }
}
