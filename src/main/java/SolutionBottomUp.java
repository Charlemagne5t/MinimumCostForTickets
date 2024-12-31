class SolutionBottomUp {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp  = new int[days[days.length - 1] + 1];
        int j = 0;
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {
            if(i < days[j]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Integer.MAX_VALUE;

            dp[i] = Math.min(dp[i],  dp[i - 1] + costs[0]);

            if(i - 7 >= 0) {
                dp[i] = Math.min(dp[i],  dp[i - 7] + costs[1]);
            }else {
                dp[i] = Math.min(dp[i], costs[1]);
            }
            if(i - 30 >= 0) {
                dp[i] = Math.min(dp[i],  dp[i - 30] + costs[2]);
            }else {
                dp[i] = Math.min(dp[i], costs[2]);
            }

            j++;
        }

        return dp[dp.length - 1];

    }
}
