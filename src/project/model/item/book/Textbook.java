package project.model.item.book;

import project.model.item.Author;

import java.util.List;

public class Textbook extends Book
{
    private final String subject;

    public Textbook(String title, List<Author> authors, String isbn, int pages, String subject) {
        super(title, authors, isbn, pages);
        this.subject = subject;
    }

    public String getSubject()
    {
        return this.subject;
    }

}
