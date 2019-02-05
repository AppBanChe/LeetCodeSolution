package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 如，输入: 1，输出: "A"
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_168_ExcelSheetColumnTitle {
    /*public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            if (n % 26 == 0) {
                res.append('Z');
                n /= 26;
                n--;
            } else {
                res.append((char) (n % 26 + 'A' - 1));
                n /= 26;
            }
        }
        return res.reverse().toString();
    }*/

    //更简洁
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            // 因为正常的26进制是从0开始的（即0-25，为26时进位为10）
            // 此题是从1开始的
            res.append((char) (--n % 26 + 'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }
}
