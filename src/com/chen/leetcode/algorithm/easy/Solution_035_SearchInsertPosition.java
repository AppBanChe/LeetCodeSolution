package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_035_SearchInsertPosition {
    /*public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }*/

    //易于理解
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (index == -1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
            } else if (nums[mid] < target) {
                //此时mid可能已经到最后或target处在nums[mid]和nums[mid+1]之间
                if (mid == nums.length - 1 || target < nums[mid + 1]) {
                    index = mid;
                }
                left = mid + 1;
            } else {
                //此时mid可能已经到起始或target处在nums[mid-1]和nums[mid]之间
                if (mid == 0 || target > nums[mid - 1]) {
                    index = mid;
                }
                right = mid - 1;
            }
        }
        return index;
    }
}
