package com.wenbin.logic.recursion.nqueue;

import java.util.HashSet;
import java.util.Set;

/**
 * N皇后2 https://leetcode-cn.com/problems/n-queens-ii
 */
public class NQueues2 {

  Set<Integer> colMap = new HashSet<>();
  Set<Integer> leftBias = new HashSet<>();
  Set<Integer> rightBias = new HashSet<>();
  int result = 0;

  public int totalNQueens(int n) {
    if (n <= 0) {
      return result;
    }

    dfsQueuen(n, 0);
    return result;
  }

  private void dfsQueuen(int n, int level) {
    if (level >= n) {
      result++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (colMap.contains(i) || leftBias.contains(level - i) || rightBias.contains(level + i)) {
        continue;
      }

      colMap.add(i);
      leftBias.add(level - i);
      rightBias.add(level + i);
      dfsQueuen(n, level + 1);
      colMap.remove(i);
      leftBias.remove(level - i);
      rightBias.remove(level + i);
    }
  }
}
