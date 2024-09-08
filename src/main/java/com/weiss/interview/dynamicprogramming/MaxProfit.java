package com.weiss.interview.dynamicprogramming;

import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;

        int ans = maxProfit3(prices, k);
        System.out.println("ans = " + ans);
    }

    private static int maxProfit3(int[] prices, int k) {
        int n = prices.length;
        int[][][] f = new int[n+1][k+2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 2; j++) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE / 2);
            }
        }

        for (int j = 0; j < k + 2; j++) {
            f[0][j][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j -1 ][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j][0] - prices[i]);  // 买卖合起来算一次交易
            }
        }

        return f[n][k+1][0];
    }
}
