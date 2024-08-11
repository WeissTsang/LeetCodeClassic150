package com.weiss.interview.arraysandstrings;

public class MergeTwoOrderedArrays {
    public static void main(String[] args) {
        int[] a1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] a2 = new int[] {2, 5, 6};
        int m = 3;
        int n = 3;

        merge(a1, m, a2, n);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a1.length; i++) {
            if (i < a1.length - 1)
                sb.append(a1[i]).append(", ");
            else sb.append(a1[i]);
        }

        System.out.println(sb.toString());
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
