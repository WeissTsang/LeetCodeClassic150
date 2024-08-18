package com.weiss.interview.arraysandstrings;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[] {1, 2, 3, 4, 5};
        int[] cost = new int[] {3, 4, 5, 1, 2};

        int ans = canCompleteCircuit(gas, cost);
        System.out.println("ans = " + ans);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int cur = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            cur += gas[i] - cost[i];

            if (cur < 0) {
                ans = i + 1;
                cur = 0;
            }
        }

        return sum >= 0 ? ans : -1;
    }
}
