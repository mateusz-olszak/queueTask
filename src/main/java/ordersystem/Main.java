package ordersystem;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Keypad keypad = new Keypad();
//        keypad.welcomeCustomer();

        Customer customer = new Customer();

        for(int i=0; i<30; i++){
            System.out.print(customer.toString());
        }

    }
}

