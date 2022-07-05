package com.wenbin.logic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间 https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][2];
    }
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    List<int[]> merged = new ArrayList<>();
    for (int i = 0; i < intervals.length; ++i) {
      int left = intervals[i][0], right = intervals[i][1];
      if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
        merged.add(new int[]{left, right});
      } else {
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }


}
