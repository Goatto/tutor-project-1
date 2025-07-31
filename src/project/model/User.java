package project.model;

import project.model.item.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class User extends Person
{
    private final int userID;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public User(String firstName, String lastName, final int userID)
    {
        super(firstName, lastName);
        this.userID = userID;
    }
    public int getUserID()
    {
        return userID;
    }

    public List<LibraryItem> getBorrowedItems()
    {
        return borrowedItems;
    }
    public void addItem(LibraryItem item)
    {
        borrowedItems.add(item);
    }
    public boolean hasItem(LibraryItem item)
    {
        return borrowedItems.contains(item);
    }
    public void removeItem(LibraryItem item)
    {
        if(!hasItem(item))
        {
           throw new IllegalArgumentException("Uzytkownik nie posiada:" + (item));
        }
        else
        {
            borrowedItems.remove(item);
        }
    }

    @Override
    public String info()
    {
        return getFullName() + " (" + userID + ")" + ": " + borrowedItems.size() + " wypozyczone przemdioty";
    }
}
