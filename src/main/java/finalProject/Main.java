package finalProject;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        List<Laptop> catalog = new CopyOnWriteArrayList<>();
        catalog.add(new Laptop(1, 8, 240, "Windows", "Black"));
        catalog.add(new Laptop(2, 16, 512, "MacOS", "Silver"));
        catalog.add(new Laptop(3, 8, 240, "Windows", "White"));
        catalog.add(new Laptop(4, 16, 512, "Linux", "Gold"));
        catalog.add(new Laptop(5, 32, 1024, "MacOS", "Black"));
        catalog.add(new Laptop(6, 64, 2048, "Linux", "Red"));
        System.out.println("Enter sort option");
        System.out.println("1 - RAM");
        System.out.println("2 - SSD");
        System.out.println("3 - OS");
        System.out.println("4 - Color");
        Scanner sc = new Scanner(System.in,"ibm866");
        int option = sc.nextInt();
        List<Laptop> finalCatalog = toFilter(option, catalog);
        toPrint(finalCatalog);

    }
    public static List<Laptop> toFilter(int option, List<Laptop> catalog){
        Scanner sc = new Scanner(System.in,"ibm866");
        List<Laptop> filteredCatalog = new CopyOnWriteArrayList<>();
        if (option == 1) {
            System.out.print("Enter the amount of RAM: ");
            int filterRam = sc.nextInt();
            for(Laptop l : catalog) {
                if (l.ram >= filterRam) {
                    filteredCatalog.add(l);
                }
            }
            return filteredCatalog;
        } else if (option == 2) {
            System.out.print("Enter the amount of SSD: ");
            int filterSSD = sc.nextInt();
            for(Laptop l : catalog) {
                if (l.ssd >= filterSSD) {
                    filteredCatalog.add(l);
                }
            }
            return filteredCatalog;
        } else if (option == 3) {
            System.out.print("Enter the amount of OS (Windows, Linux or MacOS): ");
            String filterOS = sc.next();
            for(Laptop l : catalog) {
                if (Objects.equals(l.os, filterOS)) {
                    filteredCatalog.add(l);
                }
            }
            return filteredCatalog;
        } else if (option == 4) {
            System.out.print("Enter the color (Black, Silver, White, Red, Gold): ");
            String filterColor = sc.next();
            for(Laptop l : catalog) {
                if (Objects.equals(l.color, filterColor)) {
                    filteredCatalog.add(l);
                }
            }
            return filteredCatalog;
        } else {
            return new CopyOnWriteArrayList<>();
        }
    }

    public static void toPrint (List<Laptop> catalog) {
        System.out.println("Filtered list of laptops: ");
        for (Laptop laptop : catalog) {
            System.out.println(laptop);
        }
    }
}
