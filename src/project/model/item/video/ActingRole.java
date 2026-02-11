package project.model.item.video;

public class ActingRole
{
    private final String name;
    private final String description;

    public ActingRole(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    @Override
    public String toString()
    {
        if(getDescription()!=null)
        {
            return getName() + " (" + getDescription() + ')';
        }
        else
        {
            return getName() + " (brak opisu)";
        }
    }
}
