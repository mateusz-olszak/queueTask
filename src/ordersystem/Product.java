package ordersystem;

import java.math.BigDecimal;
import java.util.Objects;

class Product {

    private final String cheeseburger = "cheeseburger";
    private final String fries = "fries";
    private final String shake = "shake";
    private final String coke = "coke";
    private final String taco = "taco";
    private final String icecream = "icecream";

    private final BigDecimal cheeseburger_price = BigDecimal.valueOf(4.99);
    private final BigDecimal fries_price = BigDecimal.valueOf(4.99);
    private final BigDecimal shake_price = BigDecimal.valueOf(5.50);
    private final BigDecimal coke_price = BigDecimal.valueOf(3.99);
    private final BigDecimal taco_price = BigDecimal.valueOf(8.99);
    private final BigDecimal icecream_price = BigDecimal.valueOf(10);

    public String getCheeseburger() {
        return cheeseburger;
    }

    public String getFries() {
        return fries;
    }

    public String getShake() {
        return shake;
    }

    public String getCoke() {
        return coke;
    }

    public String getTaco() {
        return taco;
    }

    public String getIcecream() {
        return icecream;
    }

    public BigDecimal getCheeseburger_price() {
        return cheeseburger_price;
    }

    public BigDecimal getFries_price() {
        return fries_price;
    }

    public BigDecimal getShake_price() {
        return shake_price;
    }

    public BigDecimal getCoke_price() {
        return coke_price;
    }

    public BigDecimal getTaco_price() {
        return taco_price;
    }

    public BigDecimal getIcecream_price() {
        return icecream_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(cheeseburger, product.cheeseburger) && Objects.equals(fries, product.fries) && Objects.equals(shake, product.shake) && Objects.equals(coke, product.coke) && Objects.equals(taco, product.taco) && Objects.equals(icecream, product.icecream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cheeseburger, fries, shake, coke, taco, icecream);
    }

    public String listMenu() {
        return "1. " + cheeseburger + " - " + cheeseburger_price +
                "\n2. " + fries + " - " + fries_price +
                "\n3. " + shake + " - " + shake_price +
                "\n4. " + coke + " - " + coke_price +
                "\n5. " + taco + " - " + taco_price +
                "\n6. " + icecream + " - " + icecream_price;
    }

}
