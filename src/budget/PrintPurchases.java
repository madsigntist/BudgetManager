package budget;

import java.text.NumberFormat;
import java.util.Scanner;

public class PrintPurchases {
    static void printPurchases() {
        Scanner scanner = new Scanner(System.in);
        boolean isPrintPurchasesRunning = true;
        while (isPrintPurchasesRunning) {
            Menu.printPurchaseListMenu();
            int category = scanner.nextInt();
            if (category == 6) {
                isPrintPurchasesRunning = false;
            } else {
                switch (category) {
                    case 1:
                        if (!BudgetManager.budgetList.containsKey(Item.Type.FOOD)) {
                            System.out.println("The purchase list is empty");
                        } else {
                            System.out.println("\nFood:");
                            BudgetManager.budgetList.get(Item.Type.FOOD).forEach(System.out::println);
                            System.out.println("Total Sum: " + NumberFormat.getCurrencyInstance().format(BudgetManager.foodSum));
                        }
                        break;
                    case 2:
                        if (!BudgetManager.budgetList.containsKey(Item.Type.CLOTHES)) {
                            System.out.println("The purchase list is empty");
                        } else {
                            System.out.println("\nClothes:");
                            BudgetManager.budgetList.get(Item.Type.CLOTHES).forEach(System.out::println);
                            System.out.println("Total Sum: " + NumberFormat.getCurrencyInstance().format(BudgetManager.clothesSum));
                        }
                        break;
                    case 3:
                        if (!BudgetManager.budgetList.containsKey(Item.Type.ENTERTAINMENT)) {
                            System.out.println("The purchase list is empty");
                        } else {
                            System.out.println("\nEntertainment:");
                            BudgetManager.budgetList.get(Item.Type.ENTERTAINMENT).forEach(System.out::println);
                            System.out.println("Total Sum: " +
                                    NumberFormat.getCurrencyInstance().format(BudgetManager.entertainmentSum));
                        }
                        break;
                    case 4:
                        if (!BudgetManager.budgetList.containsKey(Item.Type.OTHER)) {
                            System.out.println("The purchase list is empty");
                        } else {
                            System.out.println("\nOther:");
                            BudgetManager.budgetList.get(Item.Type.OTHER).forEach(System.out::println);
                            System.out.println("Total Sum: " + NumberFormat.getCurrencyInstance().format(BudgetManager.otherSum));
                        }
                        break;
                    case 5:
                        if (BudgetManager.budgetList.isEmpty()) {
                            System.out.println("The purchase list is empty");
                        } else {
                            System.out.println("\nAll:");
                            BudgetManager.budgetList.forEach((k, v) -> v.forEach(System.out::println));
                            System.out.println("Total Sum: " + NumberFormat.getCurrencyInstance().format(BudgetManager.totalSum));
                        }
                        break;
                    default:
                        break;
                }

            }
        }
    }
}
