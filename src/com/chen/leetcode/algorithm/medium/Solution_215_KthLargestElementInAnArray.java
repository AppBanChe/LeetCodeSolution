package com.chen.leetcode.algorithm.medium;

import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 如，输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * @author: chen
 * @date: 2019/1/12
 **/
public class Solution_215_KthLargestElementInAnArray {
    //Quick Select
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) return nums[pos];
            else if (pos < k - 1) left = pos + 1;
            else right = pos - 1;
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        //随机取得基准元素
        swap(nums, right, left + new Random().nextInt(right - left));
        int pivot = nums[right];
        int cur = left--;
        while (cur < right) {
            if (nums[cur] > pivot) swap(nums, cur++, ++left);
            else cur++;
        }
        swap(nums, ++left, right);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
