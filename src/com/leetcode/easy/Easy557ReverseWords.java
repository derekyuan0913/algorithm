package com.leetcode.easy;


import java.util.Stack;
import java.util.StringJoiner;

/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy557ReverseWords {

    public static void main(String[] args) {

        System.out.println();
        String s = "Let's take LeetCode contest";
        System.out.println(s);
        System.out.println(reverseWords3(s));
    }

    /*
     * 方法1，基于栈实现，时间和空间效率较低
     * */
    public static String reverseWords(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            if (c == ' ' || c== '.') {
                stack.pop();
                while (stack.size() > 0) {
                    builder.append(stack.pop());
                }
                builder.append(' ');
            }
            if ( i == s.length()-1) {
                while (stack.size() > 0) {
                    builder.append(stack.pop());
                }
            }
        }
        return builder.toString();
    }


    /*
     * 方法2，利用StringBuilder实现字符串反转和拼接
     * */

    public static String reverseWords3(String s) {

        StringBuilder builder = new StringBuilder();
        for(String word: s.split(" ")) {
            builder.append(new StringBuilder(word).reverse()).append(" ");
        }
        return builder.substring(0, builder.length()-1);
    }


    /*
     * 方法3，利用java.util.StringJoiner实现拼接，利用StringBuilder实现字符串反转
     * */
    public static String reverseWords2(String s) {

        StringJoiner joiner = new StringJoiner(" ");

        for(String word: s.split(" ")) {
            joiner.add(new StringBuilder(word).reverse());
        }
        return joiner.toString();
    }

    /*
     * 方法4，转换为CharArray，手动交换单词中字符，遇到空格跳过
     * 时间效率较高
     * */
    public static String reverseWords4(String s) {

        char[] wordsArray = s.toCharArray();
        int startInx = 0;

        for(int i = 0; i< wordsArray.length; i++) {
            if( i== wordsArray.length-1 || wordsArray[i+1] == ' ') {

                int endInx = i;
                while (startInx <= endInx) {
                    char tmp = wordsArray[startInx];
                    wordsArray[startInx] = wordsArray[endInx];
                    wordsArray[endInx] = tmp;
                    startInx++;
                    endInx--;
                }
                startInx = i+2;
            }
        }
        return String.valueOf(wordsArray);
    }
}


