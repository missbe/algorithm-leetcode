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
 *     @Description https://leetcode-cn.com/problems/reverse-integer/description/
 **/

public class ReverseIntege {

    public int reverse(int x){
        int res = 0,tmp;

        while(x != 0){
            int pop = x % 10;
            x /= 10;

            int flag = res >=0 ?res : -res;
            if(flag > Integer.MAX_VALUE / 10 || (flag == Integer.MAX_VALUE /10 && pop > 7)){
                return 0;
            }

            tmp = res *10 + pop;
            res = tmp;
        }
        return res;

    }
    public int reverse2(int x) {
        if(x == 0){
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = x >= 0;

        x = Math.abs(x);

        while(x != 0){
            builder.append(String.valueOf(x%10));
            x /= 10;
        }///end while

        int res = 0;
        try {
            res = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return flag ? res : -res;

    }
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE + ":" + Integer.MIN_VALUE);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new ReverseIntege().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
