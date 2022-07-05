package com.wenbin.logic.recursion.nqueue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * N皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    int[] queue;
    Set<Integer> colMap = new HashSet<>();
    Set<Integer> leftBias = new HashSet<>();
    Set<Integer> rightBias = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        queue = new int[n];
        if (n <= 0) {
            return result;
        }

        dfsQueuen(n, 0);
        return result;
    }



    private void dfsQueuen(int n, int level) {
        if (n == level) {
            finish();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (colMap.contains(i) || leftBias.contains(level - i) || rightBias.contains(level + i)) {
                continue;
            }

            colMap.add(i);
            leftBias.add(level - i);
            rightBias.add(level + i);
            queue[level] = i;
            dfsQueuen(n, level + 1);
            colMap.remove(i);
            leftBias.remove(level - i);
            rightBias.remove(level + i);
            queue[level] = 0;
        }
    }

    private void finish() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queue.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queue.length; j++) {
                sb.append(queue[i] == j ? "Q" : ".");
            }

            list.add(sb.toString());
        }

        result.add(list);
    }
}
