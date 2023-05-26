package com.shanks.practice;

import java.util.List;
import java.util.stream.Collectors;

public class Quantiphi {
/*"Input
        [{
        name: ""Book 1"",   currency: ""USD"",  price: 10 }, {
        name: ""Book 2"",  currency: ""INR"",  price: 500 }, {
        name: ""Book 3"",  currency: ""KWD"",  price: 5,
    }]

    Output
[{
        name: ""Book 1"",  price: """"700 INR"" }, {
  name: ""Book 2"",  price: """"500 INR"" }, {
        name: ""Book 3"",  price: """"1250 INR""
}]"*/
    public static void main(String[] args) {
        List<Book> listOfBooks = new Quantiphi().getBooks();

        List<BookResponse> bookResponses = new Quantiphi().getBookResponse(listOfBooks);

    }
    private List<BookResponse> getBookResponse (List<Book> listOfBooks) {
        List<BookResponse> bookResponses = listOfBooks.stream().map(book -> {
            double price = 0;
            if(book.currency.equals("USD")) {
                price = book.price * 83;
            }

            return new BookResponse(book.name, price);
        }).collect(Collectors.toList());
        return bookResponses;
    }

    private List<Book> getBooks () {
        return List.of(new Book("Book 1","USD", 10D));
    }
    //ORM mapping
    class Book {
        String name;
        String currency;
        double price;

        public Book(String name, String currency, double price) {
            this.name = name;
            this.currency = currency;
            this.price = price;
        }
    }

    class BookResponse {
        String name;
        double price;

        public BookResponse(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }
}
