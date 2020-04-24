package drinks.cold.alcoholic;

import drinks.bar.BeverageType;

import static drinks.util.Colors.*;

public class Beer extends AlcoholicBeverage {
    public Beer(BeverageType drinkType) {
        super(drinkType);
    }
    @Override
    public String getTips() {
        return  "What did the man with slab of asphalt under his arm order? \"A beer please, and one for the road.\"\n" + RED_BRIGHT +
        super.getTips()  + RESET;
    }

}
