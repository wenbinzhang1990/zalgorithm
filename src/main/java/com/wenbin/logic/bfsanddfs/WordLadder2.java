package com.wenbin.logic.bfsanddfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 单词接龙 II https://leetcode-cn.com/problems/word-ladder-ii/description/
 */
public class WordLadder2 {

  Map<Integer, List<List<String>>> stepMap = new HashMap<>();
  List<String> list = new ArrayList<>();
  int minStep = Integer.MAX_VALUE;

  public static void main(String[] args) {
    WordLadder2 wordLadder2 = new WordLadder2();
    wordLadder2.findLaddersByDfs("hit", "cog",
        new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
  }


  public List<List<String>> findLaddersByBfs(String beginWord, String endWord,
      List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (beginWord.equalsIgnoreCase(endWord) || !wordList.contains(endWord)) {
      return result;
    }

    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    Queue<List<String>> queue = new LinkedList<>();
    queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
    boolean findResult = false;
    while (!queue.isEmpty() && !findResult) {
      int size = queue.size();
      Set<String> subVisited = new HashSet<>();
      for (int i = 0; i < size; i++) {
        List<String> word = queue.poll();
        String lastWord = word.get(word.size() - 1);
        if (lastWord.equalsIgnoreCase(endWord)) {
          result.add(new ArrayList<>(word));
          findResult = true;
          continue;
        }

        char[] chars = lastWord.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char origin = chars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            if (origin == c) {
              continue;
            }

            chars[j] = c;
            String changedString = String.valueOf(chars);
            if (wordSet.contains(changedString) && !visited.contains(changedString)) {
              List<String> cur = new ArrayList<>(word);
              subVisited.add(changedString);
              cur.add(changedString);
              queue.offer(cur);
            }
          }

          chars[j] = origin;
        }
      }

      visited.addAll(subVisited);
    }

    return result;
  }

  private boolean match(String endWord, Queue<List<String>> q, Set<String> wordSet,
      Set<String> visited, List<List<String>> result, Set<String> levelVisited) {
    List<String> list = q.poll();
    char[] chars = list.get(list.size() - 1).toCharArray();
    for (int j = 0; j < chars.length; j++) {
      char originalChar = chars[j];
      for (char c = 'a'; c <= 'z'; c++) {
        if (c == originalChar) {
          continue;
        }

        chars[j] = c;
        String changedString = String.valueOf(chars);
        if (wordSet.contains(changedString) && !visited.contains(changedString)) {
          List<String> curList = new ArrayList<>(list);
          curList.add(changedString);
          if (changedString.equalsIgnoreCase(endWord)) {
            result.add(curList);
            return true;
          }

          levelVisited.add(changedString);
          q.add(curList);
        }
      }

      chars[j] = originalChar;
    }

    return false;
  }


  /**
   * Dfs(会超时)
   */
  public List<List<String>> findLaddersByDfs(String beginWord, String endWord,
      List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    if (beginWord.equalsIgnoreCase(endWord)) {
      return result;
    }

    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    list.add(beginWord);
    visited.add(beginWord);
    dfs(beginWord, endWord, wordSet, visited, 1);
    return stepMap.get(minStep) == null ? result : stepMap.get(minStep);
  }

  private void dfs(String beginWord, String endWord, Set<String> wordSet, Set<String> visited,
      int step) {
    if (beginWord.equalsIgnoreCase(endWord)) {
      if (!stepMap.containsKey(step)) {
        stepMap.put(step, new ArrayList<>());
      }

      stepMap.get(step).add(new ArrayList<>(list));
      minStep = Math.min(minStep, step);
      return;
    }

    char[] beginChars = beginWord.toCharArray();
    for (int i = 0; i < beginWord.length(); i++) {
      char original = beginChars[i];
      for (char c = 'a'; c <= 'z'; c++) {
        if (original == c) {
          continue;
        }

        beginChars[i] = c;
        String changedString = String.valueOf(beginChars);
        if (wordSet.contains(changedString) && !visited.contains(changedString)) {
          list.add(changedString);
          visited.add(changedString);
          dfs(changedString, endWord, wordSet, visited, step + 1);
          list.remove(changedString);
          visited.remove(changedString);
        }

        beginChars[i] = original;
      }
    }
  }
}
