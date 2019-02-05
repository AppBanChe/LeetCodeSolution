package com.chen.leetcode.algorithm.easy;

import java.util.HashMap;

/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * 输入: pattern = "abba", str = "dog cat cat dog" 输出: true
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_290_WordPattern {
    /**
     * 两个 HashMap
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> cToS = new HashMap<>();
        HashMap<String, Character> sToC = new HashMap<>();
        String[] s = str.split(" ");
        if (s.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            String a = cToS.get(pattern.charAt(i));
            Character c = sToC.get(s[i]);
            if (a == null && c == null) {
                cToS.put(pattern.charAt(i), s[i]);
                sToC.put(s[i], pattern.charAt(i));
            } else if (a == null || c == null
                    || !a.equals(s[i]) || c != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用数组，执行速度较两个HashMap快些
     */
    /*public boolean wordPattern(String pattern, String str) {
        char[] pc = pattern.toCharArray();
        String[] words = str.split(" ");
        if (pc.length != words.length) {
            return false;
        }
        String[] mark = new String[123];
        for (int i = 0; i < pc.length; i++) {
            if (mark[pc[i]] == null) {
                mark[pc[i]] = words[i];
            } else if (!mark[pc[i]].equals(words[i])) {
                return false;
            }
        }
        for (int i = 97; i < 122; i++) {
            for (int j = i + 1; j < 123; j++) {
                if (mark[i] != null && mark[i].equals(mark[j])) {
                    return false;
                }
            }
        }
        return true;
    }*/
}
