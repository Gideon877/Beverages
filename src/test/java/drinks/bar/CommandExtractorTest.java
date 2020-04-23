package drinks.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Nested
    @DisplayName("Out of the blue")
    class Not_WIld__Enough {

        @DisplayName("Empty order")
        @Test
        void getNothing() {
            Assertions.assertFalse(new CommandExtractor("").hasExtra(IngredientType.Milk));
            assertFalse(new CommandExtractor("").hasExtra(IngredientType.Ice));
            assertFalse(new CommandExtractor("").hasExtra(IngredientType.Sugar));

            assertNotEquals(BeverageType.Tea, new CommandExtractor("").getDrinkType());
            assertEquals(BeverageType.Water, new CommandExtractor("").getDrinkType()); // Water on the House
            assertNotEquals(BeverageType.Juice, new CommandExtractor("").getDrinkType());
            assertNotEquals(BeverageType.Beer, new CommandExtractor("").getDrinkType());
            assertNotEquals(BeverageType.Spirit, new CommandExtractor("").getDrinkType());
            assertNotEquals(BeverageType.Coffee, new CommandExtractor("").getDrinkType());
            assertNotEquals(BeverageType.Soda, new CommandExtractor("").getDrinkType());
        }

        @DisplayName("Wrong order")
        @Test
        void getWaiting_Period__() {
            assertFalse(new CommandExtractor("milk").hasExtra(IngredientType.Milk));
            assertFalse(new CommandExtractor("ice").hasExtra(IngredientType.Ice));
            assertFalse(new CommandExtractor("sugar").hasExtra(IngredientType.Sugar));

//            The following order Beverage type should not be tea. The Beverage type is coffee
            assertNotEquals(BeverageType.Tea, new CommandExtractor("coffee tea").getDrinkType());
//            This will pass as the first keyword represent beverage type
            assertEquals(BeverageType.Coffee, new CommandExtractor("coffee tea").getDrinkType());
        }

        @Test
        @DisplayName("Go wild and order something mad-ish")
        void getHangover () {
            String command = "spirit ice milk sugar";

            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Spirit, commandExtractor.getDrinkType());
            assertTrue(commandExtractor.hasExtra(IngredientType.Milk));
            assertTrue(commandExtractor.hasExtra(IngredientType.Sugar));
            assertTrue(commandExtractor.hasExtra(IngredientType.Ice));

        }
    }

    @Nested
    @DisplayName("Order hot")
    class getHotBeverage {

        @DisplayName("neat tea")
        @Test
        void getTea() {
            String command = "tea";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Tea, commandExtractor.getDrinkType());
            assertFalse(commandExtractor.hasExtra(IngredientType.Milk));
            assertFalse(commandExtractor.hasExtra(IngredientType.Sugar));
        }

        @DisplayName("tea with milk")
        @Test
        void getWhiteTea() {
            String command = "tea milk";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Tea, commandExtractor.getDrinkType());
            assertTrue(commandExtractor.hasExtra(IngredientType.Milk));
            assertFalse(commandExtractor.hasExtra(IngredientType.Sugar));
        }

        @DisplayName("tea with sugar and milk")
        @Test
        void getWhiteTeaWithSugar() {
            String command = "tea milk sugar";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Tea, commandExtractor.getDrinkType());
            assertTrue(commandExtractor.hasExtra(IngredientType.Milk));
            assertTrue(commandExtractor.hasExtra(IngredientType.Sugar));
        }

    }

    @Nested
    @DisplayName("Order cold")
    class getColdBeverage {

        @DisplayName("soda")
        @Test
        void getSoda() {
            String command = "soda";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Soda, commandExtractor.getDrinkType());
            assertFalse(commandExtractor.hasExtra(IngredientType.Ice));
        }

        @DisplayName("soda with ice")
        @Test
        void getSoda__OnTheRocks() {
            String command = "soda ice";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Soda, commandExtractor.getDrinkType());
            assertTrue(commandExtractor.hasExtra(IngredientType.Ice));
        }

        @DisplayName("spirit with ice")
        @Test
        void getSpirit__OnTheRocks() {
            String command = "spirit ice";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Spirit, commandExtractor.getDrinkType());
            assertTrue(commandExtractor.hasExtra(IngredientType.Ice));
        }

        @DisplayName("beer without ice")
        @Test
        void getNeatSpirit() {
            String command = "beer";
            CommandExtractor commandExtractor = new CommandExtractor(command);

            assertEquals(BeverageType.Beer, commandExtractor.getDrinkType());
            assertFalse(commandExtractor.hasExtra(IngredientType.Ice));
        }

    }

}