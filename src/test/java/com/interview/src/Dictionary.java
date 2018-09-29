package com.interview.src;
//dictionary: apple, banana, cat, car, door.....
// Boolean lookup(String str)

import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public boolean lookup(String word) {
        if(this.words.contains(word)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cat","door");
        Dictionary dict = new Dictionary(words);
        boolean exists = dict.lookup("cat");
        System.out.println("Exists = " + exists);

        System.out.println(dict.strStr("thii is a sentence", "is"));
        System.out.println(dict.strStr2("thii is a sentence", "is"));
    }


    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);

        char[] haystackChars = haystack.toCharArray();
        int needleLength = needle.length(); // 2

        for(int i = 0; i< (haystack.length()-needleLength);i++) {
            String subHaystack = haystack.substring(i, i+needleLength); // th
            if(subHaystack.equalsIgnoreCase(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int needleLength = needle.length(); // 2

        for(int i = 0; i< (haystackChars.length-needleLength);i++) {
            boolean found = true;
            for(int j=0;j<needleChars.length;j++) {
                if(haystackChars[i+j] != needleChars[j]) {
                    found = false;
                    break;
                }
            }
            if(found) {
                return i;
            }
        }
        // return 0;

        return haystack.indexOf(needle);
    }
}

