package project.model.item.magazine;

import project.model.item.Author;

import java.util.List;

public class ScienceMagazine extends Magazine
{
    private final String fieldOfStudy;

    public String getFieldOfStudy()
    {
        return this.fieldOfStudy;
    }

    public ScienceMagazine(String title, List<Author> authors, String issn, int issueNumber, String fieldOfStudy) {
        super(title, authors, issn, issueNumber);
        this.fieldOfStudy = fieldOfStudy;
    }
}
