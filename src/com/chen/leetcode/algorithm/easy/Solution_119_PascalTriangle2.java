package com.chen.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 如，输入: 3，输出: [1,3,3,1]
 * <p>
 * 在 http://www.cnblogs.com/grandyang/p/4031536.html 有详细解释
 *
 * @author: chen
 * @date: 2018/12/24
 **/
public class Solution_119_PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(++rowIndex);
        //init
        res.add(1);
        for (int i = 1; i < rowIndex; i++) {
            res.add(0);
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

   /*
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();

        long num = 1;
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }

        for (int i = 1; i < rowIndex; i++) {
            //二项式定理
            num *= rowIndex - i + 1;
            num /= i;
            result.add((int)num);
        }
        result.add(1);

        return result;
    }*/

    //test
    public static void main(String[] args) {
        System.out.println(new Solution_119_PascalTriangle2().getRow(3));
    }
}
