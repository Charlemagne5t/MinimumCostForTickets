import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void mincostTicketsTest1() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int expected = 11;
        int output = new Solution().mincostTickets(days, costs);

        Assert.assertEquals(expected, output);
    }

    @Test
    public void mincostTicketsTest2() {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        int expected = 17;
        int output = new Solution().mincostTickets(days, costs);

        Assert.assertEquals(expected, output);
    }
}
