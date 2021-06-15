package ordersystem;

import java.math.BigDecimal;
import java.util.Scanner;

class Keypad {

    private Scanner input = new Scanner(System.in);
    private Product product = new Product();
    private Cart cart = new Cart();
    private OrderSystem orderSystem = new OrderSystem();
    private Customer customer = new Customer();

    public void welcomeCustomer() {
        System.out.println("\nHello in our brand new restaurant...\nPlease select an option below: ");
        System.out.print("menu - 1 | cart - 2 | close - 3\n: ");
        char choice = input.nextLine().charAt(0);

        if (validateWelcomeChoice(choice)) printOptions(choice);
        else welcomeCustomer();

    }

    private void printOptions(char choice) {

        switch (choice) {
            case '1':                                       /// wyswietlanie produktow oraz mozliwosc dodania do koszyka
                System.out.println(product.listMenu());
                System.out.println("-------------");
                System.out.print("Add to cart[1-6] or quit['q']: ");
                char optionMenu = input.nextLine().charAt(0);

                switch (optionMenu) {
                    case '1':
                        printProducts(choice, product.getCheeseburger(), product.getCheeseburger_price());
                        break;
                    case '2':
                        printProducts(choice, product.getFries(), product.getFries_price());
                        break;
                    case '3':
                        printProducts(choice, product.getShake(), product.getShake_price());
                        break;
                    case '4':
                        printProducts(choice, product.getCoke(), product.getCoke_price());
                        break;
                    case '5':
                        printProducts(choice, product.getTaco(), product.getTaco_price());
                        break;
                    case '6':
                        printProducts(choice,  product.getIcecream(), product.getIcecream_price());
                        break;

                    default:
                        if (optionMenu == 'q') welcomeCustomer();
                        else printOptions(choice);
                        break;

                }
                break;
            case '2':                               /// sprawdzenie co znajduje sie w koszyku oraz mozliwosc zlozenia zamowienia
                if (!(cart.isCartEmpty())) {
                    System.out.println("---------------------");
                    System.out.println(cart.toString());
                    System.out.println("Make an order['o'] or quit['q']: ");
                    optionMenu = input.nextLine().charAt(0);
                    switch (optionMenu) {
                        case 'o':
                            printCartAndOrder();
                            break;
                        case 'q':
                            welcomeCustomer();
                            break;
                        default:
                            printOptions(choice);
                            break;
                    }
                } else {
                    System.out.println("Your cart does not contain any product. Go and pick one");
                    welcomeCustomer();
                }
                break;
            case '3':                                   /// zakonczenie sesji oraz wyswietlenie wszystkich zamowien
                System.out.println("\n###########################################\n"); //// po kolei w kolejce FIFO
                System.out.println(orderSystem.toString());
                if (orderSystem.getOrders().size() == 0) welcomeCustomer();
                orderSystem.getAnotherOrder();
                break;

            default:
                welcomeCustomer();
                break;
        }
    }

    private void printCartAndOrder() {
        Order order = new Order();
        order.setCart(cart);
//        order.setRecipeNumber(customer.generateRecipeNumber());
        System.out.println("Your order:\n" + order);
        orderSystem.setOrders(order);
        cart = new Cart();
        welcomeCustomer();
    }

    private void printProducts(char choice,String productName, BigDecimal productPrice) {
        System.out.println(productName);
        cart.setProductsName(productName);
        cart.setProductsFinalPrice(productPrice);
        printOptions(choice);
    }

    private boolean validateWelcomeChoice(char choice) {
        return choice == '1' || choice == '2' || choice == '3';
    }

}
