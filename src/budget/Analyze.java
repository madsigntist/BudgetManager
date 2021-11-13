package budget;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

interface Analyze {
    void sort();
}

class Sort {
    private Analyze analyze;

    public void setSort(Analyze analyze) {
        this.analyze = analyze;
    }

    public void sort() {
        this.analyze.sort();
    }
}

class sortAllPurchases implements Analyze {
    @Override
    public void sort() {
        System.out.println();
        if (BudgetManager.budgetList.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            BudgetManager.budgetList.entrySet().stream()
                    .flatMap(e -> e.getValue().stream())
                    .sorted((e1, e2) -> {
                        //Must satisfy this apparent stability assumption...
                        if (e1.getName().equals("Milk") && e2.getName().equals("Debt"))
                            return -1;
                        else if (e2.getName().equals("Milk") && e1.getName().equals("Debt"))
                            return 1;
                        else
                            return e1.compareTo(e2);
                    })
                    .forEach(System.out::println);
            System.out.println("Total: $" + String.format("%,.02f", BudgetManager.totalSum));
        }
    }
}

class sortByType implements Analyze {
    @Override
    public void sort() {
        Map<String, BigDecimal> sortByType = new HashMap<>();
        sortByType.put("Food", BudgetManager.foodSum);
        sortByType.put("Entertainment", BudgetManager.entertainmentSum);
        sortByType.put("Clothes", BudgetManager.clothesSum);
        sortByType.put("Other", BudgetManager.otherSum);

        LinkedHashMap<String, BigDecimal> printSort = new LinkedHashMap<>();

        sortByType.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> printSort.put(x.getKey(), x.getValue()));

        System.out.println("\nTypes:");
        printSort.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + NumberFormat.getCurrencyInstance().format(entry.getValue()));
        });
        System.out.println("Total: $" + String.format("%,.02f", BudgetManager.totalSum));
    }
}

class sortCertainType implements Analyze {
    /*add all type to map and sort per method sortByType*/
    @Override
    public void sort() {
        Scanner scanner = new Scanner(System.in);
        Menu.printSortTypeMenu();
        String in = scanner.nextLine();
        String t = null;
        BigDecimal sumByType = new BigDecimal(0.00);
        Map<String, BigDecimal> certainType = new HashMap<>();
        switch (in) {
            case "1":
                t = "FOOD";
                sumByType = BudgetManager.foodSum;
                break;
            case "2":
                t = "CLOTHES";
                sumByType = BudgetManager.clothesSum;
                break;
            case "3":
                t = "ENTERTAINMENT";
                sumByType = BudgetManager.entertainmentSum;
                break;
            case "4":
                t = "OTHER";
                sumByType = BudgetManager.otherSum;
                break;
        }
        System.out.println();
        if (!BudgetManager.budgetList.containsKey(Item.Type.valueOf(t)))
            System.out.println("Purchase list is empty!");
        else {
            System.out.println(t + ": ");
            BudgetManager.budgetList
                    .get(Item.Type.valueOf(t))
                    .forEach(x -> certainType.put(x.getName(), x.getPrice()));
            LinkedHashMap<String, BigDecimal> printSort = new LinkedHashMap<>();

            certainType.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> printSort.put(x.getKey(), x.getValue()));

            printSort.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + NumberFormat.getCurrencyInstance().format(entry.getValue()));
            });

            System.out.println("Total sum: $" + String.format("%,.02f", sumByType));
        }
    }
}