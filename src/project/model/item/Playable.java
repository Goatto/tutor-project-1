package project.model.item;

public interface Playable
{
    int getDuration();
    default String formatedDuration()
    {
        int duration = getDuration();
        int sec = duration % 60;
        duration = duration / 60;
        int min = duration % 60;
        duration = duration / 60;
        int hou = duration;
        // %0 daje nam padding o wartość int znajdującą się przed nią - d po wartości
        return String.format("%0" + 2 + "d:%0" + 2+"d:%0" + 2 + "d",hou ,min ,sec);
    }
}
