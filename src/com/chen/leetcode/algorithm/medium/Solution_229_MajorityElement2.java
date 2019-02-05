package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 如，输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * @author: chen
 * @date: 2018/12/26
 **/
public class Solution_229_MajorityElement2 {
    //使用多数投票法
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0;
        int aCount = 0, bCount = 0;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (a == num) {
                aCount++;
            } else if (b == num) {
                bCount++;
            } else if (aCount == 0) {
                a = num;
                aCount = 1;
            } else if (bCount == 0) {
                b = num;
                bCount = 1;
            } else {
                aCount--;
                bCount--;
            }
        }
        //再遍历一次确定是否为所求众数
        aCount = bCount = 0;
        for (int num : nums) {
            if (a == num) aCount++;
            else if (b == num) bCount++;
        }
        if (aCount > (nums.length / 3)) res.add(a);
        if (bCount > (nums.length / 3)) res.add(b);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_229_MajorityElement2().majorityElement(new int[]{
                1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
