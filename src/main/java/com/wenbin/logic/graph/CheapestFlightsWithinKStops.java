package com.wenbin.logic.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * K 站中转内最便宜的航班 https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

  // Dijkstra
  public int findCheapestPriceByDijkstra(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
    for (int[] flight : flights) {
      if (!prices.containsKey(flight[0])) {
        prices.put(flight[0], new HashMap<>());
      }

      prices.get(flight[0]).put(flight[1], flight[2]);
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.add(new int[]{0, src, k});
    while (!pq.isEmpty()) {
      int[] value = pq.poll();
      int cost = value[0];
      int srcCity = value[1];
      int stop = value[2];
      if (srcCity == dst) {
        return cost;
      }

      if (stop >= 0) {
        Map<Integer, Integer> adj = prices.getOrDefault(srcCity, new HashMap<>());
        for (int a : adj.keySet()) {
          pq.add(new int[]{cost + adj.get(a), a, stop - 1});
        }
      }
    }

    return -1;
  }
}
