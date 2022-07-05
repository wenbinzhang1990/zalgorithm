package com.wenbin.logic.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

  // 堆实现
  public int[] topKFrequentByHeap(int[] nums, int k) {
    if (k <= 0 || nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(map.size(),
        (v1, v2) -> v2.getValue() - v1.getValue());
    priorityQueue.addAll(map.entrySet());
    int size = priorityQueue.size();
    for (int i = 0; i < size && i < k; i++) {
      result[i] = priorityQueue.poll().getKey();
    }

    return result;
  }

  // 数组实现
  public int[] topKFrequentByArray(int[] nums, int k) {
    if (k <= 0 || nums == null || nums.length == 0) {
      return new int[0];
    }

    List<Integer>[] table = new List[nums.length + 1];
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (table[entry.getValue()] == null) {
        table[entry.getValue()] = new ArrayList();
      }

      table[entry.getValue()].add(entry.getKey());
    }

    int count = 0;
    for (int i = table.length - 1; i >= 0; i--) {
      if (table[i] == null) {
        continue;
      }

      for (Integer value : table[i]) {
        if (count >= k) {
          break;
        }

        result[count++] = value;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
    topKFrequentElements.topKFrequentByArray(new int[]{1}, 1);
  }
}
