package budget;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final BigDecimal price;
    private final Type type;

    public Item(String name, BigDecimal price, Type t) {
        this.name = name;
        this.price = price;
        this.type = t;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " $" + String.format("%,.02f", price);
    }

    public int compareTo(Item e) {
        return e.price.compareTo(this.price);
    }

    public enum Type {
        FOOD("Food"),
        CLOTHES("Clothes"),
        ENTERTAINMENT("Entertainment"),
        OTHER("Other");

        public final String name;

        Type(String name) {
            this.name = name;
        }
    }
}