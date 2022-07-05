package com.wenbin.logic.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 滑动谜题 https://leetcode-cn.com/problems/sliding-puzzle/
 */
public class SlidingPuzzle {

  int[][] exchangeArray = new int[][]{
      {1, 3},
      {0, 2, 4},
      {1, 5},
      {0, 4},
      {1, 3, 5},
      {2, 4}
  };

  public int slidingPuzzle(int[][] board) {

    String start = initStartStr(board);
    String target = "123450";
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    Set<String> visited = new HashSet<>();
    visited.add(start);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String s = queue.poll();
        if (target.equalsIgnoreCase(s)) {
          return step;
        }

        int zeroIndex = s.indexOf('0');
        for (int j : exchangeArray[zeroIndex]) {
          char[] chars = s.toCharArray();
          char temp = chars[j];
          chars[j] = chars[zeroIndex];
          chars[zeroIndex] = temp;
          String changedString = String.valueOf(chars);
          if (!visited.contains(changedString)) {
            queue.offer(changedString);
            visited.add(changedString);
          }
        }
      }

      step++;
    }

    return -1;
  }

  private String initStartStr(int[][] board) {
    char[] chars = new char[6];
    int index = 0;
    for (int[] row : board) {
      for (int ch : row) {
        chars[index++] = (char) (ch + '0');
      }
    }

    return String.valueOf(chars);
  }
}
