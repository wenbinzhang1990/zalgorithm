package com.wenbin.logic.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 青蛙过河  https://leetcode-cn.com/problems/frog-jump/
 */
public class FrogJump {

  public static void main(String[] args) {
    FrogJump frogJump = new FrogJump();
    frogJump.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
  }

  public boolean canCross(int[] stones) {
    if (stones == null || stones.length <= 1) {
      return true;
    }

    int len = stones.length;
    boolean[][] dp = new boolean[len][len + 1];
    dp[0][1] = true;
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        int dif = stones[i] - stones[j];
        if (dif > len || !dp[j][dif]) {
          continue;
        }

        dp[i][dif] = true;
        if (dif - 1 >= 0) {
          dp[i][dif - 1] = true;
        }

        if (dif + 1 <= len) {
          dp[i][dif + 1] = true;
        }

        if (i == len - 1) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean canCrossByMap(int[] stones) {
    if (stones == null || stones.length <= 1) {
      return true;
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < stones.length; i++) {
      map.put(stones[i], new HashSet<>());
    }

    map.get(0).add(0);
    for (int i = 0; i < stones.length; i++) {
      for (int k : map.get(stones[i])) {
        for (int step = k - 1; step <= k + 1; step++) {
          if (step > 0 && map.containsKey(stones[i] + step)) {
            map.get(step + stones[i]).add(step);
          }
        }
      }
    }



    return map.get(stones[stones.length - 1]).size() > 0;
  }

}
