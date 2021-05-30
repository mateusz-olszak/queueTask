//package com.company;
package com.example.java.OrderSystem;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Keypad keypad = new Keypad();

        keypad.welcomeCustomer();

    }
}

class Keypad{

    private Scanner input = new Scanner(System.in);
    private Product product = new Product();
    private Cart cart = new Cart();
    private OrderSystem orderSystem = new OrderSystem();

    public void welcomeCustomer(){

        System.out.println("Hello in our brand new restaurant...\nPlease select an option below: ");
        System.out.print("menu - 1 | cart - 2 | close - 3\n: ");
        char choice = input.nextLine().charAt(0);

       if (validateWelcomeChoice(choice)) printOptions(choice);
       else welcomeCustomer();

    }

    public void printOptions(char choice){

        switch (choice){
            case '1':
                System.out.println(product.listMenu());
                System.out.println("-------------");
                System.out.print("Add to cart[1-6] or quit['q']: ");
                char optionMenu = input.nextLine().charAt(0);
                String productName;
                BigDecimal productPrice;


                if (validateMenuChoice(optionMenu) && optionMenu != 'q'){
                    switch (optionMenu){
                        case '1':
                                System.out.println("You picked cheeseburger");
                                productName = product.getCheeseburger();
                                productPrice = product.getCheeseburger_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;
                            case '2':
                                System.out.println("You picked fries");
                                productName = product.getFries();
                                productPrice = product.getFries_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;
                            case '3':
                                System.out.println("You picked shake");
                                productName = product.getShake();
                                productPrice = product.getShake_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;
                            case '4':
                                System.out.println("You picked coke");
                                productName = product.getCoke();
                                productPrice = product.getCoke_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;
                            case '5':
                                System.out.println("You picked taco");
                                productName = product.getTaco();
                                productPrice = product.getTaco_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;
                            case '6':
                                System.out.println("You picked icecream");
                                productName = product.getIcecream();
                                productPrice = product.getIcecream_price();
                                cart.setProductsName(productName);
                                cart.setProductsFinalPrice(productPrice);
                                printOptions(choice);
                                break;

                            default:
                                printOptions(choice);
                                break;

                    }
                }
                else welcomeCustomer();
                break;
            case '2':
                System.out.println("---------------------");
                System.out.println(cart.toString());
                System.out.println("Make an order['o'] or quit['q']: ");
                optionMenu = input.nextLine().charAt(0);
                switch (optionMenu){
                    case 'o':
                        Customer customer = new Customer();
                        Order order = new Order(customer,cart);
                        System.out.println("Your order:\n" + order);
                        OrderSystem.setOrders(order);
                        Keypad keypad = new Keypad();
                        keypad.welcomeCustomer();
                        break;
                    case 'q':
                        welcomeCustomer();
                        break;
                    default:
                        printOptions(choice);
                        break;
                }
                break;
            case '3':
                System.out.println(orderSystem.toString());;
                break;
        }
    }

    public boolean validateWelcomeChoice(char choice){
        if(choice == '1' || choice == '2' || choice == '3') return true;
        else return false;
    }

    public boolean validateMenuChoice(char choice){
        if(choice == '1' || choice == '2' || choice == '3' || choice == '4' || choice == '5' || choice == '6') return true;
        else return false;
    }

}


class Order{

    private Customer customer;
    private Cart cart;

    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", cart=" + cart.getProductNames() + ", price = " + cart.getTotalPrice().divide(BigDecimal.valueOf(2))+
                "}\n";
    }
}

class Customer{

    private int recipeNumber;
    private final Random random = new Random();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public Customer() {
        for(int i=0; i<15; i++){
            int num = random.nextInt(100)+1;
            if (!list.contains(num)) list.add(num);
        }
        recipeNumber = random.nextInt(list.size());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "recipeNumber=" + recipeNumber +
                '}';
    }
}

class Cart{
    private List<String> productsName = new LinkedList<>();
    private List<BigDecimal> productsPrice = new LinkedList<>();
    private BigDecimal totalPrice = new BigDecimal("0.00");

    public void setProductsName(String productName) {
        this.productsName.add(productName);
    }

    public void setProductsFinalPrice(BigDecimal productsFinalPrice) {
        this.productsPrice.add(productsFinalPrice);
    }

    public List<String> getProductNames() {
        return productsName;
    }

    public List<BigDecimal> getProductsPrice() {
        return productsPrice;
    }

    public BigDecimal getTotalPrice(){
        for (BigDecimal x : productsPrice){
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

class Product{

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

    public String listMenu(){
        return "1. " + cheeseburger + " - " + cheeseburger_price +
                "\n2. " + fries + " - " + fries_price +
                "\n3. " + shake + " - " + shake_price +
                "\n4. " + coke + " - " + coke_price +
                "\n5. " + taco + " - " + taco_price +
                "\n6. " + icecream + " - " + icecream_price;
    }

}

class OrderSystem{

    private static Deque<Order> orders = new ArrayDeque<>();

    public static void setOrders(Order order) {
        orders.offer(order);
    }

    public Deque<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "OrderSystem{" +
                "orders=" + orders +
                "}";
    }
}