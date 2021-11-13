package budget;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SaveLoad {
    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter("purchases.txt")) {
            pw.println(BudgetManager.income);
            pw.println(BudgetManager.totalSum);
            pw.println(BudgetManager.foodSum);
            pw.println(BudgetManager.clothesSum);
            pw.println(BudgetManager.entertainmentSum);
            pw.println(BudgetManager.otherSum);
            BudgetManager.budgetList.forEach((k, v) -> v.forEach(e -> pw.println(k.name + " " + e.toString())));
            System.out.println("Purchases were saved!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void loadFromFile() {
        try (Scanner fileScanner = new Scanner(new File("purchases.txt"))) {
            BudgetManager.income = new BigDecimal(fileScanner.nextLine());
            BudgetManager.totalSum = new BigDecimal(fileScanner.nextLine());
            BudgetManager.foodSum = new BigDecimal(fileScanner.nextLine());
            BudgetManager.clothesSum = new BigDecimal(fileScanner.nextLine());
            BudgetManager.entertainmentSum = new BigDecimal(fileScanner.nextLine());
            BudgetManager.otherSum = new BigDecimal(fileScanner.nextLine());
            while (fileScanner.hasNextLine()) {
                StringBuilder sb = new StringBuilder();
                String[] line = fileScanner.nextLine().split(" ");
                for (int i = 1; i <= line.length - 2; i++) {
                    sb.append(line[i] + " ");
                }
                String purchase = sb.toString().trim();
                BigDecimal price = new BigDecimal(line[line.length - 1].replace("$", ""));
                Item.Type type = Item.Type.valueOf(line[0].toUpperCase(Locale.ROOT));
                Item newItem = new Item(purchase, price, type);
                BudgetManager.budgetList.putIfAbsent(newItem.getType(), new ArrayList<>());
                BudgetManager.budgetList.get(type).add(newItem);
            }
            System.out.println("\nPurchases were loaded!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
