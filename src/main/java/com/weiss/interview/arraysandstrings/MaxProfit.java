package com.weiss.interview.arraysandstrings;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = maxProfit(a);
        System.out.println("Max profit is " + ans);

        System.out.println("----------------------------");

        ans = maxProfit2(a);
        System.out.println("Max profit 2 is " + ans);
    }

    private static int maxProfit(int[] prices) {
        int ans = 0;
        int minCost = Integer.MAX_VALUE;

        for (int x : prices) {
            minCost = Math.min(minCost, x);
            ans  = Math.max(ans, x - minCost);
        }

        return ans;
    }

    private static int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) ans += diff;
        }

        return ans;
    }
}
