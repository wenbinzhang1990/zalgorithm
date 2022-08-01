package com.wenbin.logic.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *   Ac自动机
 *
 *   @Author wenbin
 */
public class AcTrieTreeChina {

    /**
     * Ac节点
     */
    class AcTrieNode {

        /**
         * 字符
         */
        String word;

        /**
         * 是否有已匹配字符
         */
        boolean end;

        /**
         * 失配指针
         */
        AcTrieNode fail;


        /**
         * next指针
         */
        Map<Character, AcTrieNode> next = new HashMap<>();
    }

    private List<String> targets;

    private AcTrieNode root;

    public AcTrieTreeChina(List<String> targets) {
        this.targets = targets;
        this.root = new AcTrieNode();
        buildTireTree();
        buildAcFromTrie();
    }

    /**
     * 根据Trie树构建Ac自动机
     */
    private void buildAcFromTrie() {
        Queue<AcTrieNode> queue = new ArrayDeque<>();
        for (AcTrieNode node : root.next.values()) {
            if (node != null) {
                queue.add(node);
                node.fail = root;
            }
        }

        while (!queue.isEmpty()) {
            AcTrieNode node = queue.poll();
            for (Character c : node.next.keySet()) {
                queue.add(node.next.get(c));
                AcTrieNode failTo = node.fail;
                while (true) {
                    if (failTo == null) {
                        node.next.get(c).fail = root;
                        break;
                    }

                    if (failTo.next.get(c) != null) {
                        node.next.get(c).fail = failTo.next.get(c);
                        break;
                    } else {
                        failTo = failTo.fail;
                    }
                }
            }
        }
    }


    /**
     * 构建trie树
     */
    public void buildTireTree() {
        for (String word : targets) {
            AcTrieNode trie = root;
            for (int i = 0; i < word.length(); i++) {
                if (trie.next.get(word.charAt(i)) == null) {
                    trie.next.put(word.charAt(i), new AcTrieNode());
                }

                trie = trie.next.get(word.charAt(i));
            }

            trie.end = true;
            trie.word = word;
        }
    }

    /**
     * 查询单词
     * @param text
     * @return
     */
    public Set<String> search(String text) {
        Set<String> result = new HashSet<>(16);
        AcTrieNode cur = root;
        int index = 0;
        while (index < text.length()) {
            char c = text.charAt(index);
            if (cur.next.get(c) != null) {
                cur = cur.next.get(c);
                if (cur.end) {
                    result.add(cur.word);
                }

                if (cur.fail != null && cur.fail.end) {
                    result.add(cur.word);
                }

                index++;
            } else {
                cur = cur.fail;
                if (cur == null) {
                    cur = root;
                    index++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("测试");
        list.add("任命");
        list.add("任务");
        list.add("人人");
        list.add("人民");
        list.add("人民币");
        list.add("人性");
        list.add("人生");
        list.add("人话");
        list.add("哈哈");
        list.add("电脑");
        list.add("电视");
        list.add("电机");
        list.add("网络电话");
        list.add("网络游戏");
        list.add("网络开发");
        list.add("网络电机");

        AcTrieTreeChina ac = new AcTrieTreeChina(list);
        Set<String> searchResult = ac.search("人性电机网络电机");
        assert searchResult.size() == 3;
    }
}
