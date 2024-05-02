import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String s = "3242415";
        int expected = 5;
        int actual = new Solution().longestAwesome(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        String s = "12345678";
        int expected = 1;
        int actual = new Solution().longestAwesome(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3(){
        String s = "213123";
        int expected = 6;
        int actual = new Solution().longestAwesome(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test4(){
        String s = "373781";
        int expected = 5;
        int actual = new Solution().longestAwesome(s);

        Assert.assertEquals(expected, actual);
    }
}
