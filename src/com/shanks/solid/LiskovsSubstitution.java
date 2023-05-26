package com.shanks.solid;

import java.util.List;

public class LiskovsSubstitution {

    /*
    * The principle defines that objects of a superclass shall be replaceable with
    * objects of its subclasses without breaking the application
    *
    * Here in this example we are passing the object of class PersistInvoiceToDatabase and PersistInvoiceToFile
    * to the method saveInvoice whereas the method signature defines it should receive an object of PersistInvoiceUtil
    * */
    public static void main(String[] args) {
        Invoice invoice = new Invoice(101, List.of(new Item("XYZ", 1024.98),
                new Item("ABC", 4082.76), new Item("PQR", 2982.14)));

        saveInvoice(new PersistInvoiceToDatabase(), invoice);
        saveInvoice(new PersistInvoiceToFile("C:\\file\\"), invoice);
    }

    private static void saveInvoice (PersistInvoiceUtil persistInvoiceUtil, Invoice invoice) {
        persistInvoiceUtil.save(invoice);
    }
}
