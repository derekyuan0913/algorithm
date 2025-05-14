package com.leetcode.easy;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy387FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";

        System.out.println("Input:");
        System.out.println(s);
        System.out.println("Expect:");
        System.out.println("2");


        System.out.println("Output:");
        System.out.println(new Easy387FirstUniqueCharacterSolution().firstUniqChar(s));
    }
}

class Easy387FirstUniqueCharacterSolution {


    /*
    * 直接利用 String类的 indexOf 和 lastIndexOf 解决即可。
    * */
    public int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }


    /* 错解

    * 利用双层循环遍历法未做出来（字符为""或单字符时出错结果出错）
    * */
    public int firstUniqChar2(String s) {

        int position = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = i+1; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    break;
                }
                if(j == s.length() -1) {
                    position = i;
                    return position;
                }
            }
        }

        return position;
    }
}
