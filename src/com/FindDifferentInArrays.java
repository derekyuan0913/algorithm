package com;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDifferentInArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5, 7, 9};
        int[] nums2 = {2, 3, 4, 9};
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println("Expect:");
        System.out.println("1,4,5,7");
        System.out.println("Output:");
        System.out.println(Arrays.toString(findDifference(nums1, nums2)));
        System.out.println(Arrays.toString(findDifference2(nums1, nums2)));
        System.out.println(Arrays.toString(findDifference3(nums1, nums2)));
        System.out.println(Arrays.toString(findDifference3(nums1, nums2)));
    }

    public static int[] findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        return Stream.concat(
                set1.stream().filter(num -> !set2.contains(num)),
                set2.stream().filter(num -> !set1.contains(num))
                )
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public static int[] findDifference2(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().toList();
        List<Integer> list2 = Arrays.stream(nums2).boxed().toList();

        List<Integer> result = new ArrayList<>(list1);
        result.addAll(list2);

        List<Integer> common = new ArrayList<>(list1);
        common.retainAll(list2);

        result.removeAll(common);

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    public static int[] findDifference3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> statisticMap = new HashMap<>();

        for (int num : nums1) {
            statisticMap.put(num, statisticMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            statisticMap.put(num, statisticMap.getOrDefault(num, 0) + 1);
        }

        return statisticMap.entrySet()
                .stream()
                .filter(entry-> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
