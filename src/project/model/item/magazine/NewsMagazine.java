package project.model.item.magazine;

import project.model.item.Author;

import java.util.List;

public class NewsMagazine extends Magazine
{
    private final List<String> featuredTopics;

    public List<String> getFeaturedTopics()
    {
        return this.featuredTopics;
    }

    public NewsMagazine(String title, List<Author> authors, String issn, int issueNumber, List<String> featuredTopics) {
        super(title, authors, issn, issueNumber);
        this.featuredTopics = featuredTopics;
    }

}
