package com.wenbin.logic.string;

/**
 * 宝石与石头 https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

  public int numJewelsInStones(String j, String s) {
    int[] jewels = new int[128];
    for (char c : j.toCharArray()) {
      jewels[c]++;
    }

    int result = 0;
    for (char c : s.toCharArray()) {
      if (jewels[c] > 0) {
        result++;
      }
    }

    return result;
  }
}
