package PrakritiAcharya_sec002_ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.0);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(account, "deposit", 500.0));
        transactions.add(new Transaction(account, "withdraw", 200.0));
        transactions.add(new Transaction(account, "deposit", 800.0));
        transactions.add(new Transaction(account, "withdraw", 300.0));

        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("All transactions completed.");
    }
}

