package com.chen.leetcode.algorithm.medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @author: chen
 * @date: 2019/2/8
 **/
public class Solution_011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int area = (right - left) * min;
            res = Math.max(res, area);
            //因为面积取决于左右两根线的距离和最小高度，所以解不可能出现比当前最小高度还小的线中
            while (left < right && height[left] <= min) left++;
            while (left < right && height[right] <= min) right--;
        }
        return res;
    }
}
