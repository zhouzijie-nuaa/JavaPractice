package Array;

/**
 * author: zijiezhou
 * Date:   2020/9/15 17:25
 * Description:
 */
public class Array {
    public  void array() {
        final int MAX = 10;
        int[][] odds = new int[MAX+1][];
        for (int n = 0; n <= MAX ; n++) {
            odds[n] = new int[n+1];
        }
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k ; i++) {
                    lotteryOdds = lotteryOdds * (n - i +1)/i;
                }
                odds[n][k] = lotteryOdds;
            }
        }
        for (int[] row : odds ) {
            for(int odd : row){
                System.out.printf("%4d",odd);
            }
            System.out.println();
        }
    }
}
