package com.wenbin.logic.bfsanddfs;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 扫雷游戏 https://leetcode-cn.com/problems/minesweeper/
 */
public class MineSweeper {

  int[] dx = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
  int[] dy = new int[]{1, 0, -1, 0, 1, -1, -1, 1};

  public static void main(String[] args) {
    MineSweeper mineSweeper = new MineSweeper();
    mineSweeper.updateBoardByDfs(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
  }

  public char[][] updateBoardByDfs(char[][] board, int[] click) {
    if (board == null || board.length == 0 || click == null || click.length == 0) {
      return board;
    }

    dfs(board, click[0], click[1], board.length, board[0].length);
    return board;
  }

  public char[][] updateBoardByBfs(char[][] board, int[] click) {
    if (board == null || board.length == 0 || click == null || click.length == 0) {
      return board;
    }

    Queue<Integer> q = new LinkedList<>();
    int rowCount = board.length;
    int colCount = board[0].length;
    q.offer(click[0] * colCount + click[1]);
    while (!q.isEmpty()) {
      int value = q.poll();
      int row = value / colCount;
      int col = value % colCount;
      if (board[row][col] == 'M') {
        board[row][col] = 'X';
        continue;
      }

      if (board[row][col] == 'E') {
        List<Integer> mineState = getMineCount(board, row, col, rowCount, colCount);
        if (mineState.get(0) != 0) {
          board[row][col] = (char) (mineState.get(0) + '0');
          continue;
        } else {
          board[row][col] = 'B';
          for (int i = 1; i < mineState.size(); i++) {
            int newRow = mineState.get(i) / colCount;
            int newCol = mineState.get(i) % colCount;
            q.offer(newRow * colCount + newCol);
          }
        }
      }
    }
    return board;
  }

  private void dfs(char[][] board, int row, int col, int rowCount, int colCount) {
    if (board[row][col] == 'M') {
      board[row][col] = 'X';
      return;
    }

    if (board[row][col] == 'E') {
      int mineCount = 0;
      for (int i = 0; i < 8; i++) {
        int x = row + dx[i];
        int y = col + dy[i];
        if (x < 0 || y < 0 || x >= rowCount || y >= colCount) {
          continue;
        }

        if (board[x][y] == 'M') {
          mineCount++;
        }
      }

      if (mineCount != 0) {
        board[row][col] = (char) (mineCount + '0');
        return;
      } else {
        board[row][col] = 'B';
        for (int i = 0; i < 8; i++) {
          int x = row + dx[i];
          int y = col + dy[i];
          if (x < 0 || y < 0 || x >= rowCount || y >= colCount || board[x][y] != 'E') {
            continue;
          }

          dfs(board, x, y, rowCount, colCount);
        }
      }
    }
  }

  private List<Integer> getMineCount(char[][] board, int row, int col, int rowCount,
      int colCount) {
    int mineCount = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      int x = row + dx[i];
      int y = col + dy[i];
      if (x < 0 || y < 0 || x >= rowCount || y >= colCount || board[row][col] != 'E') {
        continue;
      }

      if (board[x][y] == 'M') {
        mineCount++;
      }

      list.add(x * colCount + y);
    }

    List<Integer> result = new ArrayList<>();
    result.add(mineCount);
    result.addAll(list);
    return result;
  }
}
