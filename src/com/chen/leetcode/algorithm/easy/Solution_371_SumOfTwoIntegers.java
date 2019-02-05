package com.chen.leetcode.algorithm.easy;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 如，输入: a = 1, b = 2，输出: 3
 *
 * @author: chen
 * @date: 2019/1/13
 **/
public class Solution_371_SumOfTwoIntegers {
    /**
     * 迭代
     * 将a+b分为三步：
     *  1.不考虑进位的a+b(即0+0=0,1+0=1,1+1=0，和异或结果一样)
     *  2.计算进位(只有1+1才会进位，即a&b，并且左移一位)
     *  3.将上述两步结果加上(此时问题变为求不考虑进位的a+b和进位结果相加，直到进位为0时结束)
     */
    /*public int getSum(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;

            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }*/

    /**
     * 递归
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
