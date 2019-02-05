package com.chen.leetcode.algorithm.easy;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while (left < right) {
            if (!check(c[left])) {
                left++;
            } else if (!check(c[right])) {
                right--;
            } else {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
        }
        return new String(c);
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
