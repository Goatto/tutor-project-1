package project.model.item;

public interface LibraryItem
{
    String getTitle();

    default String info()
    {
        return "Tytul:" + getTitle();
    }

}
