package com.chen.leetcode.algorithm.easy;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * 如，输入: 19
 * 输出: true
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_202_HappyNumber {
    public boolean isHappy(int n) {
        while (n != 1) {
            //如果n不是快乐数，那么一定会进入4，16，37，58，89，145，42，20，4的循环中
            if (n == 4)
                return false;
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}
