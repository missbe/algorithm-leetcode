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
 *     @Description https://leetcode-cn.com/problems/palindrome-number/description/
 **/

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        char[] res = String.valueOf(x).toCharArray();
        int left = 0,right = res.length - 1;
        while (left < right){
            if(res[left] == res[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;

    }
    public boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        boolean res = true;
        int[] remainder = new int[32];
        int len = 0;
        while(x != 0){
            remainder[len++] = x % 10;
            x /= 10;
        }//end
        for(int i = 0, j = len - 1; i < j; i++, j--){
            if( remainder[i] != remainder[j]){
                return false;
            }///continue
        }

        return res;
    }
}

 class MainClass {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new PalindromeNumber().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
