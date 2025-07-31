package project.model.item.magazine;

public class ScienceMagazine extends Magazine
{
    private final String fieldOfStudy;

    public ScienceMagazine(String title, String author, String issn, int issueNumber, String fieldOfStudy)
    {
        super(title, author, issn, issueNumber);
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getFieldOfStudy()
    {
        return fieldOfStudy;
    }
}
