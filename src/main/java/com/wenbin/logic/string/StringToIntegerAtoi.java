package com.wenbin.logic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {

  public int myAtoi(String str) {
    if (str == null || str.trim().length() == 0) {
      return 0;
    }

    str = str.trim();
    char firstChar = str.charAt(0);
    int sign = 1;
    int start = 0;
    long res = 0;
    if (firstChar == '+') {
      sign = 1;
      start++;
    } else if (firstChar == '-') {
      sign = -1;
      start++;
    }

    for (int i = start; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return (int) res * sign;
      }
      res = res * 10 + str.charAt(i) - '0';
      if (sign == 1 && res > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (sign == -1 && res > Integer.MAX_VALUE) {
        return Integer.MIN_VALUE;
      }
    }
    return (int) res * sign;
  }

  public int myAtoiByAuto(String str) {
    Automaton automaton = new Automaton();
    int length = str.length();
    for (int i = 0; i < length; ++i) {
      automaton.get(str.charAt(i));
    }
    return (int) (automaton.sign * automaton.ans);
  }
}

class Automaton {

  public int sign = 1;
  public long ans = 0;
  private String state = "start";
  private Map<String, String[]> table = new HashMap<String, String[]>() {{
    put("start", new String[]{"start", "signed", "in_number", "end"});
    put("signed", new String[]{"end", "end", "in_number", "end"});
    put("in_number", new String[]{"end", "end", "in_number", "end"});
    put("end", new String[]{"end", "end", "end", "end"});
  }};

  public void get(char c) {
    state = table.get(state)[get_col(c)];
    if ("in_number".equals(state)) {
      ans = ans * 10 + c - '0';
      ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE)
          : Math.min(ans, -(long) Integer.MIN_VALUE);
    } else if ("signed".equals(state)) {
      sign = c == '+' ? 1 : -1;
    }
  }

  private int get_col(char c) {
    if (c == ' ') {
      return 0;
    }
    if (c == '+' || c == '-') {
      return 1;
    }
    if (Character.isDigit(c)) {
      return 2;
    }
    return 3;
  }
}
