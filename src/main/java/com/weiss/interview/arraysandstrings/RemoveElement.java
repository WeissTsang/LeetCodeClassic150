package com.weiss.interview.arraysandstrings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/***
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */

public class RemoveElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);

        int val = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int ans = removeElement(a, val);

        System.out.println("ans = " + ans);
    }

    private static int removeElement(int[] nums, int val) {
        int idx = 0;

        for (int x : nums) {
            if (x != val) {
                nums[idx++] = x;
            }
        }

        return idx;
    }
}
