package cn.missbe.algorithm.leetcode._201809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *   Description:java_code
 *   mail: love1208tt@foxmail.com
 *   Copyright (c) 2018. missbe
 *   This program is protected by copyright laws.
 *   Program Name:algorithm
 *   @Date:18-8-30 下午1:43
 *   @author lyg
 *   @version 1.0
 *   @Description https://leetcode.com/problems/two-sum/description/
 */

public class TwoSum {

    private int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int length = nums.length;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new TwoSum().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
