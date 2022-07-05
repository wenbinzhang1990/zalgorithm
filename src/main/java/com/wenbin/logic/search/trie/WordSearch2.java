package com.wenbin.logic.search.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 单词搜索 II https://leetcode-cn.com/problems/word-search-ii/
 */
public class WordSearch2 {
  public static void main(String[] args) {
    WordSearch2 wordSearch2 = new WordSearch2();
    wordSearch2.findWords(
        new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> list = new ArrayList<>();
    for (String word : words) {
      if (exist(board, word)) {
        list.add(word);
      }
    }

    return list;
  }

  int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  HashSet<Integer> used = new HashSet<>();

  public boolean exist(char[][] board, String word) {
    int rowCount = board.length;
    int colCount = board[0].length;
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        if (board[i][j] == word.charAt(0)) {
          used.add(i * colCount + j);
          if (dfs(0, i, j, board, word)) {
            used.remove(i * colCount + j);
            return true;
          }

          used.remove(i * colCount + j);
        }
      }
    }

    return false;
  }

  private boolean dfs(int index, int row, int col, char[][] board, String word) {
    if (word.charAt(index) != board[row][col]) {
      return false;
    }

    if (index == word.length() - 1) {
      return true;
    }

    for (int i = 0; i < 4; i++) {
      int newRow = row + dir[i][0];
      int newCol = col + dir[i][1];
      if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || used
          .contains(newRow * board[0].length + newCol)) {
        continue;
      }

      used.add(newRow * board[0].length + newCol);
      if (dfs(index + 1, newRow, newCol, board, word)) {
        used.remove(newRow * board[0].length + newCol);
        return true;
      }

      used.remove(newRow * board[0].length + newCol);
    }

    return false;
  }
}
