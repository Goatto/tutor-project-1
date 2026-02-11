package project.model.item.video;

import project.model.item.Director;

import java.util.Optional;

public class Documentary extends Video
{
    private final String subject;
    private final Actor narrator;

    public Documentary(String title, int duration, Director director,
                          String subject, Actor narrator) {
        super(title, duration, director);
        this.subject = subject;
        if(narrator!=null)
        {
            if(narrator.getIsVoiceActor())
            {
                this.narrator = narrator;
            }
            else
            {
                throw new IllegalArgumentException("Narrator musi być aktorem głosowym!");
            }
        }
        else
        {
            this.narrator = null;
        }
    }

    public Documentary(String title, int duration, Director director,
                          String subject)
    {
        this(title, duration, director, subject, null);
    }

    public String getSubject()
    {
        return this.subject;
    }

    public Optional<Actor> getNarrator()
    {
        return Optional.ofNullable(narrator);
    }

    @Override
    public String info()
    {
        StringBuilder string = new StringBuilder();
        string.append(getTitle());
        string.append(", ");
        string.append(getDirector());
        string.append(" (");
        string.append(getDuration());
        string.append(") :: ");
        string.append(getDuration());
        if(getNarrator().isPresent())
        {
            string.append(" (Narracja: ");
            string.append(getNarrator().get().getFullName());
            string.append(')');
        }
        return string.toString();
    }

    @Override
    public String toString()
    {
        return info();
    }
}