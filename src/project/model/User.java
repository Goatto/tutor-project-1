package project.model;

import project.model.item.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class User extends Person
{
    // Final oznacza, że możemy tylko raz przypisać wartość do zmiennej
    private final int userID;
    private final List<LibraryItem> borrowedItems = new ArrayList<>();

    public void addItem(LibraryItem item)
    {
        this.borrowedItems.add(item);
    }

    public void removeItem(LibraryItem item)
    {
        if(hasItem(item))
        {
            this.borrowedItems.remove(item);
        }
        else {
            throw new IllegalArgumentException("Użytkownik nie posiada: " + item.getTitle());
        }
    }

    public boolean hasItem(LibraryItem item)
    {
        return this.borrowedItems.contains(item);
    }

    public int getUserID()
    {
        return this.userID;
    }

    public List<LibraryItem> getBorrowedItems()
    {
        return this.borrowedItems;
    }

    // Bez bororwedItems, bo pierw tworzymy użytkownika, PO CZYM, może on wypożyczać przedmioty
    public User(String firstName, String lastName, int userID)
    {
        super(firstName, lastName);
        this.userID = userID;
    }

    // Nadpisujemy metodę domyślną
    @Override
    public String info()
    {
        return getFirstName() + " " + getLastName() + " (" + getUserID() + "): "
                + this.borrowedItems.size() + " wypożyczone przedmioty";
    }
}
