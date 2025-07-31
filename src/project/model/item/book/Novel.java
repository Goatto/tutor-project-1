package project.model.item.book;

public class Novel extends Book
{
    private final String genre;

    public Novel(String title, String author, String isbn, int pages, String genre)
    {
        super(title, author, isbn, pages);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
