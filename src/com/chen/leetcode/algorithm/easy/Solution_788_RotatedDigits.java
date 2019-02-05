package com.chen.leetcode.algorithm.easy;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * 如，输入: 10，输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * 注意: N 的取值范围是 [1, 10000]。
 *
 * @author: chen
 * @date: 2019/1/5
 **/
public class Solution_788_RotatedDigits {
    /**
     * 穷举
     */
    /*public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (check(i)) res++;
        }
        return res;
    }
    private boolean check(int num) {
        String str = num + "";
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '3' || c == '4' || c == '7') return false;
            if (c == '2' || c == '5' || c == '6' || c == '9') flag = true;
        }
        return flag;
    }*/

    /**
     * dp
     */
    public int rotatedDigits(int N) {
        int res = 0;
        //dp[i]取值，0即翻转后不合法，1表示翻转后和原数相同，2表示翻转后形成不同数
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    ++res;
                }
            } else {
                // 因为dp[i]其实可以从 dp[i / 10]和dp[i % 10]得到，
                // 如三位数abc，可以被拆分为ab和c，ab和c的情况已经计算过
                int a = dp[i / 10], b = dp[i % 10];
                if (a == 1 && b == 1) dp[i] = 1;
                else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    ++res;
                }
            }
        }
        return res;
    }
}
