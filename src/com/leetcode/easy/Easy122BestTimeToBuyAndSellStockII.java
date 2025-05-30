package com.leetcode.easy;


import java.util.Arrays;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy122BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println("Input:");
        System.out.println(Arrays.toString(prices));
        System.out.println("Expect:");
        System.out.println("7");

        System.out.println("Output:");
        System.out.println(maxProfit2(prices));
    }

    /*
     * 思路
     *
     * 只要股票价格上涨，上涨的部分就是我的利润，可以理解为上涨期间第一天买入，
     * 然后一直持有到上涨最后一天即下跌前一天再卖出。
     *
     * 只要股票价格下跌，那我肯定在下跌前一天卖了，而且下跌期间永远不会买入。买入时机在上涨的前一天
     * */
    public static int maxProfit(int[] prices) {

        int totalProfile = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                totalProfile += prices[i] - prices[i - 1];
            }
        }
        return totalProfile;
    }

    public static int maxProfit2(int[] prices) {
        int totalProfit = 0;
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if(buy < prices[i]) {
                totalProfit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return totalProfit;
    }
}

