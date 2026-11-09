package org.inventory;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;


    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
        //setters
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name){
                this.name = name;
            }

        public void setPrice(double price){
                this.price = price;
        }

        public void setQuantity(int quantity){
                this.quantity = quantity;
        }


        //Getters
        public int getID(){
                return id;
            }

        public String getName(){
            return name;
            }

        public double getPrice(){
                return price;
            }

        public int getQuantity(){
            return quantity;
            }

        public String toString(){
                return "======= Product ID. (" + id +") =======\n"
                +"Product Name: " + name + "\n" + "Product Price: " + price + " $" + "\n" +
                "Product Quantity: " + quantity + " pcs" + "\n";
            }

    }
