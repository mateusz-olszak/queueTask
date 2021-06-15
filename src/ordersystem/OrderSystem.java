package ordersystem;

import java.util.ArrayDeque;
import java.util.Deque;

class OrderSystem {

    private static Deque<Order> orders = new ArrayDeque<>();

    public static void setOrders(Order order) {
        orders.offer(order);
    }

    public Deque<Order> getOrders() {
        return orders;
    }

    public void getAnotherOrder() {
        for (Order tempOrder : orders) {
            System.out.println("\nAnother order in the queue is: ");
            tempOrder = orders.poll();
            System.out.println(tempOrder);
        }
    }

    @Override
    public String toString() {
        return "\nOrderSystem{" +
                "orders=" + orders +
                "}";
    }
}
