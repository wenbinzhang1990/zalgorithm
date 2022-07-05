package com.wenbin.logic.string;

/**
 * 转换成小写字母 https://leetcode-cn.com/problems/to-lower-case/
 */
public class ToLowerCase {

  public String toLowerCaseByLib(String str) {
    return str.toLowerCase();
  }

  public static void main(String[] args) {
    ToLowerCase toLowerCase = new ToLowerCase();
    System.out.println(toLowerCase.toLowerCaseBySelf("HELLO"));
  }

  public String toLowerCaseBySelf(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }
    char[] ch = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (ch[i] >= 'A' && ch[i] <= 'Z') {
        ch[i] += 32;
      }
    }

    return String.valueOf(ch);
  }
}
