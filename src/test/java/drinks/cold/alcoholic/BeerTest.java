package drinks.cold.alcoholic;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeerTest {

    @Nested
    @DisplayName("When you order beer")
    class getBeers {
        @Test
        @DisplayName("with ice")
        void beerWithIce() {
            ColdBeverage beverage = new Beer(BeverageType.Beer);
            beverage.addIngredients(IngredientType.Ice);

            assertTrue(beverage.hasIce());
            assertEquals(BeverageTemperature.EXTREMELY_COLD, beverage.getTemperature());
            assertEquals("What did the man with slab of asphalt under his arm order? \"A beer please, and one for the road.\"", beverage.getTips());
        }

        @Test
        @DisplayName("just beer")
        void justBeer() {
            ColdBeverage beverage = new Beer(BeverageType.Beer);
            assertFalse(beverage.hasIce());
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
        }
    }

}