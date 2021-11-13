package budget;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BudgetManager implements Serializable {
    static boolean isRunning = true;
    static BigDecimal income = new BigDecimal(BigInteger.ZERO);
    static Map<Item.Type, ArrayList<Item>> budgetList = new HashMap<>();
    static BigDecimal foodSum = new BigDecimal(0.00);
    static BigDecimal clothesSum = new BigDecimal(0.00);
    static BigDecimal entertainmentSum = new BigDecimal(0.00);
    static BigDecimal otherSum = new BigDecimal(0.00);
    static BigDecimal totalSum = new BigDecimal(0.00);

    public BudgetManager() {
        Run.run();
    }

    static void exit() {
        System.out.println("\nBye!");
        isRunning = false;
    }
}