package project;

import project.model.User;
import project.model.item.Author;
import project.model.item.Director;
import project.model.item.DirectorAward;
import project.model.item.book.Manga;
import project.model.item.book.Novel;
import project.model.item.book.Textbook;
import project.model.item.magazine.Magazine;
import project.model.item.magazine.NewsMagazine;
import project.model.item.magazine.ScienceMagazine;
import project.model.item.video.ActingRole;
import project.model.item.video.Actor;
import project.model.item.video.Documentary;
import project.model.item.video.Movie;
import project.model.item.video.anime.Anime;
import project.model.item.video.anime.AnimeType;
import project.model.item.video.anime.Character;
import project.model.music.MusicGenre;
import project.model.music.VocalTrack;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class functionalityTests
{
    public enum testTypes
    {
        LibraryItem,
        MusicTrack,
        Movie,
        Documentary,
        Anime
    }

    public void functionalityTest(testTypes testType)
    {
        User janKowalski = new User("Jan", "Kowalski", 1);
        User adamNowak = new User("Adam", "Nowak", 2);
        System.out.println(janKowalski.info());
        System.out.println(adamNowak.info());
        switch(testType)
        {
            case LibraryItem:
                List<Author> textbookAuthors = List.of(new Author("Jan", "Nowak", "J.N.",
                        LocalDate.of(1992, 1, 3), null, List.of("Polski", "Angielski")));
                Textbook textbook = new Textbook("Analiza Matematyczna", textbookAuthors, "978-83-123456-7", 300, "Matematyka");

                List<Author> novelAuthors = List.of(new Author("Henryk", "Sienkiewicz", null,
                        LocalDate.of(1846, 5, 5), LocalDate.of(1916, 11, 15), List.of("Polski")));
                Novel novel = new Novel("W pustyni i w puszczy", novelAuthors, "978-83-123456-8", 400, "Przygodowa");

                List<Author> mangaAuthors = List.of(
                        new Author("Masashi", "Kishimoto", null,
                                LocalDate.of(1974, 11, 8), null, List.of("Japoński")),
                        new Author("Yasuharu", "Takanashi", null,
                                LocalDate.of(1963, 4, 13), null, List.of("Japoński")));
                List<Author> illustrators = List.of(mangaAuthors.getFirst());
                Manga manga = new Manga("Naruto", mangaAuthors, "978-83-123456-9", 200, illustrators);

                List<Author> scienceMagazineAuthors = List.of(new Author("John", "Doe", null,
                        null, null, Collections.emptyList()));
                Magazine scienceMagazine = new ScienceMagazine("Nature", scienceMagazineAuthors, "1234-5678",
                        1, "Biology");

                List<Author> newsMagazineAuthors = List.of(new Author("Jane", "Smith", null,
                        null, null, Collections.emptyList()));
                Magazine newsMagazine = new NewsMagazine("The Times", newsMagazineAuthors, "8765-4321",
                        2, List.of("Politics", "Economy"));
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
                break;
            case MusicTrack:
                List<Author> musicAuthors = List.of(
                        new Author(null, null, "rów babicze",
                                null, null, List.of("Polski")));
                List<Author> vocalists = List.of(
                        new Author(null, null, "Bardal",
                                null, null, List.of("Polski")));
                VocalTrack musicTrack = new VocalTrack("W GORĄCEJ WODZIE COMPANY", musicAuthors, 167,
                        MusicGenre.HIP_HOP, vocalists, true, "Polski");
                janKowalski.addItem(musicTrack);
                System.out.println(musicTrack.info());
                System.out.println("Szczegółowe informacje o " + musicTrack.getTitle() + ":");
                System.out.println("  Tytuł: " + musicTrack.getTitle());
                System.out.println("  Autorzy: " + musicTrack.getAuthorNames());
                System.out.println("  Czas trwania: " + musicTrack.formatedDuration());
                System.out.println("  Gatunek: " + musicTrack.getGenre());
                System.out.println("  Wokaliści: " + musicTrack.getVocalists());
                System.out.println("  Wulgarny: " + musicTrack.getIsExplicit());
                System.out.println("  Język: " + musicTrack.getLanguage());
                break;

            case Movie:
                Director nolan = new Director("Christopher", "Nolan", null, LocalDate.of(1970, 7, 30),
                        null, List.of(DirectorAward.OSCAR, DirectorAward.GOLDEN_GLOBE));
                Actor dicaprio = new Actor("Leonardo", "DiCaprio", null, LocalDate.of(1974, 11, 11), null, false);
                Actor gordonLevitt = new Actor("Joseph", "Gordon-Levitt", null, LocalDate.of(1981, 2, 17), null, false);
                ActingRole cobbRole = new ActingRole("Cobb", "Główny bohater, specjalista od ekstrakcji snów.");
                ActingRole arthurRole = new ActingRole("Arthur", "Partner Cobba, odpowiedzialny za research.");
                Movie inception = new Movie("Incepcja", 8880, nolan, null);
                inception.addActor(dicaprio, cobbRole);
                inception.addActor(gordonLevitt, arthurRole);
                janKowalski.addItem(inception);
                System.out.println("\n--- TESTOWANIE FILMU ---");
                System.out.println(inception.info());
                System.out.println(janKowalski.info());
                // Dodajemy nowego aktora z jego rolą
                System.out.println("\n...Dodawanie nowego aktora...");
                Actor hardy = new Actor("Tom", "Hardy", null, LocalDate.of(1977, 9, 15), null, false);
                ActingRole eamesRole = new ActingRole("Eames", "Fałszerz, potrafi zmieniać wygląd w świecie snów.");
                inception.addActor(hardy, eamesRole);
                System.out.println(inception.info());

// Usuwamy jedną z ról
                System.out.println("\n...Usuwanie roli aktora...");
                inception.removeRoleForActor(gordonLevitt, arthurRole);
                System.out.println(inception.info());

// Po usunięciu ostatniej roli aktor powinien zniknąć z obsady
                System.out.println("Czy Joseph Gordon-Levitt nadal jest w obsadzie? " + inception.getActors().contains(gordonLevitt));
                break;
            case Documentary:
                Director herzog = new Director("Werner", "Herzog", null, LocalDate.of(1942, 9, 5), null, List.of());
                Actor narrator = new Actor("Krystyna", "Czubówna", null, LocalDate.of(1954, 8, 2), null, true);
                // Dokument z narratorem - używamy głównego konstruktora
                Documentary lifeOnEarth = new Documentary("Życie na Ziemi", 5400, herzog, "Przyroda", narrator);

                // Dokument bez narratora - używamy przeciążonego konstruktora
                Documentary industrialRevo = new Documentary("Rewolucja Przemysłowa", 3600, herzog, "Historia");
                adamNowak.addItem(lifeOnEarth);
                adamNowak.addItem(industrialRevo);
                System.out.println("\n--- TESTOWANIE FILMU DOKUMENTALNEGO ---");
                System.out.println(lifeOnEarth.info());
                System.out.println(industrialRevo.info());
                System.out.println("\nSprawdzanie narratora w '" + lifeOnEarth.getTitle() + "':");
                lifeOnEarth.getNarrator().ifPresent(n -> System.out.println("  Narratorem jest: " + n.getFullName()));

                System.out.println("\nSprawdzanie narratora w '" + industrialRevo.getTitle() + "':");
                industrialRevo.getNarrator().ifPresent(n -> {
                    // Ten tekst nie powinien się wyświetlić
                    System.out.println("  Narratorem jest: " + n.getFullName());
                });
                // Możemy też sprawdzić inaczej
                if (industrialRevo.getNarrator().isEmpty()) {
                    System.out.println("  Ten dokument nie ma narratora.");
                }

            case Anime:
                Actor kaji = new Actor("Yūki", "Kaji", null, LocalDate.of(1985, 9, 3), null, true);
                Actor ishikawa = new Actor("Yui", "Ishikawa", null, LocalDate.of(1989, 5, 30), null, true);

                Actor murakawa = new Actor("Rie", "Murakawa", null, LocalDate.of(1990, 1, 1), null, true);
                Actor minase = new Actor("Inori", "Minase", null, LocalDate.of(1995, 12, 2), null, true);

                Character eren = new Character("Eren Yeager", kaji, true);
                Character mikasa = new Character("Mikasa Ackerman", ishikawa, true);

                Character ram = new Character("Ram", murakawa, true);
                Character rem = new Character("Rem", minase, true);

                Director araki = new Director("Tetsurō", "Araki", null, LocalDate.of(1976, 11, 5), null, List.of());
                Director watanabe = new Director("Masaharu", "Watanabe", null, null, null, List.of());

                Anime attackOnTitan = new Anime("Attack on Titan", 1440, araki,
                        "進撃の巨人 (Shingeki no Kyojin)", AnimeType.TV_SERIES, Set.of(eren, mikasa));

                Anime reZero = new Anime("Re:ZERO - Starting Life in Another World", 1500, watanabe,
                        "Re:ゼロから始める異世界生活", AnimeType.TV_SERIES, Set.of(ram, rem));

                janKowalski.addItem(attackOnTitan);
                janKowalski.addItem(reZero);

                System.out.println("\n--- TESTOWANIE ANIME ---");
                System.out.println(attackOnTitan.info());
                System.out.println(reZero.info());
                break;

                default:
                    System.out.println();
        }
    }
}
