package com.chen.leetcode.algorithm.easy;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_038_CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder old = new StringBuilder().append("11");
        StringBuilder res = new StringBuilder();
        for (int i = 2; i < n; i++) {
            int count = 1;

            for (int j = 0; j < old.length() - 1; j++) {
                if (old.charAt(j) == old.charAt(j + 1)) {
                    count++;
                } else {
                    res.append(count).append(old.charAt(j));
                    count = 1;
                }
            }
            res.append(count).append(old.charAt(old.length() - 1));
            old = res;
            res = new StringBuilder();
        }

        return old.toString();
    }
}
