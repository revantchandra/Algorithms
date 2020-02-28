package Trie;

import java.util.HashMap;

public class TestImpl {
    TrieNode trie = new TrieNode(new HashMap<Character,TrieNode>(),false);
    public static void main(String[] args) {
        TestImpl impl = new TestImpl();
        String text = "Welcome to the world of Geeks \n" +
                "This portal has been created to provide well written well thought and well explained \n" +
                "solutions for selected questions If you like Geeks for Geeks and would like to contribute \n" +
                "here is your chance You can write article and mail your article to contribute at \n" +
                "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help \n" +
                "thousands of other Geeks";

        for(String str : text.split(" ")){
            impl.inset(str);
        }

//        impl.inset("test");
//        impl.inset("abgl");
//        impl.inset("teap");
//        impl.inset("alphatestmake");

        System.out.println("is word cdf present "+ impl.search("explained"));
    }

    void inset(String str){
        int i=0;
        TrieNode  curr = trie;
        while(i<str.length()){
            if(!curr.children.containsKey(str.charAt(i))){
                curr.children.put(str.charAt(i), new TrieNode(new HashMap<Character, TrieNode>(),false));
                if(i==str.length()-1){
                    curr.isEod = true;
                }
            }
            curr = curr.children.get(str.charAt(i));
            i++;
        }
    }

    boolean search(String str){
        int i=0;
        TrieNode curr = trie;
        while(i<str.length()){
            if(curr.children.containsKey(str.charAt(i))){
                if(i==str.length()-1 && curr.isEod){
                    return true;
                }
                curr = curr.children.get(str.charAt(i));
            }
            i++;
        }
        return false;
    }
}
