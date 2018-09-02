package cn.missbe.algorithm.leetcode._201809;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *   Description:java_code
 *   mail: love1208tt@foxmail.com
 *   Copyright (c) 2018. missbe
 *   This program is protected by copyright laws.
 *   Program Name:algorithm
 *   @Date:18-8-30 下午1:58
 *   @author lyg
 *   @version 1.0
 *   @Description https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

public class TwoSumSorted {

    /**
     * 二分查找
     */
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    private int[] twoSum(@NotNull int[] numbers, int target) {
        int[] res;
        int len = numbers.length;
        for(int left = 0,right = len - 1; left < right; ){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1,1 + right};
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }
        }
        return  null;
    }

    /**
     *一遍Hash
     */
    @NotNull
    @Contract("_, _ -> new")
    private int[] twoSum2(@NotNull int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement)+1, i+1 };
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
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
            int[] numbers = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret =new TwoSumSorted().twoSum(numbers, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
