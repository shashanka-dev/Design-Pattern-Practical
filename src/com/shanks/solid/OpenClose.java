package com.shanks.solid;

/*
* Modification means changing the code of an existing class, and extension means adding new functionality
*
* Suppose we got a new requirement for adding a functionality to persist the Invoice
*
* So to comply with Single Responsibility principle we have created a new class
*
* class PersistInvoice {
    private final Invoice invoice;

    public PrintUtil(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save (String fileName) {
        //logic to save invoice
    }

}
* After designing the class we got another change to save it to database also along with the existing functionality
* That's why we have to make our code more extensible and there should be no change with the existing code
* This approach will eliminate possible bug due to the code change
* */

import java.util.List;

public class OpenClose {

    public static void main(String[] args) {
        Invoice invoice = new Invoice(101, List.of(new Item("XYZ", 1024.98),
                new Item("ABC", 4082.76), new Item("PQR", 2982.14)));

        PrintUtil printUtil = new PrintUtil(invoice);
        printUtil.print();

        PersistInvoiceToDatabase invoiceToDatabase = new PersistInvoiceToDatabase();
        invoiceToDatabase.save(invoice);

        PersistInvoiceToFile invoiceToFile = new PersistInvoiceToFile("C:\\file\\");
        invoiceToFile.save(invoice);
    }
}

interface PersistInvoiceUtil {
    void save (Invoice invoice);
}

class PersistInvoiceToDatabase implements PersistInvoiceUtil{

    @Override
    public void save(Invoice invoice) {
        System.out.println("Invoice saved in database");
    }
}

class PersistInvoiceToFile implements PersistInvoiceUtil{
    private final String fileLocation;

    PersistInvoiceToFile(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public void save(Invoice invoice) {
        System.out.println("Invoice saved at the location: "+this.fileLocation);
    }
}
