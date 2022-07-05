package com.wenbin.logic.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 网络延迟时间 https://leetcode-cn.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

  // Dijkstra
  public int networkDelayTime(int[][] times, int n, int k) {
    if (times == null || times.length == 0 || times[0] == null || times[0].length == 0 || k < 0
        || n <= 0) {
      return -1;
    }

    Map<Integer, Map<Integer, Integer>> distance = new HashMap<>();
    for (int[] time : times) {
      if (!distance.containsKey(time[0])) {
        distance.put(time[0], new HashMap<Integer, Integer>());
      }

      distance.get(time[0]).put(time[1], time[2]);
    }

    Map<Integer, Integer> visited = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
    pq.add(new int[]{0, k});
    while (!pq.isEmpty()) {
      int[] value = pq.poll();
      int cost = value[0];
      int descNode = value[1];
      if (visited.containsKey(descNode)) {
        continue;
      }

      visited.put(descNode, cost);
      if (visited.keySet().size() == n) {
        return cost;
      }

      Map<Integer, Integer> adj = distance.getOrDefault(descNode, new HashMap<>());
      for (int a : adj.keySet()) {
        pq.add(new int[]{cost + adj.get(a), a});
      }
    }

    return -1;
  }

}
