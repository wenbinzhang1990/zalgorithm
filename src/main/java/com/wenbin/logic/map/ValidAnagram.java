package com.wenbin.logic.map;

/**
 * 有效的字母异味词 https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {

  // 有效的字母异位词-数组
  public boolean isAnagramByArray(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
      table[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < table.length; i++) {
      if (table[i] != 0) {
        return false;
      }
    }

    return true;
  }
}
