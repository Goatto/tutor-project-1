package project.model.item.magazine;

import java.util.ArrayList;
import java.util.List;

public class NewsMagazine extends Magazine
{
    private List<String> featuredTopics = new ArrayList<>();
    public NewsMagazine(String title, String author, String issn, int issueNumber, List<String> featuredTopics)
    {
        super(title, author, issn, issueNumber);
        this.featuredTopics = featuredTopics;
    }

    public List<String> getFeaturedTopics()
    {
        return featuredTopics;
    }
}
