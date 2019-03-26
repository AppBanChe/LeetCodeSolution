package com.chen.leetcode.algorithm.medium;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * @author: chen
 * @date: 2019/3/26
 **/
public class Solution_287_FindTheDuplicateNumber {
    /**
     * 二分查找
     */
    /*public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2, count = 0;
            //mid是数组的[left,right]范围的中点，所以统计小于等于中点的元素数量，来判断重复元素在哪个区间
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }*/

    /**
     * 快慢指针
     */
    /*public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);
        fast = 0;
        while (nums[slow] != nums[fast]) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[slow];
    }*/

    /**
     * 位操作，遍历每一位，然后对于32位中的每一个位，我们都遍历一遍从0到n-1并将每一个数都跟bit相‘与’，若大于0，则计数器cnt1自增1。
     * 同时0到n-1也可以当作nums数组的下标，从而让nums数组中的每个数字也跟bit相‘与’，若大于0，则计数器cnt2自增1。
     * 最后比较若cnt2>cnt1，则将bit加入结果res中。因为对于每一位，0到n-1中所有数字中该位上的1的个数应该是固定的，
     * 如果nums数组中所有数字中该位上1的个数多了，说明重复数字在该位上一定是1，这样我们把重复数字的所有为1的为都累加起来，就可以还原出了这个重复数字
     */
    public int findDuplicate(int[] nums) {
        int res = 0, len = nums.length;
        for (int i = 0; i < 32; ++i) {
            int bit = (1 << i), count1 = 0, count2 = 0;
            for (int j = 0; j < len; ++j) {
                if ((j & bit) > 0) count1++;
                if ((nums[j] & bit) > 0) count2++;
            }
            if (count2 > count1) res += bit;
        }
        return res;
    }
}
