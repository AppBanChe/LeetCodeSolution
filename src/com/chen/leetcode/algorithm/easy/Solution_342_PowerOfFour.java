package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 输入: 16，输出: true
 *
 * @author: chen
 * @date: 2019/1/2
 **/
public class Solution_342_PowerOfFour {
    /*public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 0;
    }*/

    /**
     * 确定是2的次方数后，要是4的次方数，减1之后可以被3整除
     */
    /*public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }*/

    /**
     * 如果是2的次方数后，与上一个数(0x55555555) <==> 1010101010101010101010101010101，
     * 如果得到的数还是其本身，则可以肯定其为4的次方数：
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }
}
