package com.leetcode.easy;


import java.util.Arrays;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。


输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。


输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input:");
        System.out.println(Arrays.toString(prices));
        System.out.println("Expect:");
        System.out.println("5");

        System.out.println("Output:");
        System.out.println(maxProfit2(prices));
    }

    /*
     * 动态规划
     * */
    public static int maxProfit(int[] prices) {

        if(prices.length <= 1) {
            return 0;
        }

        int buy = prices[0];
        int profile = 0;
        int maxProfile = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            }else {
                profile = prices[i] - buy;
                maxProfile = Math.max(profile, maxProfile);
            }
        }
        return maxProfile;
    }

    public static int maxProfit2(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > buy) {
                profit = prices[i] - buy;
            } else {
                buy = prices[i];
            }
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}

