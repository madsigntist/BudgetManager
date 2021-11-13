package budget;

import java.util.Scanner;

public class AnalyzeSort {
    static void analyzeSort() {
        Scanner scanner = new Scanner(System.in);
        boolean isAnalyzeRunning = true;
        while (isAnalyzeRunning) {
            Menu.printSortMenu();
            Sort sort = new Sort();
            int sortType = scanner.nextInt();
            if (sortType == 4) {
                isAnalyzeRunning = false;
            } else {
                switch (sortType) {
                    case 1:
                        sort.setSort(new sortAllPurchases());
                        sort.sort();
                        break;
                    case 2:
                        sort.setSort(new sortByType());
                        sort.sort();
                        break;
                    case 3:
                        sort.setSort(new sortCertainType());
                        sort.sort();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
