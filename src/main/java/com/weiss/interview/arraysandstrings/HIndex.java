package com.weiss.interview.arraysandstrings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = hIndex(a);
        System.out.println("ans = " + ans);
    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];

        for (int c : citations) {
            cnt[Math.min(c, n)]++;
        }

        int ans = 0;
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }

        return 0;
    }
}
