package com.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy20VaildParentheses {

    public static void main(String[] args) {
        String s = "]";
        System.out.println("Input:");
        System.out.println("s");
        System.out.println("Expect:");
        System.out.println("false");


        System.out.println("Output:");
        System.out.println(new Easy20VaildParenthesesSolution().isValid(s));
    }
}

class Easy20VaildParenthesesSolution {

    /*
    利用栈，写法一，较为繁琐
    * */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                char out = stack.pop();
                if(c == ')' && out !='(') {
                    return false;
                }
                if(c == ']' && out !='[') {
                    return false;
                }
                if(c == '}' && out !='{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    /*
    利用栈，写法二，较为简洁
    * */
    public boolean isValid2(String s) {
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (mappings.containsKey(c)) {
                char out = stack.isEmpty() ? '#' : stack.pop();
                if(out != mappings.get(c)) { return false; }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
