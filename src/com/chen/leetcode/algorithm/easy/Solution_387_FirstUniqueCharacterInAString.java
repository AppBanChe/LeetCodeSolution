package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author: chen
 * @date: 2019/3/6
 **/
public class Solution_387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1 ? index : Math.min(res, index);
            }
        }
        return res;
    }
}
