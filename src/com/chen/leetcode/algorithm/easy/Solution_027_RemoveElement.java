package com.chen.leetcode.algorithm.easy;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 如，给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * @author: chen
 * @date: 2018/12/5
 **/
public class Solution_027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int i, j;
        for (i = 0, j = -1; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            /*
            这里可以不用交换
            int temp = nums[i];
            nums[i] = nums[++j];
            nums[j] = temp;*/
            //直接覆盖即可
            nums[++j] = nums[i];
        }
        return j + 1;
    }

    /*
    当要删除的元素很少时
    当我们遇到 nums[i] = val 时，我们可以将当前元素与最后一个元素进行交换，
    并释放最后一个元素。这实际上使数组的大小减少了 1。
     */
    /*
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }*/
}
