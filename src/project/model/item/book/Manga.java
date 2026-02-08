package project.model.item.book;

import project.model.item.Author;

import java.awt.*;
import java.util.List;

public class Manga extends Book
{
    // Nie inicjalizujemy listy TU, bo tworzymy listę FINAL dopiero przy INICJALIZACJI obiektu
    // Lepiej List niż ArrayList?
    private final List<Author> illustrators;

    public Manga(String title, List<Author> authors, String isbn, int pages, List<Author> illustrators)
    {
        super(title, authors, isbn, pages);
        this.illustrators = illustrators;
    }

    public List<Author> getIllustrators()
    {
        return this.illustrators;
    }

}
