package org.inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        manager.loadFromFile();

        boolean running = true;
        while (running) {
            System.out.println("==== welcome to Invenatory Manager ====");
            System.out.println("Choose an Option: ");
            System.out.println("1. Add Product: ");
            System.out.println("2. remove Product: ");
            System.out.println("3. All Products: ");
            System.out.println("4. Update a Product: ");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int n = scanner.nextInt();
            scanner.nextLine(); // <--- السطر ده هو الحل، بياكل الـ Enter العالق

            switch (n) {
                case 1:
                    System.out.println("==== Add Product ====");

                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    while(name.contains(",")){
                        System.out.println("Name contains unsupported character ','");
                        System.out.print("Name: ");
                        name = scanner.nextLine();
                    }

                    System.out.println("ID: ");
                    int id = scanner.nextInt();
                    while (manager.checkID(id)) {
                        System.out.println("Used ID, try again!");
                        System.out.println("ID: ");
                        id = scanner.nextInt();
                    }


                    System.out.println("Price: ");
                    double price = scanner.nextDouble();

                    System.out.println("Quantity: ");
                    int quantity = scanner.nextInt();

                    Product myProduct = new Product(id, name, price, quantity);
                    manager.addProduct(myProduct);

                    System.out.println("Product added!");
                    System.out.println("You have " + manager.count() + " elements");
                    break;
                case 2:
                    System.out.println("==== Remove Product by ID ====");
                    System.out.println("Enter ID: ");
                    int removedId = scanner.nextInt();
                    if(!manager.checkID(removedId)){
                        System.out.println("ID doesn't exist");
                    }
                    else{
                        manager.removeProduct(removedId);
                        System.out.println("Product is removed");
                        System.out.println("You have " + manager.count() + " elements");

                    }

                    break;

                case 3:
                    if (manager.count() == 0)
                        System.out.println("No Items!!");

                    else
                        manager.displayAll();
                    break;

                case 4:
                    System.out.println("Enter Product's ID: ");
                    int updatedId = scanner.nextInt();
                    scanner.nextLine();
                    if(!manager.checkID(updatedId)){
                        System.out.println("ID doesn't exist");
                    }
                    else{
                        System.out.println("Name: ");
                        String updatedName = scanner.nextLine();
                        while(updatedName.contains(",")){
                            System.out.println("Name contains unsupported character ','");
                            System.out.print("Name: ");
                            updatedName = scanner.nextLine();
                        }

                        System.out.println("Price: ");
                        double updatedPrice = scanner.nextDouble();

                        System.out.println("Quantity: ");
                        int updatedQuantity = scanner.nextInt();

                        manager.updateProduct(updatedId, updatedName, updatedPrice, updatedQuantity);
                        System.out.println("Done!");

                    }


                    break;



                case 5:
                    manager.saveToFile();
                    running = false;
                    System.out.println("Goodbye");
                    break;


                default:
                    System.out.println("Not Valid");

            }
        }


    }
}
