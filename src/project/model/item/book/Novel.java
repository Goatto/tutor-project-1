package project.model.item.book;

import project.model.item.Author;

import java.util.List;

public class Novel extends Book
{
    private final String genre;

    public Novel(String title, List<Author> authors, String isbn, int pages, String genre)
    {
        super(title, authors, isbn, pages);
        this.genre = genre;
    }

    public String getGenre()
    {
        return this.genre;
    }
}
