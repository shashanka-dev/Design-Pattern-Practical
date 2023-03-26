package com.shanks.solid;

import java.util.List;
import java.util.stream.Collectors;

/*
 * A class must have only one responsibility and there should be only one reason for change
 * Let's consider below example
 *
 * class Item {
 *   int id;
 *   String name;
 *   double price;
 * }
 *
 * class Invoice {
 *   int id;
 *   List<Items> items;
 *
 *   public double getTotalAmount () {};
 *   public void print () {}
 *   public void save () {}
 * }
 *
 * Here if we will see print and save method might change if some requirement changes
 * But Invoice class should change only when getTotalAmount() logic get changed
 * So ideal design should be...
 * */

class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}

class Invoice {
    private final int id;
    private final List<Item> items;

    public Invoice(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<String> getItemNames() {
        return this.items.stream().map(Item::getName).collect(Collectors.toList());
    }

    public double getTotalAmount() {
        return this.items.stream().mapToDouble(Item::getPrice).sum();
    }
}

/*
* Here we have taken out the responsibility of printing from Invoice class
* Now it is the responsibility PrintUtil class to take care of it
* */
class PrintUtil {
    private final Invoice invoice;

    public PrintUtil(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print () {
        System.out.println("Invoice id: "+this.invoice.getId());
        System.out.println("Invoice Names: "+this.invoice.getItemNames());
        System.out.println("Total amount: "+this.invoice.getTotalAmount());
    }
}

public class SingleResponsibility {

    public static void main(String[] args) {
        Item item1 = new Item("XYZ", 1024.98);
        Item item2 = new Item("ABC", 4082.76);
        Item item3 = new Item("PQR", 2982.14);

        Invoice invoice = new Invoice(101, List.of(item1, item2, item3));

        PrintUtil printUtil = new PrintUtil(invoice);
        printUtil.print();
    }
}

