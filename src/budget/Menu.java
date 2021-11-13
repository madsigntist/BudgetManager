package budget;

public class Menu {
    static void printMenu() {
        System.out.println(
                "\nChoose your action:\n" +
                        "1) Add income\n" +
                        "2) Add purchase\n" +
                        "3) Show list of purchases\n" +
                        "4) Balance\n" +
                        "5) Save\n" +
                        "6) Load\n" +
                        "7) Analyze (Sort)\n" +
                        "0) Exit");
    }

    static void printCategoryMenu() {
        System.out.println(
                "\nChoose the type of purchase\n" +
                        "1) Food\n" +
                        "2) Clothes\n" +
                        "3) Entertainment\n" +
                        "4) Other\n" +
                        "5) Back"
        );
    }

    static void printPurchaseListMenu() {
        System.out.println(
                "\nChoose the type of purchases\n" +
                        "1) Food\n" +
                        "2) Clothes\n" +
                        "3) Entertainment\n" +
                        "4) Other\n" +
                        "5) All\n" +
                        "6) Back");
    }

    static void printSortMenu() {
        System.out.println(
                "\nHow do you want to sort?\n" +
                "1) Sort all purchases\n" +
                "2) Sort by type\n" +
                "3) Sort certain type\n" +
                "4) Back");
    }

    static void printSortTypeMenu() {
        System.out.println(
                "\nChoose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other");
    }
}
