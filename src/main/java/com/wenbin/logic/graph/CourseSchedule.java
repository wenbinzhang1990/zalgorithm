package com.wenbin.logic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 课程表 https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {

  // dfs
  public boolean canFinishByDfs(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0
        || prerequisites[0].length == 0) {
      return true;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      if (!map.containsKey(prerequisite[0])) {
        map.put(prerequisite[0], new ArrayList<Integer>());
      }

      map.get(prerequisite[0]).add(prerequisite[1]);
    }

    int[] visited = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      if (!dfs(prerequisite[0], map, visited)) {
        return false;
      }
    }

    return true;
  }


  // bfs
  public boolean canFinishByBfs(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0
        || prerequisites[0].length == 0) {
      return true;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] inDegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      if (!map.containsKey(prerequisite[1])) {
        map.put(prerequisite[1], new ArrayList<Integer>());
      }

      map.get(prerequisite[1]).add(prerequisite[0]);
      inDegree[prerequisite[0]]++;
    }

    int count = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int pre = queue.poll();
      count++;
      List<Integer> nodes = map.get(pre);
      if (nodes != null) {
        for (Integer node : nodes) {
          if (--inDegree[node] == 0) {
            queue.add(node);
          }
        }
      }
    }

    return count == numCourses;
  }

  private boolean dfs(int course, Map<Integer, List<Integer>> map, int[] visited) {
    if (visited[course] == 1) {
      return false;
    }
    if (visited[course] == 2) {
      return true;
    }

    visited[course] = 1;
    List<Integer> depCourses = map.get(course);
    if (depCourses != null) {
      for (Integer depCourse : depCourses) {
        if (!dfs(depCourse, map, visited)) {
          return false;
        }
      }
    }

    visited[course] = 2;
    return true;
  }

  public static void main(String[] args) {
    CourseSchedule courseSchedule = new CourseSchedule();
    // courseSchedule.canFinishByDfs(2, new int[][]{{1, 0}, {0, 1}});
    courseSchedule.canFinishByBfs(2, new int[][]{{1, 0}});
  }
}
