package project.model;

public abstract class Person
{
    private String firstName;
    private String lastName;

    public void setFirstName(String firstName)
    {
        this.firstName = formatName(firstName);
    }

    public void setLastName(String lastName)
    {
        this.lastName = formatName(lastName);
    }

    private String formatName(String name)
    {
        // Zamienia pierwszą literę na dużą i resztę zwraca normalnie
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public Person(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public abstract String info();

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFullName()
    {
        if (getFirstName() != null || getLastName() != null)
        {
            return getFirstName() + " " + getLastName();

        }
        if (getFirstName() == null)
        {
            return getLastName();
        }
        if (getLastName() == null)
        {
            return getFirstName();
        }
        else {
            return "";
        }
    }
}
