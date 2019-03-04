package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author: chen
 * @date: 2019/3/4
 **/
public class Solution_189_RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);

        //同样效果
        /*helper(nums, 0, nums.length - k - 1);
        helper(nums, nums.length - k, nums.length - 1);
        helper(nums, 0, nums.length - 1);*/
    }

    private void helper(int[] nums, int left, int right) {
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
