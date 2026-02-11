package project.model.item;

public enum DirectorAward
{
    OSCAR("Academy Award"),
    GOLDEN_GLOBE("Golden Globe Award"),
    BAFTA("British Academy Film Award"),
    POLISH_FILM_AWARD("Polska Nagroda Filmowa (Orły)");

    private final String fullname;

    DirectorAward(String fullname)
    {
        this.fullname = fullname;
    }

    String getFullname()
    {
        return this.fullname;
    }
}


