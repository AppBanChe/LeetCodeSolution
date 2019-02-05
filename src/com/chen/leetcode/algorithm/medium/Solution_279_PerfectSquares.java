package com.chen.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 输入: n = 12，输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * @author: chen
 * @date: 2019/1/10
 **/
public class Solution_279_PerfectSquares {
    /**
     * 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
     */
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a <= n; ++a) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) return (a != 0 ? 1 : 0) + (b != 0 ? 1 : 0);
        }
        return 3;
    }

    /**
     * dp
     */
    /*public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = (int) Math.pow(i, 0.5); j > 0; j--) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }*/

    /**
     * bfs
     */
    /*public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 1, cur, next;
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                cur = queue.poll();
                for (int j = 1; ; j++) {
                    next = cur + j * j;
                    if (next > n) {
                        break;
                    } else if (next == n) {
                        return step;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return 0;
    }*/
}
