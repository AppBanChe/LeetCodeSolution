package com.chen.leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_349_IntersectionOfTwoArrays {
    /**
     * HashSet
     */
    /*public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                res[index++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOf(res, index);
    }*/

    /**
     * 桶排序的思想
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int num : nums1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        boolean[] bucket = new boolean[max - min + 1];
        for (int num : nums1) {
            bucket[num - min] = true;
        }

        int index = 0;
        for (int num : nums2) {
            if (num < min || num > max) continue;
            if (bucket[num - min]) {
                nums2[index++] = num;
                bucket[num - min] = false;
            }
        }
        return Arrays.copyOf(nums2, index);
    }
}
