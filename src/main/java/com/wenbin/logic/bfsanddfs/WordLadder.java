package com.wenbin.logic.bfsanddfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 单词接龙 https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();
    wordLadder.ladderLengthByBfs2("ymain", "oecij", new ArrayList<String>(Arrays
        .asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj",
            "yzcnj", "ymain")));
  }

  int minStep = Integer.MAX_VALUE;

  /**
   * Dfs  (会超时)
   */
  public int ladderLengthByDfs(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equalsIgnoreCase(endWord)) {
      return 0;
    }

    if (wordList == null || wordList.isEmpty()) {
      return 0;
    }

    Set<String> set = new HashSet<>();
    dfs(beginWord, endWord, 1, wordList, set);
    return minStep == Integer.MAX_VALUE ? 0 : minStep;
  }

  /**
   * Bfs
   */
  public int ladderLengthByBfs(String beginWord, String endWord, List<String> wordList) {
    if (wordList == null || wordList.isEmpty()) {
      return 0;
    }

    if (beginWord.equalsIgnoreCase(endWord)) {
      return 1;
    }

    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int step = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String s = q.poll();
        if (s.equalsIgnoreCase(endWord)) {
          return step;
        }

        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char origin = chars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (origin == c) {
              continue;
            }

            chars[j] = c;
            String changedString = String.valueOf(chars);
            if (wordSet.contains(changedString) && !visited.contains(changedString)) {
              visited.add(changedString);
              q.offer(changedString);
            }
          }

          chars[j] = origin;
        }
      }

      step++;
    }

    return 0;
  }


  /**
   * Bfs2
   */
  public int ladderLengthByBfs2(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equalsIgnoreCase(endWord)) {
      return 1;
    }

    if (wordList == null || wordList.isEmpty()) {
      return 0;
    }

    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }

    int step = 1;
    Set<String> beginVisited = new HashSet<>();
    beginVisited.add(beginWord);
    Set<String> endVisited = new HashSet<>();
    endVisited.add(endWord);

    Queue<String> beginQueue = new LinkedList<>();
    Queue<String> endQueue = new LinkedList<>();
    beginQueue.offer(beginWord);
    endQueue.offer(endWord);
    while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
      Queue<String> tempQueue = null;
      Set<String> tempVisited = null;

      if (beginQueue.size() > endQueue.size()) {
        tempQueue = beginQueue;
        beginQueue = endQueue;
        tempVisited = beginVisited;
        beginVisited = endVisited;
        endQueue = tempQueue;
        endVisited = tempVisited;
      }

      int size = beginQueue.size();
      for (int i = 0; i < size; i++) {
        String changeBeginWord = beginQueue.poll();
        char[] changeBeginChars = changeBeginWord.toCharArray();
        for (int j = 0; j < changeBeginChars.length; j++) {
          char origin = changeBeginChars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (origin == c) {
              continue;
            }

            changeBeginChars[j] = c;
            String changedString = String.valueOf(changeBeginChars);
            if (endVisited.contains(changeBeginWord)) {
              return step;
            }

            if (wordSet.contains(changedString) && !beginVisited.contains(changedString)) {
              beginVisited.add(changedString);
              beginQueue.offer(changedString);
            }
          }

          changeBeginChars[j] = origin;
        }
      }

      step++;
    }

    return 0;
  }

  private void dfs(String beginWord, String endWord, int step, List<String> wordList,
      Set<String> set) {
    if (beginWord.equalsIgnoreCase(endWord)) {
      minStep = Integer.min(step, minStep);
      return;
    }

    for (int i = 0; i < wordList.size(); i++) {
      int dif = 0;
      for (int j = 0; j < beginWord.length(); j++) {
        if (beginWord.charAt(j) != wordList.get(i).charAt(j)) {
          dif++;
        }
      }

      if (dif == 1 && !set.contains(wordList.get(i))) {
        set.add(wordList.get(i));
        dfs(wordList.get(i), endWord, step + 1, wordList, set);
        set.remove(wordList.get(i));
      }
    }

  }
}
