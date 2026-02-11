package project.model.item.video;

import project.model.item.Creator;

import java.time.LocalDate;

public class Actor extends Creator
{
    private final boolean isVoiceActor;

    public Actor(String firstName, String lastName, String alias, LocalDate birthDate, LocalDate deathDate,
                 boolean isVoiceActor) {
        super(firstName, lastName, alias, birthDate, deathDate);
        this.isVoiceActor = isVoiceActor;
    }

    public Actor(String firstName, String lastName, String alias, LocalDate birthDate,
                 boolean isVoiceActor) {
        super(firstName, lastName, alias, birthDate);
        this.isVoiceActor = isVoiceActor;
    }

    public boolean getIsVoiceActor()
    {
        return this.isVoiceActor;
    }
}
