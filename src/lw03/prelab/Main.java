package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> playlist = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File("C:\\Users\\rifqy\\OneDrive\\Dokumen\\GitHub\\dsa-5026251088\\src\\lw03\\prelab\\playlist.txt"));
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (line.isEmpty()) continue;
                
                String[] p = line.split(" ", 2);
                if (p[0].equals("ADD")) {
                    playlist.add(p[1]);
                } else if (p[0].equals("INSERT")) {
                    String[] sub = p[1].split(" ", 2);
                    playlist.add(Integer.parseInt(sub[0]), sub[1]);
                } else if (p[0].equals("REMOVE")) {
                    playlist.remove(p[1]);
                }
            }
            s.close();
        } catch (FileNotFoundException ignored) {}

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();

        Set<String> participants = new LinkedHashSet<>();
        int dupCount = 0;
        try {
            Scanner s = new Scanner(new File("C:\\Users\\rifqy\\OneDrive\\Dokumen\\GitHub\\dsa-5026251088\\src\\lw03\\prelab\\participants.txt"));
            while (s.hasNextLine()) {
                String name = s.nextLine().trim();
                if (name.isEmpty()) continue;
                
                if (!participants.add(name)) {
                    dupCount++;
                }
            }
            s.close();
        } catch (FileNotFoundException ignored) {}

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int idx = 1;
        for (String p : participants) {
            System.out.println(idx + ". " + p);
            idx++;
        }
        System.out.println("Duplicate registrations: " + dupCount);
        System.out.println();

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        try {
            Scanner s = new Scanner(new File("C:\\Users\\rifqy\\OneDrive\\Dokumen\\GitHub\\dsa-5026251088\\src\\lw03\\prelab\\inventory.txt"));
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] p = line.split(" ");
                if (p.length < 3) continue;
                String type = p[0];
                String prod = p[1];
                int qty = Integer.parseInt(p[2]);

                if (type.equals("ADD")) {
                    inventory.put(prod, inventory.getOrDefault(prod, 0) + qty);
                } else if (type.equals("SELL")) {
                    if (inventory.containsKey(prod) && inventory.get(prod) >= qty) {
                        inventory.put(prod, inventory.get(prod) - qty);
                    } else {
                        failedSales++;
                    }
                }
            }
            s.close();
        } catch (FileNotFoundException ignored) {}

        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}