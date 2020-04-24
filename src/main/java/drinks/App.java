package drinks;

import drinks.bar.BeverageType;
import drinks.bar.CommandExtractor;
import drinks.bar.CommandProcessor;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import drinks.hot.HotBeverage;
import java.util.Scanner;

/**
 * todo: create a menu, command extractor, output display
 * date: 22 Apr 2020
 * author: TG Magaola
 * */

public class App {

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public static void main(String[] args) {
        System.out.println("Thee Bev Bar");


        boolean start = true;
        while (start) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter command to order: ");
            String command = scanner.nextLine();
            if (command.equals("exit") || command.startsWith("exit")) {
                start = false;
                return;
            }
//
            Beverage beverage = new CommandProcessor(new CommandExtractor(command)).getBeverage();

            System.out.println("Preparing your beverage. This might take 1s");
            setTimeout(() -> System.out.println("Your order is done. Below is beverage info:\n\n" + beverage.getDrink()), 100);
            return;
        }

    }
}
