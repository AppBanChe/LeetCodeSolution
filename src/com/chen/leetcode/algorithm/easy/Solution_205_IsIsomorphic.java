package com.chen.leetcode.algorithm.easy;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 如，输入: s = "egg", t = "add"
 * 输出: true
 *
 * @author: chen
 * @date: 2018/12/24
 */
public class Solution_205_IsIsomorphic {
    /*public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>(s.length());
        Character temp;
        for (int i = 0, len = s.length(); i < len; i++) {
            temp = map.get(char_s[i]);
            //不包含s串的字符，但所对应的t串已经被映射过了
            if (temp == null && map.containsValue(char_t[i])) {
                return false;
            //包含，但所对应的t串不同，这就是不能替换的两种情况
            }else if (temp!=null&&temp!=char_t[i]){
                return false;
            }
            map.put(char_s[i], char_t[i]);
        }
        return true;
    }*/

    //更优解
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chas1 = s.toCharArray();
        char[] chas2 = t.toCharArray();
        int[] map = new int[512];
        for (int i = 0; i < chas1.length; i++) {
            if (map[chas1[i]] != map[chas2[i] + 256]) {
                return false;
            }
            map[chas1[i]] = map[chas2[i] + 256] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_205_IsIsomorphic().isIsomorphic("ab", "aa"));
    }
}
