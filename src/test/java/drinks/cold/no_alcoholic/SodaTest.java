package drinks.cold.no_alcoholic;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SodaTest {

    @Nested
    @DisplayName("When you order soda")
    class getSoda {
        @Test
        @DisplayName("with ice")
        void sodaWithIce() {
            ColdBeverage beverage = new Soda(BeverageType.Soda);
            beverage.addIngredients(IngredientType.Ice);

            assertTrue(beverage.hasIce());
            assertEquals(BeverageTemperature.EXTREMELY_COLD, beverage.getTemperature());
        }

        @Test
        @DisplayName("just soda")
        void justSoda() {
            ColdBeverage beverage = new Soda(BeverageType.Soda);
            assertFalse(beverage.hasIce());
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
        }
    }

}