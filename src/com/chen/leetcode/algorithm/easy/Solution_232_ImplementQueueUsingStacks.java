package com.chen.leetcode.algorithm.easy;

import java.util.LinkedList;

/**
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_232_ImplementQueueUsingStacks {
    class MyQueue {
        private LinkedList<Integer> data;
        private LinkedList<Integer> helper;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            data = new LinkedList<>();
            helper = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            data.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (helper.isEmpty()) {
                transfer();
            }
            return helper.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (helper.isEmpty()) {
                transfer();
            }
            return helper.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return data.isEmpty() && helper.isEmpty();
        }

        private void transfer() {
            //将data栈中元素倒入helper栈中
            while (!data.isEmpty()) {
                helper.push(data.pop());
            }
        }
    }
}
