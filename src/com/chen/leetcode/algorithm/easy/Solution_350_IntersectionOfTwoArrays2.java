package com.chen.leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author: chen
 * @date: 2019/1/4
 **/
public class Solution_350_IntersectionOfTwoArrays2 {
    /*public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, len = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res[len++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(res, len);
    }*/

    /**
     * HashMap
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count != null) {
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 1) {
                map.put(num, count - 1);
                res[len++] = num;
            }
        }
        return Arrays.copyOf(res, len);
    }
}
