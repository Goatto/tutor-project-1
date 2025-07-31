package project.model.item.book;

import java.util.List;

public class Manga extends Book
{
    private final List<String> illustrators;

    public Manga(String title, String author, String isbn, int pages, List<String> illustrators)
    {
        super(title, author, isbn, pages);
        this.illustrators = illustrators;
    }

    public List<String> getIllustrators() {
        return illustrators;
    }
}
