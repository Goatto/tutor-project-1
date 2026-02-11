package project.model.item.video.anime;

import project.model.item.video.Actor;

public record Character
        (
                String name,
                Actor voiceActor,
                boolean isMainCharacter
        )
{

}
