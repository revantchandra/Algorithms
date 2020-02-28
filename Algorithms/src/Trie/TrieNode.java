package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> children;
    boolean isEod;

    TrieNode(HashMap<Character,TrieNode> ch, boolean eod){
        children = ch;
        isEod = eod;
    }
}
