package com.wenbin.logic.bfsanddfs;

/**
 * 被围绕的区域 https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

  public static void main(String[] args) {
    SurroundedRegions surroundedRegions = new SurroundedRegions();
    surroundedRegions.solveByDfs(
        new char[][]{{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X'}});
  }


  public void solveByDfs(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }

    int rowCount = board.length;
    int colCount = board[0].length;
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        if ((i == 0 || j == 0 || i == rowCount - 1 || j == colCount - 1) && board[i][j] == 'O') {
          dfs(i, j, board);
        }
      }
    }

    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  private void dfs(int row, int col, char[][] board) {
    board[row][col] = '#';
    for (int i = 0; i < dir.length; i++) {
      int newRow = row + dir[i][0];
      int newCol = col + dir[i][1];
      if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length
          || board[newRow][newCol] != 'O') {
        continue;
      }

      dfs(newRow, newCol, board);
    }
  }
}
