package project.model;

import static java.lang.Character.toUpperCase;

public abstract class Person
{
    private String firstName;
    private String lastName;

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFullName()
    {
        if (firstName != null && lastName != null)
        {
            return firstName + lastName;
        }
        else
        {
            if (firstName == null && lastName == null)
            {
                return "Brak danych";
            }
            if (firstName == null) {
                return lastName;
            }
            if (lastName == null) {
                return firstName;
            }
        }
        return "Blad";
    }

    private String formatName(String name)
    {
        if (name == null)
        {
            return "Blad";
        }
        else
        {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }
    public void setFirstName(String firstName)
    {
        this.firstName = formatName(firstName);
    }
    public void setLastName(String lastName)
    {
        this.lastName = formatName(lastName);
    }
    public Person(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }
    public abstract String info();
}
