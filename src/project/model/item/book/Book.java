package project.model.item.book;

import project.model.item.LibraryItem;

public abstract class Book implements LibraryItem
{
    private final String title;
    private final String author;
    private final String isbn;
    private final int pages;

    public Book(String title, String author, String isbn, int pages)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String info() {
        return '"' + title + "\", " + author + " (strony: " + pages +", ISBN:" + isbn + ')';
    }
}
