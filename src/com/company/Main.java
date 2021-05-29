package com.company;

import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Product bigMac = new Product("BigMac", 16.99);
        Product cheeseburger = new Product("Cheeseburger", 4.99);
        Product fries = new Product("Fries", 4.99);
        Product shake = new Product("Shake", 6.50);
        Product mcFlurry = new Product("McFlurry", 5.99);
        Product mcHotDog = new Product("McHotDog", 14.99);
        Customer customer = null;
        for(int i=0; i<5; i++){
            customer = new Customer(i);
        }

//        Customer customer1 = new Customer(1);
//        Customer customer2 = new Customer(2);
//        Customer customer3 = new Customer(3);

        List<Product> products1 = new LinkedList<>();
        products1.add(bigMac);
        products1.add(fries);

        List<Product> products2 = new LinkedList<>();
        products2.add(shake);
        products2.add(mcFlurry);

        List<Product> products3 = new LinkedList<>();
        products3.add(cheeseburger);
        products3.add(shake);
        products3.add(mcHotDog);

        List<Product> products4 = new LinkedList<>();
        products4.add(shake);
        products4.add(fries);
        products4.add(fries);

        Order order1 = new Order(customer, products2);
        Order order2 = new Order(customer, products3);
        Order order3 = new Order(customer, products1);
        Order order4 = new Order(customer, products4);

        Deque<Order> orders = new ArrayDeque<>();

        orders.offer(order1);
        orders.offer(order2);
        orders.offer(order3);
        orders.offer(order4);

        orders.forEach(x -> System.out.println(x.toString()));

    }
}

class Order{

    private Customer customer;
    private List<Product> product;

    public Order(Customer customer, List<Product> product) {
        this.customer = customer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                '}';
    }
}

class Customer{

    private int recipeNumber;

    public Customer(int recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    public int getRecipeNumber() {
        return recipeNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "recipeNumber=" + recipeNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return recipeNumber == customer.recipeNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeNumber);
    }
}

class Product{

    private final String productName;
    private final double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
