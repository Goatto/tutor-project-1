package project.model.item.video;

import project.model.item.Director;

import java.util.*;

public class Movie extends Video
{
    private Map<Actor, List<ActingRole>> actors;

    public Movie(String title, int duration, Director director,
                    Map<Actor, List<ActingRole>> actors)
    {
        super(title, duration, director);
            this.actors = actors;
    }
    public void addActor(Actor actor, ActingRole... roles)
    {
        if(actors == null)
        {
            actors = new HashMap<>();
        }
        if(actor==null || roles==null)
        {
            throw new IllegalArgumentException("Rola oraz aktor nie mogą być puste");
        }
        if(roles.length < 1)
        {
            throw new IllegalArgumentException("Aktor musi mieć przynajmniej jedną rolę");
        }
        if (actors.containsKey(actor))
        {
            actors.get(actor).addAll(Arrays.asList(roles));
        }
        else
        {
            actors.computeIfAbsent(actor, a -> new ArrayList<>(Arrays.asList(roles)));
        }
    }

    public Set<Actor> getActors()
    {
        return this.actors.keySet();
    }

    public List<ActingRole> getRolesForActor(Actor actor)
    {
        return actors.getOrDefault(actor, List.of());
    }

    public void removeActor(Actor actor)
    {
        if(actor==null)
        {
            throw new IllegalArgumentException("Actor nie może być pusty!");
        }
        else
        {
            actors.remove(actor);
        }
    }

    public void removeRoleForActor(Actor actor, ActingRole role)
    {
        if(actor==null || role==null)
        {
            throw new IllegalArgumentException("Actor oraz rolę nie mogą być pustę!");
        }
        if(actors.containsKey(actor))
        {
            actors.get(actor).remove(role);
            if(actors.get(actor).isEmpty())
            {
                actors.remove(actor);
            }
        }
    }

    @Override
    public String info()
    {
        String prefix = "";
        StringBuilder allActorsAndRoles = new StringBuilder();
        for(Actor key : actors.keySet())
        {
            allActorsAndRoles.append(prefix);
            prefix = ", ";
            allActorsAndRoles.append(key.getFullName());
            allActorsAndRoles.append("(");
            for(ActingRole role : actors.get(key))
            {
                prefix = ", ";
                allActorsAndRoles.append(role);
            }
            allActorsAndRoles.append(")");
        }
        return getTitle() + ", " + getDirector() + " (" + getDuration() + ") :: " + allActorsAndRoles;
    }
}
