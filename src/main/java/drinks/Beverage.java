package drinks;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;
import static drinks.util.Colors.*;

public class Beverage implements Drinkable {
    public final BeverageType drinkType;
    private final String basicIngredients;
    public List<IngredientType> ingredients = new ArrayList<IngredientType>();

    public Beverage(BeverageType drinkType) {
        this.drinkType = drinkType;
        this.basicIngredients = drinkType.getBasicIngredients();
    }

    public void addIngredients(IngredientType ingredientType) {
        ingredients.add(ingredientType);
    }

    @Override
    public String getDrink() {
        String temperature = getTemperature().toString().toLowerCase().replace("_", " ");
        return String
                .format(GREEN + "Order Name: %6s" + RESET +
                         YELLOW + "\nIngredients: %8s. " + RESET +
                         RED + "\nTemperature: %5s" + RESET +
                         BLUE + "\nBeverage Tips: %-8s" + RESET +
                         CYAN + "\n------------ Enjoy ------------" + RESET ,
                        drinkType.toString(),
                        getIngredients(),
                        capitalize(temperature),
                        getTips()
                );
    }

    public BeverageType getDrinkType() {
        return drinkType;
    }

    public BeverageTemperature getTemperature() {
        return BeverageTemperature.WARM;
    }

    public boolean hasExtras() {
        return !ingredients.isEmpty();
    }

    @Override
    public String getTips() {
        return "If Smart water is so smart then how did it get bottled?";
    }

    private String getIngredients() {
        StringBuilder message = new StringBuilder();
        if(ingredients.isEmpty()) {
            return basicIngredients;
        }

        if(ingredients.size() > 0) {
            message.append(basicIngredients);
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

}


