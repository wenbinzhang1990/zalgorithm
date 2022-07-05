package com.wenbin.logic.search.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II https://leetcode-cn.com/problems/word-search-ii/
 */
public class WordSearch2ByTrie {

  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    MyTrie myTrie = new MyTrie();
    myTrie.insertWords(words);
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(i, j, board, myTrie, result, visited);
      }
    }

    return new ArrayList<>(result);
  }

  int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private void dfs(int row, int col, char[][] board, MyTrie myTrie, Set<String> result,
      boolean[][] visited) {
    if (myTrie.next[board[row][col] - 'a'] == null) {
      return;
    }

    myTrie = myTrie.next[board[row][col] - 'a'];
    if (myTrie.isEnd) {
      result.add(myTrie.str);
    }

    visited[row][col] = true;
    for (int i = 0; i < 4; i++) {
      int newRow = row + dir[i][0];
      int newCol = col + dir[i][1];
      if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length
          || visited[newRow][newCol]) {
        continue;
      }

      dfs(newRow, newCol, board, myTrie, result, visited);
    }

    visited[row][col] = false;
  }

  class MyTrie {

    public MyTrie[] next = new MyTrie[26];
    boolean isEnd = false;
    String str = "";

    public void insertWords(String[] words) {
      for (String word : words) {
        insertWord(word);
      }
    }

    public void insertWord(String word) {
      MyTrie trie = this;
      for (int i = 0; i < word.length(); i++) {
        if (trie.next[word.charAt(i) - 'a'] == null) {
          trie.next[word.charAt(i) - 'a'] = new MyTrie();
        }

        trie = trie.next[word.charAt(i) - 'a'];
      }

      trie.isEnd = true;
      trie.str = word;
    }
  }
}
