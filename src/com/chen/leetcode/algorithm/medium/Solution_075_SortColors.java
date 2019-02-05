package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author: chen
 * @date: 2019/1/12
 **/
public class Solution_075_SortColors {

    /**
     * 荷兰国旗问题，快速排序三向切分
     */
    public void sortColors(int[] nums) {
        int left = -1, right = nums.length, cur = 0;
        while (cur < right) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++left);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur++, --right);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
