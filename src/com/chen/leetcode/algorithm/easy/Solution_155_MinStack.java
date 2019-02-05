package com.chen.leetcode.algorithm.easy;

import java.util.LinkedList;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_155_MinStack {
    class MinStack {
        private LinkedList<Integer> stack;
        private LinkedList<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            int val;
            if (minStack.isEmpty() || (val = minStack.peek()) > x) {
                minStack.push(x);
            } else {
                minStack.push(val);
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
