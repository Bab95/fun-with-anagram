package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static boolean checkForAnagram(char[] str1,char[] str2){
        Arrays.sort(str1);
        Arrays.sort(str2);
        int i = 0;
        int j = 0;
        while(i<str1.length&&j<str2.length){
            if(str1[i]!=str2[j]){
                return false;
            }
            ++i;
            ++j;
        }
        return (i==str1.length&&j==str2.length);
    }

    public static ArrayList<String> fun_with_Anagrams(String[] strs){
        boolean[] deleted = new boolean[strs.length];
        for(int i=0;i<deleted.length;++i){
            deleted[i] = false;
        }
        /*
        * Start from last index and check if its anagram is found at an index
        * less than this mark it as deleted*/
        for(int i=strs.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(checkForAnagram(strs[i].toCharArray(),strs[j].toCharArray())==true){
                    deleted[i] = true;
                    break;
                }
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<deleted.length;++i){
            if(deleted[i]==false){
                ans.add(strs[i]);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
	// write your code here
        String[] str = {"code", "doce", "ecod", "framer", "frame"};
        ArrayList<String> ans = fun_with_Anagrams(str);
        for(String s:ans){
            System.out.println(s);
        }
    }
}
