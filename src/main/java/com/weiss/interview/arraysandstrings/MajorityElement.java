package com.weiss.interview.arraysandstrings;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = majorityElement(a);
        System.out.println("ans = " + ans);
    }

    private static int majorityElement(int[] nums) {
        int votes = 0;
        int ans = 0;

        for (int x : nums) {
            if (votes == 0) {
                ans = x;
            }
            votes += ans == x ? 1 : -1;
        }

        return ans;
    }
}
