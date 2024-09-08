package com.weiss.interview.dynamicprogramming;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class minDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

//        String s1 = "horse";
//        String s2 = "ros";

        int ans = minDistance(s1, s2);

        System.out.println("ans = " + ans);
    }

    private static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        Integer[][] memo = new Integer[m+1][n+1];

        return dfs(m, n, word1, word2, memo);
    }

    private static int dfs(int i, int j, String word1, String word2, Integer[][] memo) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (memo[i][j] != null) return memo[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return memo[i][j] = dfs(i - 1, j - 1, word1, word2, memo);
        }

        int deleted = dfs(i - 1, j, word1, word2, memo);
        int inserted = dfs(i, j - 1, word1, word2, memo);
        int replaced = dfs(i - 1, j - 1, word1, word2, memo);

        memo[i][j] = Math.min(replaced, Math.min(deleted, inserted)) + 1;

        return memo[i][j];
    }
}
