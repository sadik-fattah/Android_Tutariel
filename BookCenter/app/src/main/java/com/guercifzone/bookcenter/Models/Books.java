package com.guercifzone.bookcenter.Models;

public class Books {
    String book_name;
    String book_link;
    String book_type;
    String book_image;

    public Books() {
    }

    public Books(String book_name, String book_link, String book_type, String book_image) {
        this.book_name = book_name;
        this.book_link = book_link;
        this.book_type = book_type;
        this.book_image = book_image;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_link() {
        return book_link;
    }

    public void setBook_link(String book_link) {
        this.book_link = book_link;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }
}
