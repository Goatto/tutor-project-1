package project.model.item.book;

import project.model.item.Author;
import project.model.item.Authored;
import project.model.item.LibraryItem;

import java.util.List;

public abstract class Book implements LibraryItem, Authored
{
    private final String title;
    private final List<Author> authors;
    private final String isbn;
    private final int pages;

    @Override
    public String getTitle() {
        return this.title;
    }

    public List<Author> getAuthors()
    {
        return this.authors;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public int getPages()
    {
        return this.pages;
    }

    public Book(String title, List<Author> authors, String isbn, int pages) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.pages = pages;
    }
    @Override
    public String info()
    {
        return '"' + getTitle() + '"' + ", " + getAuthorNames() + " (strony: " + getPages() + ", ISBN: " + getIsbn() + ")";
    }
}
