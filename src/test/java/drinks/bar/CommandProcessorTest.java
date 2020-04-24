package drinks.bar;

import drinks.Beverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    @DisplayName("Order cold")
    @Nested
    class GetOrder__and_Tips {

        @Test
        @DisplayName("Soda on the rocks.")
        void getSoda__onTheRocks() {
            CommandProcessor barman = new CommandProcessor(new CommandExtractor("Soda Ice"));
            Beverage beverage =  barman.getBeverage(); // prints menu

            assertEquals(BeverageType.Soda, beverage.getDrinkType());
            assertEquals(BeverageTemperature.EXTREMELY_COLD, beverage.getTemperature());
            assertTrue(beverage.hasExtras());
            //assertEquals("It's hot out here. Enjoy your drink.....",beverage.getDrink());


        }

        @Test
        @DisplayName("Soda")
        void getSoda() {
            CommandProcessor barman = new CommandProcessor(new CommandExtractor("Soda"));
            Beverage beverage =  barman.getBeverage(); // prints menu


            assertEquals(BeverageType.Soda, beverage.getDrinkType());
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
            assertFalse(beverage.hasExtras());
         //   assertEquals("It's hot out here. Enjoy your drink.....",beverage.getDrink());


        }
    }

}