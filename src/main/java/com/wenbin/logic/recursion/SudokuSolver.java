package com.wenbin.logic.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 解数独 https://leetcode-cn.com/problems/sudoku-solver
 */
public class SudokuSolver {


  Set<Integer>[] rowMap = new HashSet[9];
  Set<Integer>[] colMap = new HashSet[9];
  Set<Integer>[] boxMap = new HashSet[9];

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      rowMap[i] = new HashSet<>();
      colMap[i] = new HashSet<>();
      boxMap[i] = new HashSet<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int value = board[i][j] - '0';
          rowMap[i].add(value);
          colMap[j].add(value);
          boxMap[(i / 3) * 3 + j / 3].add(value);
        }
      }
    }

    dfs(board, 0);
  }

  private boolean dfs(char[][] board, int level) {
    if (level == 81) {
      return true;
    }

    int i = level / 9;
    int j = level % 9;
    if (board[i][j] != '.') {
      return dfs(board, level + 1);
    }

    for (char k = '1'; k <= '9'; k++) {
      int value = k - '0';
      if (rowMap[i].contains(value) || colMap[j].contains(value) || boxMap[(i / 3) * 3
          + j / 3].contains(value)) {
        continue;
      }

      rowMap[i].add(value);
      colMap[j].add(value);
      boxMap[(i / 3) * 3 + j / 3].add(value);
      board[i][j] = k;
      if (dfs(board, level + 1)) {
        return true;
      }

      board[i][j] = '.';
      rowMap[i].remove(value);
      colMap[j].remove(value);
      boxMap[(i / 3) * 3 + j / 3].remove(value);
    }

    return false;
  }
}

