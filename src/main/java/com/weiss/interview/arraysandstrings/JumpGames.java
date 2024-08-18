package com.weiss.interview.arraysandstrings;

public class JumpGames {
    public static void main(String[] args) {

    }

    private static boolean canJump(int[] nums) {
        int end = 0;
        int far = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            far = Math.max(far, i + nums[i]);
            if (end == i) {
                end = far;
                if (end >= n - 1) return true;
            }
        }

        return false;
    }

    private static int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int far = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (end == i) {
                end = far;
                ans++;
            }
        }

        return ans;
    }
}
