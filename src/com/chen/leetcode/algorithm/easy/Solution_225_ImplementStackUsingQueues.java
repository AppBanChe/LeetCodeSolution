package com.chen.leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * @author: chen
 * @date: 2018/12/25
 **/
public class Solution_225_ImplementStackUsingQueues {
    //使用双队列实现
    /*class MyStack {
        private Queue<Integer> data;
        private Queue<Integer> helper;

        *//**
     * Initialize your data structure here.
     *//*
        public MyStack() {
            data = new LinkedList<>();
            helper = new LinkedList<>();
        }

        *//**
     * Push element x onto data.
     *//*
        public void push(int x) {
            data.offer(x);
        }

        *//**
     * Removes the element on top of the data and returns that element.
     *//*
        public int pop() {
            while (data.size() > 1) {
                helper.offer(data.poll());
            }
            int val = data.poll();
            Queue<Integer> tmp = data;
            data = helper;
            helper = tmp;
            return val;
        }

        *//**
     * Get the top element.
     *//*
        public int top() {
            int val = this.pop();
            data.offer(val);
            return val;
        }

        */

    /**
     * Returns whether the data is empty.
     *//*
        public boolean empty() {
            return data.isEmpty();
        }
    }*/
    //使用单队列实现
    class MyStack {
        private Queue<Integer> data;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            data = new LinkedList<>();
        }

        /**
         * Push element x onto data.
         */
        public void push(int x) {
            data.offer(x);
            //将队列中前面已经逆序的元素放在x元素后面，使得整体逆序
            for (int i = 0; i < data.size() - 1; i++) {
                data.offer(data.poll());
            }
        }

        /**
         * Removes the element on top of the data and returns that element.
         */
        public int pop() {
            return data.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return data.peek();
        }

        /**
         * Returns whether the data is empty.
         */
        public boolean empty() {
            return data.isEmpty();
        }
    }
}
