package com.weiss.interview.arraysandstrings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ProductExceptSelf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int[] ans = productExceptSelf(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i < ans.length - 1) {
                sb.append(ans[i]).append(", ");
            } else {
                sb.append(ans[i]);
            }
        }

        System.out.println(sb.toString());
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = product * ans[i];
            product *= nums[i];
        }

        return ans;
    }
}
