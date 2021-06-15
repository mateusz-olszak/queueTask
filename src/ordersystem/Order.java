package ordersystem;

import java.util.Objects;

class Order {

    private Cart cart;
    private int recipeNumber;

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public void setRecipeNumber(int recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart);
    }

    @Override
    public String toString() {

        return "Order{" +
                "recipeNumber=" + recipeNumber +
                ", cart=" + cart +
                '}';
    }
}
