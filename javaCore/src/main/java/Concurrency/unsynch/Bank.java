package Concurrency.unsynch;

import java.util.Arrays;

/**
 * author: zijiezhou
 * Date:   2020/12/23 14:54
 * Description:
 */
public class Bank {

    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from, int to, double amout){
        if (accounts[from] < amout) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amout;
        System.out.printf("%10.2f from %d to %d", amout, from, to);
        accounts[to] += amout;
        System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
    }

    public double getTotalBalance(){
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
