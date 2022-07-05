package com.wenbin.logic.greed;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class WalkingRobotSimulation {

  public int robotSim(int[] commands, int[][] obstacles) {
    if (commands == null || commands.length == 0) {
      return 0;
    }

    int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int x = 0, y = 0, dir = 0, max = 0;
    Set<String> obstacle = new HashSet<>();
    for (int[] i : obstacles) {
      obstacle.add(i[0] + "+" + i[1]);
    }

    for (int i = 0; i < commands.length; i++) {
      if (commands[i] == -2) {
        dir = (dir + 3) % 4;
      } else if (commands[i] == -1) {
        dir = (dir + 1) % 4;
      } else {
        for (int step = 0; step < commands[i]; step++) {
          if (obstacle.contains((x + direction[dir][0]) + "+" + (y + direction[dir][1]))) {
            break;
          }

          x += direction[dir][0];
          y += direction[dir][1];
          max = Math.max(max, x * x + y * y);
        }
      }
    }

    return max;
  }
}
