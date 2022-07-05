package com.wenbin.logic.bfsanddfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

  // DFS实现
  public int numIslandsByDfs(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowCount = grid.length;
    int colCount = grid[0].length;
    int result = 0;
    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        if (grid[row][col] == '1') {
          result++;
          dfs(grid, row, col, rowCount, colCount);
        }
      }
    }

    return result;
  }

  private void dfs(char[][] grid, int row, int col, int rowLimit, int colLimit) {
    if (row < 0 || row >= rowLimit || col < 0 || col >= colLimit || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';
    dfs(grid, row + 1, col, rowLimit, colLimit);
    dfs(grid, row - 1, col, rowLimit, colLimit);
    dfs(grid, row, col - 1, rowLimit, colLimit);
    dfs(grid, row, col + 1, rowLimit, colLimit);
  }

  // BFS实现
  public int numIslandsByBfs(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowCount = grid.length;
    int colCount = grid[0].length;
    int result = 0;
    Queue<int[]> queue = new LinkedList();
    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        if (grid[row][col] == '0') {
          continue;
        }

        result++;
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
          int[] value = queue.poll();
          int newRow = value[0];
          int newCol = value[1];
          if (newRow < 0 || newRow >= rowCount || newCol < 0 || newCol >= colCount
              || grid[newRow][newCol] == '0') {
            continue;
          }

          grid[newRow][newCol] = '0';
          queue.add(new int[]{newRow + 1, newCol});
          queue.add(new int[]{newRow - 1, newCol});
          queue.add(new int[]{newRow, newCol + 1});
          queue.add(new int[]{newRow, newCol - 1});
        }
      }
    }

    return result;
  }

  // 并查集实现
  public int numIslandsByUf(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowCount = grid.length;
    int colCount = grid[0].length;
    UnionFind unionFind = new UnionFind(grid);
    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        if (grid[row][col] == '0') {
          continue;
        }

        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
          unionFind.union(row * colCount + col, (row - 1) * colCount + col);
        }

        if (row + 1 < rowCount && grid[row + 1][col] == '1') {
          unionFind.union(row * colCount + col, (row + 1) * colCount + col);
        }

        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
          unionFind.union(row * colCount + col, row * colCount + col - 1);
        }

        if (col + 1 < colCount && grid[row][col + 1] == '1') {
          unionFind.union(row * colCount + col, (row) * colCount + col + 1);
        }

      }
    }

    return unionFind.count;
  }

  class UnionFind {

    private int[] parent;
    int count;

    public UnionFind(char[][] grid) {
      int rowCount = grid.length;
      int colCount = grid[0].length;
      parent = new int[rowCount * colCount];
      for (int row = 0; row < rowCount; row++) {
        for (int col = 0; col < colCount; col++) {
          if (grid[row][col] == '1') {
            parent[row * colCount + col] = row * colCount + col;
            count++;
          }
        }
      }
    }

    public int find(int position) {
      while (parent[position] != position) {
        position = parent[position];
      }

      return parent[position];
    }

    public void union(int srcPosition, int desPosition) {
      int rootSrc = find(srcPosition);
      int rootDes = find(desPosition);
      if (rootDes != rootSrc) {
        parent[rootSrc] = rootDes;
        count--;
      }
    }
  }
}

