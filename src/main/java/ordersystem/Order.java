package ordersystem;

import java.util.Objects;

class Order {

    private Customer customer;
    private Cart cart;

    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) && Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, cart);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", cart=" + cart +
                '}';
    }
}
