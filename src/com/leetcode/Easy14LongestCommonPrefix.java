package com.leetcode;

import java.util.Arrays;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy14LongestCommonPrefix {

    public static void main(String[] args) {

        String[] input = {"flower","flow","flight"};
        System.out.println("Input:");
        System.out.println(Arrays.toString(input));
        System.out.println("Expect:");
        System.out.println("fl");

        System.out.println("Output:");
        System.out.println(new Easy14LongestCommonPrefixSolution().longestCommonPrefix(input));
    }
}


class Easy14LongestCommonPrefixSolution {

    /*
    * 解法1， 按字符列扫描
    *
    * 用第首个单词的每个字符（遍历字符），依次到剩余单词（遍历剩余单词）对应位置检查是否一致，
    *  一致则继续下一个字符检查，不一致则停止检查，直接返回当前结果。
    *
    *
    * */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //容易忽略掉 strs[j].length() == i 条件 而导致 ["aa", "a"] 的情况下出现数组越界
                if(strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
