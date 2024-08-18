package com.weiss.interview.arraysandstrings;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        rotate(a, k);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i < n -1) {
                sb.append(a[i]).append(", ");
            } else {
                sb.append(a[i]);
            }
        }

        System.out.println(sb.toString());
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n);
        reverse(nums, 0, k);
        reverse(nums, k, n);
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end - 1;

        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
