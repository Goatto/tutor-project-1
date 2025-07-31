package project;

import project.model.User;
import project.model.item.book.*;
import project.model.item.magazine.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int test = 1;
            User janKowalski = new User("Jan", "Kowalski", 1);
            User adamNowak = new User("Adam", "Nowak", 2);
            Textbook textbook = new Textbook("Analiza matematyczna", "Jan Nowak", "978-83-123456-7", 300, "Matematyka");
            Novel novel = new Novel("W pustyni i w puszczy", "Henryk Sienkiewicz", "978-83-123456-8", 400, "Przygodowa");
            Manga manga = new Manga("Naruto", "Masashi Kishimoto", "978-83-123456-9", 200, List.of("Masashi Kishimoto", "Yasuharu Takanashi"));
        if(test == 0) {
            janKowalski.addItem(textbook);
            janKowalski.addItem(novel);
            adamNowak.addItem(manga);
            System.out.println(janKowalski.info());
            System.out.println(adamNowak.info());
            System.out.println(textbook.info());
            System.out.println(novel.info());
            System.out.println(manga.info());
        }
        else if (test == 1)
        {
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
        }

    }

}