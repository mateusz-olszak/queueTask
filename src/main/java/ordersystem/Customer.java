package ordersystem;

import java.util.ArrayList;
import java.util.Random;

class Customer {

    public int generateRecipeNumber(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()!=50){
            int num = random.nextInt(100)+1;
            if (!list.contains(num))
                list.add(num);
        }

        int index = random.nextInt(list.size());
        int recipeNumber= list.get(index);



        return recipeNumber;
    }
}
