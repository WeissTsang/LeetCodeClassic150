package com.weiss.interview.arraysandstrings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);

        int k = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = removeKDuplicates(a, k);
        System.out.println("ans = " + ans);
    }

    private static int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int x : nums) {
            if (idx < 1 || nums[idx - 1] != x)
                nums[idx++] = x;
        }

        return idx;
    }

    private static int removeKDuplicates(int[] nums, int k) {
        int idx = 0;

        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) {
                nums[idx++] = x;
            }
        }

        return idx;
    }
}
