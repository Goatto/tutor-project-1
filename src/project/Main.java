import project.model.User;
import project.model.item.Author;
import project.model.item.book.*;
import project.model.item.magazine.*;

void main()
{
    User janKowalski = new User("Jan", "Kowalski", 1);
    User adamNowak = new User("Adam", "Nowak", 2);
    System.out.println(janKowalski.info());
    System.out.println(adamNowak.info());
    /*
    Textbook textbook = new Textbook("Analiza Matematyczna", "Jan Nowak", "978-83-123456-7",
            300, "Matematyka");
    Novel novel = new Novel("W pustyni i w puszczy", "Henryk Sienkiewicz", "978-83-123456-8",
            400, "Przygodowa");
    Manga manga = new Manga("Naruto", "Masashi Kishimoto", "978-83-123456-9",
            200, List.of("Masashi Kishimoto", "Yasuharu Takanashi"));
    janKowalski.addItem(textbook);
    janKowalski.addItem(novel);
    adamNowak.addItem(manga);
    System.out.println(textbook.info());
    System.out.println(novel.info());
    System.out.println(manga.info());
    */
    /*
    ScienceMagazine scienceMagazine = new ScienceMagazine("Nature", "John Doe", "1234-5678", 1, "Biologia");
    NewsMagazine newsMagazine = new NewsMagazine("The Times", "Jane Smith", "8765-4321", 2, List.of("Polityka", "Ekonomia"));
    janKowalski.addItem(scienceMagazine);
    adamNowak.addItem(newsMagazine);
    System.out.println(scienceMagazine.info());
    System.out.println(newsMagazine.info());
    System.out.println("Szczegółowe informacje o " + scienceMagazine.getTitle() + ":");
    System.out.println("  Tytuł: " + scienceMagazine.getTitle());
    System.out.println("  Autor: " + scienceMagazine.getAuthor());
    System.out.println("  ISSN: " + scienceMagazine.getIssn());
    System.out.println("  Numer wydania: " + scienceMagazine.getIssueNumber());
    System.out.println("  Dziedzina nauki: " + scienceMagazine.getFieldOfStudy());
    */
    List<Author> textbookAuthors = List.of(new Author("Jan", "Nowak", "J.N.", LocalDate.of(1992, 1, 3), null, List.of("Polski", "Angielski")));
    Textbook textbook = new Textbook("Analiza Matematyczna", textbookAuthors, "978-83-123456-7", 300, "Matematyka");

    List<Author> novelAuthors = List.of(new Author("Henryk", "Sienkiewicz", null, LocalDate.of(1846, 5, 5), LocalDate.of(1916, 11, 15), List.of("Polski")));
    Novel novel = new Novel("W pustyni i w puszczy", novelAuthors, "978-83-123456-8", 400, "Przygodowa");

    List<Author> mangaAuthors = List.of(
            new Author("Masashi", "Kishimoto", null, LocalDate.of(1974, 11, 8), null, List.of("Japoński")),
            new Author("Yasuharu", "Takanashi", null, LocalDate.of(1963, 4, 13), null, List.of("Japoński")));
    List<Author> illustrators = List.of(mangaAuthors.getFirst());
    Manga manga = new Manga("Naruto", mangaAuthors, "978-83-123456-9", 200, illustrators);

    List<Author> scienceMagazineAuthors = List.of(new Author("John", "Doe", null, null, null, Collections.emptyList()));
    Magazine scienceMagazine = new ScienceMagazine("Nature", scienceMagazineAuthors, "1234-5678", 1, "Biology");

    List<Author> newsMagazineAuthors = List.of(new Author("Jane", "Smith", null, null, null, Collections.emptyList()));
    Magazine newsMagazine = new NewsMagazine("The Times", newsMagazineAuthors, "8765-4321", 2, List.of("Politics", "Economy"));
    janKowalski.addItem(textbook);
    janKowalski.addItem(novel);
    adamNowak.addItem(manga);
    adamNowak.addItem(scienceMagazine);
    adamNowak.addItem(newsMagazine);
    System.out.println(janKowalski.info());
    System.out.println(adamNowak.info());
    System.out.println(textbook.info());
    System.out.println(novel.info());
    System.out.println(manga.info());
    System.out.println(scienceMagazine.info());
    System.out.println(newsMagazine.info());
}


