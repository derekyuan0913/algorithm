package com.leetcode;


/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

示例 1：

输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy344ReverseString {

    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        System.out.println("Input:");
        System.out.println("输入：[\"h\",\"e\",\"l\",\"l\",\"o\"]");
        System.out.println("Expect:");
        System.out.println("输出：[\"o\",\"l\",\"l\",\"e\",\"h\"]");

        new Easy344ReverseStringSolution().reverseString(s);

        int a=3;
        int b = 5;

        a ^=b;
        b^=a;
        a ^=b;
        System.out.println(a);
        System.out.println(b);

    }
}

class Easy344ReverseStringSolution {


    /*
    * 解法1，常规解法
    * */
    public void reverseString(char[] s) {

        int l = 0;
        int r = s.length-1;
        char tmp;
        while (l < r) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }


    /*
     * 解法2，通过三次异或运算交换值
     *
     *  a ^=b; b^=a; a ^=b; 即可完成 a, b 值的交换
     * */
    public void reverseString2(char[] s) {

        int l = 0;
        int r = s.length-1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }


}
