package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;

        do {
            System.out.println("Lütfen seçiminizi yapınız. (0 - Çıkış Yap, 1 - Ekle, 2 - Çıkar)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Neler eklemek istersiniz?");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Neleri çıkarmak istersiniz?");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }
        while (choice != 0);
        scanner.close();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems = itemsToRemove.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede mevcut değil.");
            }
        }
        sortItems();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitItems = itemsToAdd.split(",");
        for (String item : splitItems) {
            item = item.trim();
            if (checkItemsInList(item)) {
                System.out.println(item + " listede zaten mevcut.");
            } else {
                groceryList.add(item);
            }
        }
        sortItems();
    }

    public static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Pazar listesindekiler");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void sortItems(){
        Collections.sort(groceryList);
    }
}
