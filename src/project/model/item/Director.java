package project.model.item;

import project.model.Person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Director extends Creator
{
    private List<DirectorAward> awards;

    public Director(String firstName, String lastName, String alias, LocalDate birthDate, LocalDate deathDate,
                    List<DirectorAward> awards)
    {
        super(firstName, lastName, alias, birthDate, deathDate);
        this.awards = awards;
    }

    public Director(String firstName, String lastName, String alias, LocalDate birthDate,
                    List<DirectorAward> awards)
    {
        super(firstName, lastName, alias, birthDate);
        this.awards = awards;
    }

    public List<DirectorAward> getAwards()
    {
        return Collections.unmodifiableList(this.awards);
    }

    public void addAward(DirectorAward award)
    {
        awards.add(award);
    }

    public void removeAward(DirectorAward award)
    {
        awards.remove(award);
    }
}
