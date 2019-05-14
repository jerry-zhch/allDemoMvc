package com.ucmed.trie;

public class TrieTest{

    public static void main(String[] args) {
        String str="abcdef222ggg";
        char[] letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++) {
            int pos = letters[i] - 'a';
            System.out.println(letters[i]+"==="+pos);
        }
    }
}