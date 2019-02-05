package com.chen.leetcode.algorithm.easy;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 如，输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * @author: chen
 * @date: 2018/12/28
 **/
public class Solution_219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val != null && i - val <= k) {
                return true;
            } else
                map.put(nums[i], i);
        }
        return false;
    }
}
