package com.wenbin.logic.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

  Map<String, String> map = new HashMap();
  List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    map.put("2", "abc");
    map.put("3", "def");
    map.put("4", "ghi");
    map.put("5", "jkl");
    map.put("6", "mno");
    map.put("7", "pqrs");
    map.put("8", "tuv");
    map.put("9", "wxyz");

    dfs(digits, new StringBuilder());
    return result;
  }



  private void dfs(String digits, StringBuilder stringBuilder) {
    if (stringBuilder.length() == digits.length()) {
      result.add(stringBuilder.toString());
      return;
    }

    String mayBeValue = map.get(String.valueOf(digits.charAt(stringBuilder.length())));
    for (int i = 0; i < mayBeValue.length(); i++) {
      stringBuilder.append(mayBeValue.charAt(i));
      dfs(digits, stringBuilder);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }
}
