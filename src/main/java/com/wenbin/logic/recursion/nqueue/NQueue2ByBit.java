package com.wenbin.logic.recursion.nqueue;

/**
 * N皇后2 https://leetcode-cn.com/problems/n-queens-ii
 */
public class NQueue2ByBit {

  int result = 0;

  public int totalNQueens(int n) {
    if (n <= 0) {
      return result;
    }

    dfsQueue(n, 0, 0, 0, 0);
    return result;
  }

  private void dfsQueue(int n, int level, int cols, int leftSlash, int rightSlash) {
    if (level >= n) {
      result++;
      return;
    }

    int availablePositions = ((1 << n) - 1) & (~(cols | leftSlash | rightSlash));
    while (availablePositions != 0) {
      int position = availablePositions & (-availablePositions);
      availablePositions = availablePositions & (availablePositions - 1);
      dfsQueue(n, level + 1, cols | position, (leftSlash | position) << 1,
          (rightSlash | position) >> 1);
    }
  }
}
