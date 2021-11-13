package budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class AddPurchase {
    static void addPurchase() {
        Scanner scanner = new Scanner(System.in);
        boolean isAddPurchaseRunning = true;
        while (isAddPurchaseRunning) {
            System.out.println();
            Menu.printCategoryMenu();
            Item.Type type = null;
            int category = scanner.nextInt();
            scanner.nextLine();
            if (category == 5) {
                isAddPurchaseRunning = false;
            } else {
                System.out.println("\nEnter purchase name:");
                String purchase = scanner.nextLine();

                System.out.println("Enter its price:");
                BigDecimal price = scanner.nextBigDecimal();

                BudgetManager.totalSum = BudgetManager.totalSum.add(price);
                BudgetManager.income = BudgetManager.income.subtract(price);

                switch (category) {
                    case 1:
                        type = Item.Type.FOOD;
                        BudgetManager.foodSum = BudgetManager.foodSum.add(price);
                        break;
                    case 2:
                        type = Item.Type.CLOTHES;
                        BudgetManager.clothesSum = BudgetManager.clothesSum.add(price);
                        break;
                    case 3:
                        type = Item.Type.ENTERTAINMENT;
                        BudgetManager.entertainmentSum = BudgetManager.entertainmentSum.add(price);
                        break;
                    case 4:
                        type = Item.Type.OTHER;
                        BudgetManager.otherSum = BudgetManager.otherSum.add(price);
                    default:
                        break;
                }
                Item newItem = new Item(purchase, price, type);
                BudgetManager.budgetList.putIfAbsent(newItem.getType(), new ArrayList<>());
                BudgetManager.budgetList.get(type).add(newItem);
                System.out.println("Purchase was added!");
            }
        }
    }
}
