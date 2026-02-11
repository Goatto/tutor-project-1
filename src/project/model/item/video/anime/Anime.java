package project.model.item.video.anime;

import project.model.item.Director;
import project.model.item.video.Video;

import java.util.Set;

public class Anime extends Video
{
    private final String originalTitle;
    private final AnimeType type;
    private final Set<Character> characters;

    public Anime(String title, int duration, Director director,
                    String originalTitle, AnimeType type, Set<Character> characters)
    {
        super(title, duration, director);
        this.originalTitle = originalTitle;
        this.type = type;
        this.characters = characters;
    }

    public String getOriginalTitle()
    {
        return this.originalTitle;
    }

    public AnimeType getType()
    {
        return this.type;
    }

    public Set<Character> getCharacters()
    {
        return this.characters;
    }

    @Override
    public String info()
    {
        return getOriginalTitle() + " (" + getTitle() + ") " +getType() + " (" + formatedDuration() + ")";
    }

    @Override
    public String toString()
    {
        return info();
    }
}
