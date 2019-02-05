package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_058_LengthOfLastWord {
    /*public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i, j;
        char[] chars = s.toCharArray();
        int len = chars.length;
        //trim
        while (len > 0 && chars[len - 1] == ' ') {
            len--;
        }
        for (i = 0, j = -1; i < len; i++) {
            if (chars[i] == ' ') {
                j = i;
            }
        }

        return i - j - 1;
    }*/

    public int lengthOfLastWord(String s) {
        int num = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') flag = true;
            if (s.charAt(i) == ' ') {
                if (flag)
                    break;
            } else {
                num++;
            }
        }
        return num;
    }
}
