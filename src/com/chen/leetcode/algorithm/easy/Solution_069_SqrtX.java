package com.chen.leetcode.algorithm.easy;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例:
 * 输入: 4，输出: 2
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_069_SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long res = x;
        //牛顿迭代法
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
