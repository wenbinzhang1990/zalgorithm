package com.wenbin.logic.greed;

import java.util.Arrays;

/**
 * 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    if (g == null || g.length == 0 || s == null || s.length == 0) {
      return 0;
    }

    Arrays.sort(g);
    Arrays.sort(s);
    int gIndex = 0;
    for (int i = 0; i < s.length && gIndex < g.length; i++) {
      if (s[i] >= g[gIndex]) {
        gIndex++;
      }
    }

    return gIndex;
  }
}
