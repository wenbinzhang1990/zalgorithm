package com.wenbin.logic.recursion.nqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class NQueueByBit {

  int[] queue;
  List<List<String>> result = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    queue = new int[n];
    if (n <= 0) {
      return result;
    }

    dfsQueue(n, 0, 0, 0, 0);
    return result;
  }

  private void dfsQueue(int n, int level, int cols, int leftSlash, int rightSlash) {
    if (n == level) {
      finish();
      return;
    }

    int availablePositions = ((1 << n) - 1) & (~(cols | leftSlash | rightSlash));
    while (availablePositions != 0) {
      int position = availablePositions & (-availablePositions);
      availablePositions = availablePositions & (availablePositions - 1);
      queue[level] = Integer.bitCount(position - 1);
      dfsQueue(n, level + 1, cols | position, (leftSlash | position) << 1,
          (rightSlash | position) >> 1);
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
