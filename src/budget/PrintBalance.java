package budget;

import java.text.NumberFormat;

public class PrintBalance {
    static void printBalance() {
        System.out.println("\nBalance: " + NumberFormat.getCurrencyInstance().format(BudgetManager.income));
    }
}
