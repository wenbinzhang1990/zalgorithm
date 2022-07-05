package com.wenbin.logic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 课程表2 https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class CourseSchedule2 {

  int count = 0;

  // dfs
  public int[] findOrderByDfs(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites == null) {
      return new int[0];
    }

    int[] result = new int[numCourses];
    int[] visited = new int[numCourses];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      if (!map.containsKey(prerequisite[0])) {
        map.put(prerequisite[0], new ArrayList<>());
      }

      map.get(prerequisite[0]).add(prerequisite[1]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (!dfs(visited, result, map, i)) {
        return new int[0];
      }
    }

    return result;
  }

  private boolean dfs(int[] visited, int[] result, Map<Integer, List<Integer>> map, int i) {
    if (visited[i] == 2) {
      return true;
    }

    if (visited[i] == 1) {
      return false;
    }

    visited[i] = 1;
    List<Integer> list = map.get(i);
    if (list != null) {
      for (Integer j : list) {
        if (!dfs(visited, result, map, j)) {
          return false;
        }
      }
    }

      visited[i] = 2;
    result[count++] = i;
    return true;
  }

  // bfs
  public int[] findOrderByBfs(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites == null) {
      return new int[0];
    }

    int[] result = new int[numCourses];
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] inDegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      if (!map.containsKey(prerequisite[1])) {
        map.put(prerequisite[1], new ArrayList<>());
      }

      map.get(prerequisite[1]).add(prerequisite[0]);
      inDegree[prerequisite[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int pre = queue.poll();
      result[count++] = pre;
      List<Integer> list = map.get(pre);
      if (list != null) {
        for (Integer i : list) {
          if (--inDegree[i] == 0) {
            queue.add(i);
          }
        }
      }
    }

    return numCourses == count ? result : new int[0];
  }
}
