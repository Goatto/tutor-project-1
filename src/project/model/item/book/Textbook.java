package project.model.item.book;

public class Textbook extends Book
{
    private final String subject;
    public Textbook(String title, String author, String isbn, int pages, String subject)
    {
        super(title, author, isbn, pages);
        this.subject = subject;
    }
}
