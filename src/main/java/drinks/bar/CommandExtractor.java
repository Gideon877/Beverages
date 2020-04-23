package drinks.bar;

import java.util.LinkedList;
import java.util.List;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class CommandExtractor {
        private final String drinkType;
        private List<IngredientType> extras;

        public CommandExtractor(String userInput) {
    //        Command :=> Tea Milk Sugar Ice Coffee
            String drinkType = (userInput.length() > 0) ? userInput.split(" ")[0] : "Water";
            this.drinkType = capitalize(drinkType);
            this.extras = getAddsOn(userInput);
        }

        private List<IngredientType> getAddsOn(String userInput) {
            List<IngredientType> mine = new LinkedList();
            String[] addOns = userInput.split(" ");
            for (int i = 1; i < addOns.length; i++) {
                try {
                    String extra = capitalize(addOns[i]);
                    mine.add(IngredientType.valueOf(extra));
                } catch (IllegalArgumentException e) {
    //                System.out.println("Wrong order");
                    // TODO: 2020/04/23 handle this exception
                }
            }
            return mine;
        }

    public List<IngredientType> getExtras() {
        return extras;
    }

    public BeverageType getDrinkType() {
            return BeverageType.valueOf(drinkType);
        }

        public boolean hasExtra(IngredientType ingredientType) {
            return extras.contains(ingredientType);
        }

}
