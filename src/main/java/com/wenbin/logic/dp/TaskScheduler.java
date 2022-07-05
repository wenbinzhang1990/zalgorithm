package com.wenbin.logic.dp;

import java.util.Arrays;

/**
 * 任务调度器 https://leetcode-cn.com/problems/task-scheduler/
 */
public class TaskScheduler {

  public int leastInterval(char[] tasks, int n) {
    int[] counts = new int[26];

    for (char c : tasks) {
      counts[c - 'A']++;
    }

    Arrays.sort(counts);
    int maxCount = 25;
    while (maxCount >= 0 && counts[maxCount] == counts[25]) {
      maxCount--;
    }

    return Math.max((n + 1) * (counts[25] - 1) + 25 - maxCount, tasks.length);
  }
}
