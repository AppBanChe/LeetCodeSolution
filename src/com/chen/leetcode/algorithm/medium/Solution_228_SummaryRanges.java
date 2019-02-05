package com.chen.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 *
 * @author: chen
 * @date: 2019/1/8
 **/
public class Solution_228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) ++i;
            res.add(nums[i] == nums[temp] ? nums[i] + ""
                    : nums[temp] + "->" + nums[i]);
        }
        return res;
    }
}
