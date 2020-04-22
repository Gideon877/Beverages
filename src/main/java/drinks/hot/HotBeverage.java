package drinks.hot;
import drinks.Beverage;
import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static drinks.bar.IngredientType.*;

public class HotBeverage extends Beverage {

    public HotBeverage(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public void addIngredients(IngredientType ingredientType) {
        super.addIngredients(ingredientType);
    }

    @Override
    public String getDrinkTips() {
        return String.format("This %s is made of %s.", drinkType.toString(), getIngredients());
    }

    @Override
    public boolean hasExtras() {
        return super.hasExtras();
    }

    @Override
    public BeverageTemperature getTemperature() {
        System.out.println(ingredients.contains(Milk));
        if(hasMilk()) {
            return BeverageTemperature.WARM;
        }
        return BeverageTemperature.HOT;
    }

    private String getIngredients() {
        StringBuilder message = new StringBuilder();

        if(drinkType.equals(BeverageType.Tea)) {
            if(ingredients.isEmpty()) {
                return "water and teabag";
            }

            if(ingredients.size() > 0) {
                message.append("water, teabag");
            }
        }

        if(drinkType.equals(BeverageType.Coffee)) {
            if(ingredients.isEmpty()) {
                return "water and coffee beans";
            }

            if(ingredients.size() > 0) {
                message.append("water, coffee beans");
            }
        }


        if(ingredients.size() == 1) {
            message.append(" and ");
            message.append(ingredients.get(0).toString().toLowerCase());
            return message.toString();
        }

        for (int i = 0; i < ingredients.size(); i++) {
            if((ingredients.size() - i) != 1) {
                message.append(", ");
            }
            if((ingredients.size() - i) == 1) {
                message.append(" and ");
            }
            message.append(ingredients.get(i).toString().toLowerCase());
        }
        return message.toString();
    }

    public boolean hasMilk() {
        return ingredients.contains(Milk);
    }

    public boolean hasSugar() {
        return ingredients.contains(Sugar);
    }

}
