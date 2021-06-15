package ordersystem;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

class Cart {
    private List<String> productsName = new LinkedList<>();
    private List<BigDecimal> productsPrice = new LinkedList<>();

    public void setProductsName(String productName) {
        this.productsName.add(productName);
    }

    public void setProductsFinalPrice(BigDecimal productsFinalPrice) {
        this.productsPrice.add(productsFinalPrice);
    }

    public boolean isCartEmpty(){
        return productsName.isEmpty();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for (BigDecimal x : productsPrice) {
            totalPrice = totalPrice.add(new BigDecimal(String.valueOf(x)));
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Your cart contains: " + productsName +
                "\nTotal price: " + productsPrice + " = " + getTotalPrice();
    }
}
