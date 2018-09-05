package cn.missbe.algorithm.leetcode._201809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *     mail: love1208tt@foxmail.com
 *     Copyright (c) 2018. missbe
 *     This program is protected by copyright laws.
 *     Program Name:algorithm
 *     @Date:18-8-30 下午1:43
 *     @author lyg
 *     @version 1.0
 *     @Description https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 **/

public class LongestPalindromicSubstring {
    /**
     * abcaacd  abcba babad
    **/
    public String longestPalindrome(String s) {
        int[] Split = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] split1 = expendchar(s, i, i);
            int[] split2 = expendchar(s, i, i + 1);
            int[] split;
            if (split1[1] - split1[0] > split2[1] - split2[0]) {
                split = split1;
            } else {
                split = split2;
            }
            if (split[1] - split[0] > Split[1] - Split[0]) {
                Split = split;
            }
        }
        return s.substring(Split[0], Split[1]);
    }

    public int[] expendchar(String s, int L, int R) {
        int[] split = new int[2];
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        split[0] = L + 1;
        split[1] = R;
        return split;
    }

    public String longestPalindrome2(String s) {

        if(s.equals("")){
            return "";
        }

        char[] sChars = s.toCharArray();
        int len = sChars.length;
        boolean[][] p = new boolean[len][len];

        ////initial
        for(int i = 0; i < len; i++){
            p[i][i] = true; ///1
            if(i != len - 1){
                p[i][i+1] = sChars[i] == sChars[i+1]; ///2
            }//end
        }

        ///process
        for (int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(j != i + 1 && i != j) { ///3
                    if( i > j){
                        p[i][j] = p[i - 1][j + 1] && sChars[i] == sChars[j];
                    }else{
                        p[i][j] = p[i + 1][j - 1] && sChars[i] == sChars[j];
                    }
                }///end if
            }
        }///end for

        int start = -1,end = -1,max = -1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(p[i][j] && (j - i > max || i - j > max)){
                    max = i > j ? i-j : j-i;
                    start = i > j ? j : i;
                    end = i > j ? i : j;
                }
//                System.out.print(" p[" + i + "][" + j +"]=" + p[i][j]);
            }//end inner for
//            System.out.println();
        }///end outer for
//        System.out.println(max + ":" + start + ":" + end);
        return s.substring(start, end + 1);
    }
}

class MainClass2 {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new LongestPalindromicSubstring().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
