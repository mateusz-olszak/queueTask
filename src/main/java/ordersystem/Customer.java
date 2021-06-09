package ordersystem;

import java.util.ArrayList;
import java.util.Random;

class Customer {

    private int recipeNumber;

    private int generateRecipeNumber(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int num = random.nextInt(100) + 1;

        if (!list.contains(num)) list.add(num);
        else list.add(generateRecipeNumber());

        int index = random.nextInt(list.size());

        recipeNumber = list.get(index);

        return recipeNumber;
    }

    @Override
    public String toString() {
        return generateRecipeNumber() + ", ";
//        return "Customer{" +
//                "recipeNumber=" + generateRecipeNumber() +
//                '}';
    }
}
