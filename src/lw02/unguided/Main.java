package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> successful = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        // Stock
        foods.add(new String[] { "Bakso", "2" });
        foods.add(new String[] { "Sate", "1" });
        foods.add(new String[] { "Soto", "2" });

        drinks.add(new String[] { "EsTeh", "4" });
        drinks.add(new String[] { "EsJeruk", "2" });

        // Read file
        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("orders.txt")
        );

        while (scanner.hasNext()) {
            String[] order = new String[4];
            order[0] = scanner.next();
            order[1] = scanner.next();
            order[2] = scanner.next();
            order[3] = scanner.next();
            orders.add(order);
        }

        scanner.close();

        queue.addAll(orders);

        // FIFO
        while (!queue.isEmpty()) {
            String[] order = queue.poll();

            String[] food = null;
            String[] drink = null;

            for (String[] f : foods) {
                if (f[0].equals(order[1])) {
                    food = f;
                }
            }
            for (String[] d : drinks) {
                if (d[0].equals(order[2])) {
                    drink = d;
                }
            }

            boolean foodOk = order[1].equals("-")
                    || (food != null && Integer.parseInt(food[1]) > 0);
            boolean drinkOk = order[2].equals("-")
                    || (drink != null && Integer.parseInt(drink[1]) > 0);

            if (foodOk && drinkOk) {
                if (food != null) {
                    food[1] = String.valueOf(Integer.parseInt(food[1]) - 1);
                }
                if (drink != null) {
                    drink[1] = String.valueOf(Integer.parseInt(drink[1]) - 1);
                }
                successful.add(order);
            } else {
                failed.push(order);
            }
        }

        // Output
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : successful) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] food : foods) {
            System.out.println(food[0] + " : " + food[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] drink : drinks) {
            System.out.println(drink[0] + " : " + drink[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}