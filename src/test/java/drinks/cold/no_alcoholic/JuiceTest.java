package drinks.cold.no_alcoholic;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuiceTest {

    @Nested
    @DisplayName("When you order juice")
    class getJuice {
        @Test
        @DisplayName("with ice")
        void juiceWithIce() {
            ColdBeverage beverage = new Juice(BeverageType.Juice);
            beverage.addIngredients(IngredientType.Ice);

            assertTrue(beverage.hasIce());
            assertEquals(BeverageTemperature.EXTREMELY_COLD, beverage.getTemperature());
        }

        @Test
        @DisplayName("just just")
        void justJuice() {
            ColdBeverage beverage = new Juice(BeverageType.Juice);
            assertFalse(beverage.hasIce());
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
        }
    }

}