package project.model.item;

import java.util.List;

public interface Authored {
    List<Author> getAuthors();

    default String getAuthorNames()
    {
        String prefix = "";
        StringBuilder allNames = new StringBuilder();
        for (Author autor : getAuthors())
        {
            allNames.append(prefix);
            prefix = ", ";
            allNames.append(autor.getFullName());
        }
        return allNames.toString();
    }
}
