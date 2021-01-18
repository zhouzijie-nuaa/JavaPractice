package Concurrency.unsynch;

/**
 * author: zijiezhou
 * Date:   2020/12/23 15:09
 * Description:
 */
public class UnsynchBankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 100;
    public static final double MAX_AMOUNT = 100;
    public static final int DELAY  = 100;

    public static void main(String[] args) {

        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount =i;
            Runnable r = () ->{
                try {
                    while (true){
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }


    }
}
