package project.model.item.magazine;

import project.model.item.LibraryItem;

public abstract class Magazine implements LibraryItem
{
    private final String title;
    private final String author;
    private final String issn;
    private final int issueNumber;

    public Magazine(String title, String author, String issn, int issueNumber)
    {
        this.title = title;
        this.author = author;
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getIssn()
    {
        return issn;
    }

    public int getIssueNumber()
    {
        return issueNumber;
    }

    @Override
    public String info() {
        return '"' + title + "\", wydanie" + issueNumber + ", " + author + " (ISSN" + issn + ')';
    }
}
