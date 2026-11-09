# Inventory Management System

A simple Java console-based inventory management system that allows you to manage products (add, remove, update, view) and persist data to a file.

## Features

- Add new products (ID, name, price, quantity)
- Remove products by ID
- Update existing product details
- View all products
- Check if a product ID exists
- Count total products
- Save inventory to `inventory.txt`
- Load inventory from `inventory.txt` on startup

## Technologies Used

- Java (JDK 8+)
- Java Collections (`ArrayList`)
- Java I/O (`BufferedReader`, `BufferedWriter`)

## Project Structure


## Data Format
The inventory.txt file stores each product on one line in the following format:
id, name, price, quantity
