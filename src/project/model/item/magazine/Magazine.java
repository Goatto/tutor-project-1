package project.model.item.magazine;

import project.model.item.Author;
import project.model.item.Authored;
import project.model.item.LibraryItem;

import java.util.List;

public abstract class Magazine implements LibraryItem, Authored
{
    private final String title;
    private final List<Author> authors;
    private final String issn;
    private final int issueNumber;

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public List<Author> getAuthors()
    {
        return this.authors;
    }

    public String getIssn()
    {
        return this.issn;
    }

    public int getIssueNumber()
    {
        return this.issueNumber;
    }

    public Magazine(String title, List<Author> authors, String issn, int issueNumber)
    {
        this.title = title;
        this.authors = authors;
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String info()
    {
       return '"' + getTitle() + "\", wydanie " + getIssueNumber() + ", " + getAuthorNames() + " (ISSN: " + getIssn() + ')';
    }
}
