package project.model.music;

import project.model.item.Author;

import java.util.List;

public class VocalTrack extends MusicTrack
{
    private final List<Author> vocalists;
    private final boolean isExplicit;
    private final String language;

    public VocalTrack(String title, List<Author> authors, int duration, MusicGenre genre,
                      List<Author> vocalists, boolean isExplicit, String language)
    {
        super(title, authors, duration, genre);

        this.vocalists = vocalists;
        this.isExplicit = isExplicit;
        this.language = language;
    }

    public List<Author> getVocalists()
    {
        return this.vocalists;
    }

    public boolean getIsExplicit()
    {
        return this.isExplicit;
    }

    public String getLanguage()
    {
        return this.language;
    }
}
