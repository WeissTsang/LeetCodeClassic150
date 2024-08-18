package com.weiss.interview.arraysandstrings;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = new int[] {1, 2, 2};
        int ans = candy(ratings);

        System.out.println("ans = " + ans);
    }

    private static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            ans += candies[i];
        }

        return ans;
    }
}
