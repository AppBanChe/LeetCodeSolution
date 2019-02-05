package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 如，输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int leftBound = getLeftBound(nums, target);
        if (leftBound == -1) {
            return res;
        }
        res[0] = leftBound;
        res[1] = getRightBound(nums, target);
        return res;
    }

    private int getLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //若此时mid为左边界，则返回
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                //继续往左搜索
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                //继续往右搜索
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

