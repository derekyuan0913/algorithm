package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestSellingProduct {


    public static void main(String[] args) {
        List<Integer> sales = Arrays.asList(101, 102, 101, 103, 102, 101, 104, 101, 102, 102);

        System.out.println("最畅销商品ID: " + findBestSellingProduct(sales));  // 输出: 101
        System.out.println("最畅销商品ID: " + findBestSellingProduct2(sales));  // 输出: 101

    }

    private static int findBestSellingProduct(List<Integer> sales) {
        return sales.stream().collect(Collectors.groupingBy(id-> id, Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    private static int findBestSellingProduct2(List<Integer> sales) {
        Map<Integer, Integer> statisticMap = new HashMap<>();
        for (Integer sale : sales) {
            statisticMap.put(sale,statisticMap.getOrDefault(sale,0) + 1);
        }

        int maxCount = 0;
        int maxId = -1;
        for(Map.Entry<Integer, Integer> entry : statisticMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxId = entry.getKey();
            }
        }
        return maxId;
    }
}
