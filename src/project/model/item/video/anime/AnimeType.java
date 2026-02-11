package project.model.item.video.anime;

public enum AnimeType
{
    TV_SERIES("TV SERIES"),
    MOVIE("Movie"),
    OVA("OVA"),
    ONA("ONA"),
    SPECIAL("Special");

    private final String name;

    AnimeType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
