package com.chen.leetcode.algorithm.medium;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 如，输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @author: chen
 * @date: 2019/1/21
 **/
public class Solution_056_MergeIntervals {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    /*public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();
        if (intervals == null || intervals.isEmpty()) return res;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        res.offer(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = res.peekLast();
            Interval cur = intervals.get(i);
            if (last.end >= cur.start && last.end <= cur.end) last.end = cur.end;
            else if (last.end < cur.start) res.offer(cur);
        }
        return res;
    }*/

    //更优解
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) return res;
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];
        for (int i = 0; i < size; i++) {
            start[i] = intervals.get( i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j = 0; i < size; i++) {
            if (i == size - 1 || start[i + 1] > end[i]) {
                res.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
