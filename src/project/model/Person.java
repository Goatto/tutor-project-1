package project.model;

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
            if (firstName == null)
            {
                return lastName;
            }
            if (lastName == null)
            {
                return firstName;
            }
        }
        return "Blad";
    }

    private formatName(String name)
    {
        
    }
}
