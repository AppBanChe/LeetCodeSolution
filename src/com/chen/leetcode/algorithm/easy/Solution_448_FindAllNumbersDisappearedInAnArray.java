package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 *
 * @author: chen
 * @date: 2019/1/3
 **/
public class Solution_448_FindAllNumbersDisappearedInAnArray {

    /**
     * 使用了额外空间
     */
    /*public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }*/

    /**
     * 将数字移动到正确的位置上去
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    /**
     * 是在nums[nums[i]-1]位置累加数组长度n，需要对n取余避免nums[i]-1越界
     */
    /*public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }*/
}
