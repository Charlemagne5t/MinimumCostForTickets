public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length + 1];
        return dfs(days, costs, 0, memo);
    }

    private int dfs(int[] days, int[] costs, int i, Integer[] memo) {
        if (i >= days.length) return 0;
        if (memo[i] != null) {
            return memo[i];
        }
        int result = 0;
        int buy1Day = costs[0] + dfs(days, costs, i + 1, memo);
        int daysCoveredBy7DayTicket = days[i] + 6;
        int countDays7 = 0;
        for (int j = i + 1; j < days.length; j++) {
            if (daysCoveredBy7DayTicket >= days[j]) {
                countDays7++;
            }
        }

        int buy7Days = costs[1] + dfs(days, costs, i + 1 + countDays7, memo);

        int daysCoveredBy30DayTicket = days[i] + 29;
        int countDays30 = 0;
        for (int k = i + 1; k < days.length; k++) {
            if (daysCoveredBy30DayTicket >= days[k]) {
                countDays30++;
            } else break;
        }
        int buy30Days = costs[2] + dfs(days, costs, i + 1 + countDays30, memo);

        result = Math.min(buy1Day, Math.min(buy30Days, buy7Days));
        memo[i] = result;
        return result;
    }
}
