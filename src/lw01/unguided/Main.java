package lw01.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\rifqy\\OneDrive\\Dokumen\\GitHub\\dsa-5026251088\\src\\lw01\\unguided\\washes.txt"));

            int total = fileScanner.nextInt();
            WashService[] washes = new WashService[total];
            int[] unitsPerOrder = new int[total];

            for (int i = 0; i < total; i++) {
                String type = fileScanner.next();
                String id = fileScanner.next();
                int days = fileScanner.nextInt();
                int units = fileScanner.nextInt();

                if(type.equals("MOTORCYCLE")) {
                    washes[i] = new MotorcycleWash(id, days);
                } else if(type.equals("CAR")) {
                    washes[i] = new CarWash(id, days);
                }

                unitsPerOrder[i] = units;
            }

            fileScanner.close();

            for (int i = 0; i < washes.length; i++) {
                WashService wash = washes[i];
                System.out.println(wash.getId() + " | " + wash.label() + " | "
                        + wash.calculateCharge(unitsPerOrder[i]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("washes.txt not found.");
        }
    }
}