package com.chen.leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 如，输入: [1,2,3,1]
 * 输出: true
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_217_ContainsDuplicate {
    /*
    //Use HashMap
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], -1);
        }
        return false;
    }*/

    //Sort
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
