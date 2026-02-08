package project.model.item;

import java.time.LocalDate;
import java.util.List;

public class Author extends Creator
{
    private final List<String> languages;

    public Author(String firstName, String lastName, String alias, LocalDate birthDate,
                  LocalDate deathDate, List<String> languages)
    {
        super(firstName, lastName, alias, birthDate, deathDate);
        this.languages = languages;
    }

    public List<String> getLanguages()
    {
        return this.languages;
    }

    @Override
    public String info()
    {
        return super.info() + ", języki: " + getLanguages();

    }
}
