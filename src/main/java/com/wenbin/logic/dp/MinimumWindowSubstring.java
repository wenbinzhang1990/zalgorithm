package com.wenbin.logic.dp;

/**
 * 最小覆盖子串 https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

  public static void main(String[] args) {
    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    minimumWindowSubstring.minWindow("a", "a");
  }

  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return "";
    }

    int[] window = new int[128], need = new int[128];
    int count = 0;
    String res = "";
    int min = s.length();
    for (int i = 0; i < t.length(); i++) {
      need[t.charAt(i)]++;
    }

    int left = 0, right = 0;
    while (right < s.length()) {
      char rightChar = s.charAt(right);
      window[s.charAt(right)]++;
      if (window[rightChar] <= need[rightChar]) {
        count++;
      }

      while (count == t.length()) {
        if (right - left + 1 <= min) {
          res = s.substring(left, right + 1);
          min = right - left + 1;
        }

        char leftChar = s.charAt(left);
        window[leftChar]--;
        if (window[leftChar] < need[leftChar]) {
          count--;
        }

        left++;
        if (left >= s.length()) {
          break;
        }
      }

      right++;
    }
    return res;
  }
}
