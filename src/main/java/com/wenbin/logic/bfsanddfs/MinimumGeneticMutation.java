package com.wenbin.logic.bfsanddfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 最小基因变化 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

  int minStep = Integer.MAX_VALUE;

  public static void main(String[] args) {
    MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
    minimumGeneticMutation
        .minMutationByBfs("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
  }

  /**
   * Dfs
   */
  public int minMutationByDfs(String start, String end, String[] bank) {
    if (start.length() == 0 || end.length() == 0 || bank == null || bank.length == 0) {
      return -1;
    }

    Set<String> set = new HashSet<>();
    Set<String> visited = new HashSet<>();
    for (String b : bank) {
      set.add(b);
    }
    char[] changeChar = new char[]{'A', 'C', 'G', 'T'};
    dfsMin(start, end, 0, set, changeChar, visited);
    return minStep;
  }

  private void dfsMin(String start, String end, int step, Set<String> set,
      char[] changeChar, Set<String> visited) {
    if (start.equalsIgnoreCase(end)) {
      minStep = Math.min(step, minStep);
      return;
    }

    char[] chars = start.toCharArray();
    for (int i = 0; i < start.length(); i++) {
      char original = chars[i];
      for (char j = 0; j < changeChar.length; j++) {
        if (original == changeChar[j]) {
          continue;
        }

        chars[i] = changeChar[j];
        String changeString = String.valueOf(chars);
        if (set.contains(changeString) && !visited.contains(changeString)) {
          visited.add(changeString);
          dfsMin(changeString, end, step + 1, set, changeChar, visited);
          visited.remove(changeString);
        }
      }

      chars[i] = original;
    }
  }

  /**
   * Bfs
   */
  public int minMutationByBfs(String start, String end, String[] bank) {
    if (start.length() == 0 || end.length() == 0 || bank == null || bank.length == 0) {
      return -1;
    }

    Queue<String> q = new LinkedList<>();
    int minStep = 0;
    Set<String> set = new HashSet<>();
    q.offer(start);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        start = q.poll();
        if (start.equalsIgnoreCase(end)) {
          return minStep;
        }

        for (int j = 0; j < bank.length; j++) {
          int dif = 0;
          for (int k = 0; k < start.length(); k++) {
            if (start.charAt(k) != bank[j].charAt(k)) {
              dif++;
            }
          }

          if (dif == 1 && !set.contains(bank[j])) {
            q.offer(bank[j]);
            set.add(bank[j]);
          }
        }
      }

      minStep++;
    }

    return -1;
  }


  char[] allowChanges = new char[]{'A', 'C', 'G', 'T'};

  public int minMutation2(String start, String end, String[] bank) {
    if (start.length() != end.length()) {
      return 0;
    }

    Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
    Queue<String> beginQueue = new LinkedList<>();
    Set<String> beginSet = new HashSet<>();
    beginQueue.offer(start);
    beginSet.add(start);
    Queue<String> endQueue = new LinkedList<>();
    Set<String> endSet = new HashSet<>();
    endQueue.offer(end);
    endSet.add(end);
    int step = 0;
    while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
      if (beginQueue.size() > endQueue.size()) {
        Queue<String> tempQ = beginQueue;
        Set<String> tempS = beginSet;
        beginQueue = endQueue;
        beginSet = endSet;
        endQueue = tempQ;
        endSet = tempS;
      }

      int size = beginQueue.size();
      for (int i = 0; i < size; i++) {
        String s = beginQueue.poll();
        if (endSet.contains(s)) {
          return step;
        }

        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char original = chars[j];
          for (int k = 0; k < allowChanges.length; k++) {
            if (allowChanges[k] == original) {
              continue;
            }

            chars[j] = allowChanges[k];
            String changedString = String.valueOf(chars);
            if (wordSet.contains(changedString) && !beginSet.contains(changedString)) {
              beginSet.add(changedString);
              beginQueue.offer(changedString);
            }
          }
          chars[j] = original;
        }
      }

      step++;
    }

    return -1;
  }
}
