package com.wenbin.logic.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

  public static void main(String[] args) {
   
    ValidSudoku vl=new ValidSudoku();
    vl.isValidSudoku(new char[][] {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}});

  }
  public boolean isValidSudoku(char[][] board) {
    Set<Integer>[] rowMap = new HashSet[9];
    Set<Integer>[] colMap = new HashSet[9];
    Set<Integer>[] boxMap = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      rowMap[i] = new HashSet<>();
      colMap[i] = new HashSet<>();
      boxMap[i] = new HashSet<>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int value = board[i][j] - '0';
          if (rowMap[i].contains(value) || colMap[j].contains(value) || boxMap[(i / 3) * 3 + j / 3]
              .contains(value)) {
            return false;
          }

          rowMap[i].add(value);
          colMap[j].add(value);
          boxMap[(i / 3) * 3 + j / 3].add(value);
        }
      }
    }

    return true;
  }
}
