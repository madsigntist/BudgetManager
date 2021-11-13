package budget;

import java.math.BigDecimal;
import java.util.Scanner;

public class AddIncome {
    static void addIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter income:");
        BigDecimal temp = scanner.nextBigDecimal();
        BudgetManager.income = BudgetManager.income.add(temp);
        System.out.println("\nIncome was added!");
    }
}
