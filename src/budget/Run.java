package budget;

import java.util.Scanner;

public class Run {
    static void run() {
        Scanner scanner = new Scanner(System.in);
        while (BudgetManager.isRunning) {
            Menu.printMenu();
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    AddIncome.addIncome();
                    break;
                case 2:
                    AddPurchase.addPurchase();
                    break;
                case 3:
                    PrintPurchases.printPurchases();
                    break;
                case 4:
                    PrintBalance.printBalance();
                    break;
                case 5:
                    SaveLoad.saveToFile();
                    break;
                case 6:
                    SaveLoad.loadFromFile();
                    break;
                case 7:
                    AnalyzeSort.analyzeSort();
                    break;
                case 0:
                    BudgetManager.exit();
                    break;
                default:
                    break;
            }
        }
    }
}
