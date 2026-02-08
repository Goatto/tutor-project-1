package project.model.item;

import project.model.Person;

import java.time.LocalDate;

public class Creator extends Person {

    private final String alias;
    private final LocalDate birthDate;
    private LocalDate deathDate = null;

    public void setDeathDate(LocalDate deathDate)
    {
        this.deathDate = deathDate;

    }

    public Creator(String firstName, String lastName, String alias, LocalDate birthDate, LocalDate deathDate)
    {
        super(firstName, lastName);
        this.alias = alias;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Creator(String firstName, String lastName, String alias, LocalDate birthDate)
    {
        super(firstName, lastName);
        this.alias = alias;
        this.birthDate = birthDate;

    }

    public String getAlias()
    {
        return this.alias;
    }

    public LocalDate getBirthDate()
    {
        return this.birthDate;
    }

    public LocalDate getDeathDate()
    {
        return this.deathDate;
    }

    public String getFullname()
    {
        if(getAlias()!=null)
        {
            return getAlias();
        }
        else
        {
            return getFullName();
        }
    }

    @Override
    public String info() {
        if(getDeathDate()!=null)
        {
            return getAlias() + " (" + getFullname() + "), " + getBirthDate() + '-' + getDeathDate();
        }
        else
        {
            return getAlias() + " (" + getFullname() + "), " + getBirthDate();
        }
    }
}
