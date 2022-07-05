package com.wenbin.logic.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 二进制矩阵中的最短路径 https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {

  public static void main(String[] args) {
    ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
    shortestPathInBinaryMatrix
        .shortestPathBinaryMatrix(new int[][]{{0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0}});
  }

  int[][] dir = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    int rowCount = grid.length;
    int colCount = grid[0].length;
    if (grid[0][0] == 1 || grid[rowCount - 1][colCount - 1] == 1) {
      return -1;
    }

    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
    pq.offer(new int[]{1, 0, 0});
    Set<Integer> set = new HashSet<>();
    while (!pq.isEmpty()) {
      int[] value = pq.poll();
      int cost = value[0];
      int row = value[1];
      int col = value[2];
      if (row == rowCount - 1 && col == colCount - 1) {
        return cost;
      }

      for (int i = 0; i < dir.length; i++) {
        int newRow = row + dir[i][0];
        int newCol = col + dir[i][1];
        if (newRow < 0 || newRow >= rowCount || newCol < 0 || newCol >= colCount || set
            .contains(newRow * colCount + newCol) || grid[newRow][newCol] == 1) {
          continue;
        }

        set.add(newRow * colCount + newCol);
        pq.offer(new int[]{1 + cost, newRow, newCol});
      }
    }

    return -1;
  }
}
