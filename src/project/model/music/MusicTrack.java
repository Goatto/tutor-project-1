package project.model.music;

import project.model.item.Author;
import project.model.item.Authored;
import project.model.item.LibraryItem;
import project.model.item.Playable;

import java.util.List;

public abstract class MusicTrack implements LibraryItem, Authored, Playable
{
    private final String title;
    private final List<Author> authors;
    private final int duration;
    private final MusicGenre genre;

    public MusicTrack(String title, List<Author> authors, int duration, MusicGenre genre) {
        this.title = title;
        this.authors = authors;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle()
    {
        return this.title;
    }

    public List<Author> getAuthors()
    {
        return this.authors;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public MusicGenre getGenre()
    {
        return this.genre;
    }

    @Override
    public String info()
    {
        return getAuthorNames() + " - " + getTitle() + " (" + formatedDuration() + ") :: " + getGenre();
    }
}
