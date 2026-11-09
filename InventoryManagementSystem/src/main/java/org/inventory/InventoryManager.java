package org.inventory;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class InventoryManager {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == id) {
                products.remove(i);
                break;
            }
        }
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("inventory.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                buffer.write(p.getID() + ", " + p.getName() + ", " + p.getPrice() + ", " + p.getQuantity());
                buffer.newLine();
            }
            buffer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void loadFromFile() {
        try { // نكتب الاوبجكت بتاع الملف و المؤشر جوا try عشان ممكن يحصلهم exception
            FileReader reader = new FileReader("inventory.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            products.clear(); // عشان لو اتنادت أكتر من مرة، مفيش تكرار
            String line = bufferedReader.readLine();
            while(line!= null){ //بتقرأ الملف سطر سطر و ترجعه ع صورة .readLine() >> String
                String [] data = line.split(","); // لأننا مش عارفين عدد السطور الموجودة في الملف، نستخدم while.
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double price = Double.parseDouble(data[2].trim());
                int quantity = Integer.parseInt(data[3].trim());
                Product p = new Product(id, name, price, quantity);
                products.add(p);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        }


        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAll() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public int count() {
        return products.size();
    }

    public boolean checkID(int id) {
        for (Product product : products) {
            if (product.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public void updateProduct(int updatedId, String updatedName, double updatedPrice, int updatedQuantity) {
        for (Product product : products) {
            if (product.getID() == updatedId) {
                product.setName(updatedName);
                product.setPrice(updatedPrice);
                product.setQuantity(updatedQuantity);
                break;
            }
        }
    }
}
