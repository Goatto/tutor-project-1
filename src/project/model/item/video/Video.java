package project.model.item.video;

import project.model.item.Directed;
import project.model.item.Director;
import project.model.item.LibraryItem;
import project.model.item.Playable;

public abstract class Video implements LibraryItem, Directed, Playable
{
    private final String title;
    private final int duration;
    private final Director director;

    protected Video(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public Director getDirector()
    {
        return this.director;
    }

    @Override
    public String info()
    {
        return getTitle() + ", " + getDirector() + " (" + formatedDuration() + ')';
    }

    @Override
    public String toString()
    {
        return info();
    }
}
