package ordersystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Customer {

    public List<Integer> generateRecipeNumber(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()!=50){
            int num = random.nextInt(100)+1;
            if (!list.contains(num))
                list.add(num);
        }

        return list;
    }
}
