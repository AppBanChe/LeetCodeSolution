package com.chen.leetcode.algorithm.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author: chen
 * @date: 2019/1/7
 **/
public class Solution_023_MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用最小堆
     */
    /*public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(-1), cur = head;
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) heap.offer(node.next);
            cur.next = node;
            cur = node;
        }
        return head.next;
    }*/

    /**
     * 分治
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = lists.length, k;
        while (n > 1) {
            k = (n + 1) / 2;
            for (int i = 0; i < n / 2; ++i) {
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode helper = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                helper.next = l1;
                l1 = l1.next;
            } else {
                helper.next = l2;
                l2 = l2.next;
            }
            helper = helper.next;
        }
        if (l1 != null) {
            helper.next = l1;
        } else {
            helper.next = l2;
        }
        return head.next;
    }
}
