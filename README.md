<div style="text-align:center;">
   <h1>Projekt(1): Biblioteka</h1>
   <h5>Tworzenie złożonego systemu bibliotecznego z wykorzystaniem interfejsów, klas abstrakcyjnych i prostych struktur danych</h5>
</div>


## Opis projektu

Projekt ma na celu stworzenie systemu bibliotecznego, który umożliwia wypożyczanie różnych rodzajów przedmiotów, takich jak książki, magazyny, filmy i muzyka. System powinien być elastyczny i rozszerzalny, co pozwoli na łatwe dodawanie nowych rodzajów przedmiotów do wypożyczenia w przyszłości.

W projekcie wykorzystane zostaną interfejsy i klasy abstrakcyjne, aby zapewnić elastyczność i rozszerzalność systemu. Interfejsy będą definiować metody, które muszą być zaimplementowane przez klasy reprezentujące różne rodzaje przedmiotów, a klasy abstrakcyjne będą zawierać wspólne implementacje dla tych klas.

Użyte zostaną również proste struktury danych, takie jak listy i mapy, do przechowywania informacji o przedmiotach i ich dostępności. System będzie umożliwiał dodawanie nowych przedmiotów do biblioteki, sprawdzanie dostępności przedmiotów oraz wypożyczanie i zwracanie przedmiotów przez użytkowników.

## Szybkie przypomnienie
- Interfejsy są umowami, które definiują zestaw metod, które klasa musi implementować. Można powiedzieć, że interfejsy są jak kontrakty, które klasy muszą podpisać.
- Abstrakcyjne klasy to klasy, które **nie mogą być** instancjonowane, ale mogą zawierać implementacje metod, które mogą być dziedziczone przez klasy potomne.
  Abstrakcyjne klasy mogą również definiować metody abstrakcyjne, które muszą być zaimplementowane przez klasy potomne.
- Klasy to konkretne implementacje, które **mogą być** instancjonowane i które implementują interfejsy lub dziedziczą po klasach abstrakcyjnych.
#### Różnice między interfejsem a klasą abstrakcyjną:
- Interfejsy to umowy, które definiują zestaw metod, które klasa musi implementować, podczas gdy klasy abstrakcyjne to klasy, które mogą zawierać pola i metody, które mogą być dziedziczone przez klasy potomne.
- Interfejsy nie mogą zawierać pól, podczas gdy klasy abstrakcyjne już mogą.
- Interfejsy mogą być implementowane przez wiele klas, podczas gdy klasy abstrakcyjne mogą być dziedziczone tylko przez jedną klasę potomną.

## Zanim zaczniesz
- Pamiętaj o przerwach co 30-40 minut, aby uniknąć zmęczenia i poprawić swoją koncentrację.
  Przejdź się, rozciągnij, zrób sobie herbatę lub kawkę :D
- Rób backupy swojej pracy, aby móc cofnąć do poprzedniej wersji, jeśli coś pójdzie nie tak.
  - Najlepiej użyj systemu kontroli wersji, takiego jak Git, aby śledzić zmiany w kodzie i móc łatwo wrócić do
    poprzednich wersji. Jeśli nie potrafisz z niego korzystać, to nie martw się, wystarczy, że będziesz robić kopie
    zapasowe
- Zachowuj porządek w kodzie, używaj odpowiednich nazw klas, metod i zmiennych, aby kod był czytelny i zrozumiały.

#### Powodzonka! :D

# 1. Tworzenie struktury projektu

---

## 1.1. Klasa `Person`
Klasa `Person` będzie reprezentować **dowolną osobę**, może to być użytkownik biblioteki lub pracownik, albo nawet autor książki. Klasa ta będzie zawierać podstawowe informacje o osobie, takie jak **imię**, **nazwisko**.

### 1.1.1. Implementacja klasy
1. Stwórz katalog `model` wewnątrz katalogu `project`.
   
   W tym katalogu będziemy przechowywać wszystkie klasy modelujące nasze obiekty, takie jak `Person`, `Book`, `Magazine`, itp.
2. Wewnątrz katalogu `model` stwórz abstrakcyjną klasę `Person`.
3. Wewnątrz klasy utwórz **prywatne** pola `firstName` i `lastName` z typem `String`.
4. Dodaj **publiczną** metodę `getFirstName()`, która zwraca imię osoby.
5. Dodaj **publiczną** metodę `getLastName()`, która zwraca nazwisko osoby.
6. Dodaj **publiczną** metodę `getFullName()`, która zwraca pełne imię i nazwisko osoby, łącząc imię i nazwisko z użyciem spacji.
   - Jeśli imię lub nazwisko są `null`, metoda powinna zwracać tylko dostępne pole.
7. Dodaj **prywatną** metodę `formatName(String name)`, która będzie formatować imię lub nazwisko, aby zawsze zaczynało się wielką literą.
   -  W tym celu użyj metody `substring(0, 1).toUpperCase() + substring(1)` na parametrze.
   
      To zapewni, że pierwsza litera będzie wielka, a reszta pozostanie bez zmian.
8. Dodaj **publiczną** metodę `setFirstName(String firstName)`, która ustawia imię osoby.
   - Upewnij się, że imię zawsze zaczyna się wielką literą.
     
     W tym celu użyj metody wcześniej stworzonej `formatName()`.
9. Dodaj **publiczną** metodę `setLastName(String lastName)`, która ustawia nazwisko osoby.
   - Upewnij się, że nazwisko zawsze zaczyna się wielką literą, używając tej samej metody co w przypadku imienia.
10. Dodaj **publiczny** konstruktor, który przyjmuje imię i nazwisko jako argumenty i inicjalizuje odpowiednie pola.
    - Upewnij się, że imię i nazwisko są poprawnie ustawione przy użyciu metod `setFirstName()` i `setLastName()`.
11. Utwórz **abstrakcyjną** metodę `info()`, która będzie zwracać informacje o osobie w formacie zależnym od klasy, która dziedziczy po `Person`.
    - Metoda ta nie powinna być implementowana w klasie `Person`, ponieważ każda klasa dziedzicząca po `Person` będzie miała swoją własną implementację.

Klasa ta powinna być abstrakcyjna, ponieważ nie chcemy, aby była instancjonowana bezpośrednio, ale chcemy, aby była dziedziczona przez inne klasy.

#### Poprawna implementacja klasy `Person` powinna wyglądać następująco:
```java
package project.model; // Upewnij się, że katalog model jest w katalogu project

public abstract class Person {

    // Pola przechowujące imię i nazwisko
    private String firstName;
    private String lastName;

    // Konstruktor przyjmujący imię i nazwisko
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Getter zwracający imię
    public String getFirstName() {
        return firstName;
    }

    // Setter ustawiający imię
    public void setFirstName(String firstName) {
        this.firstName = formatName(firstName);
    }

    // Getter zwracający nazwisko
    public String getLastName() {
        return lastName;
    }

    // Setter ustawiający nazwisko
    public void setLastName(String lastName) {
        this.lastName = formatName(lastName);
    }

    // Metoda zwracająca pełne imię i nazwisko
    public String getFullName() {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            return firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            return lastName;
        }
        return "";
    }

    // Abstrakcyjna metoda, która będzie zwracać informacje o osobie.
    // Nie implementujemy jej tutaj, ponieważ każda klasa dziedzicząca
    // po Person będzie miała swoją własną implementację!
    public abstract String info();

    // Prywatna metoda formatująca imię lub nazwisko
    private String formatName(String name) {
        if (name != null && !name.isEmpty()) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return name;
    }

}
```

> ### Dlaczego pola `firstName` i `lastName` są prywatne?
> Ustawienie pól jako prywatne to fundament
> [enkapsulacji / hermetyzacji](https://pl.wikipedia.org/wiki/Hermetyzacja_(informatyka)), jednej z najważniejszych zasad
> programowania obiektowego. Oznacza to, że do tych pól nie można uzyskać dostępu bezpośrednio spoza klasy `Person`.
> 
> Dzięki temu możemy kontrolować, jak te pola są modyfikowane i zapewnić, że zawsze będą miały poprawne wartości.

## 1.2. Interfejs `LibraryItem`
Interfejs `LibraryItem` będzie oznaczał dowolny przedmiot dostępny w bibliotece do wypożyczenia. Interfejs ten będzie **definiował metody**, które muszą być zaimplementowane przez klasy reprezentujące różne rodzaje przedmiotów, takie jak książki, magazyny, filmy i muzyka.

W naszym przypadku `LibraryItem` będzie definiował metodę `getTitle()`, która zwraca tytuł przedmiotu, oraz metodę `info()`, która zwraca informacje o przedmiocie w formacie zależnym od klasy, która implementuje ten interfejs.

### 1.2.1. Implementacja interfejsu
1. W katalogu `model` stwórz katalog `item`.
   
   Będzie to katalog, w którym będziemy przechowywać wszystkie interfejsy i klasy reprezentujące przedmioty dostępne w bibliotece i ich właściwości.
2. W katalogu `item` stwórz interfejs `LibraryItem`.
3. Dodaj metodę `getTitle()`, która będzie zwracać tytuł przedmiotu jako `String`.
4. Dodaj **domyślną** metodę `info()`, która będzie zwracała `String` w formacie `Tytuł: {title}`. 
   
   Ta metoda będzie mogła (ale nie musi) być nadpisana przez klasy implementujące ten interfejs, aby zwracać bardziej szczegółowe informacje o przedmiocie.

#### Poprawna implementacja interfejsu `LibraryItem` powinna wyglądać następująco:
```java
package project.model.item;

public interface LibraryItem {

    String getTitle();

    // Ważne: Metoda info() jest domyślna, co oznacza, że klasy
    // implementujące ten interfejs mogą ją nadpisać, ale nie muszą.
    default String info() {
        return "Tytuł: " + getTitle();
    }

}
```

> ### Dlaczego interfejs, a nie klasa abstrakcyjna?
> Interfejsy są bardziej elastyczne niż klasy abstrakcyjne, ponieważ pozwalają na **implementację wielu interfejsów przez jedną klasę**.
> Dzięki temu możemy łatwiej rozszerzać nasz system o nowe rodzaje przedmiotów w przyszłości, bez konieczności zmiany istniejących klas.
> Interfejsy również nie narzucają hierarchii dziedziczenia, co daje większą swobodę w projektowaniu systemu.
> 
> Zobaczysz, że podczas dalszego rozwoju aplikacji będzie to nam na rękę!

> ### Co to jest metoda domyślna?
> Metoda domyślna to metoda w interfejsie, która ma swoją implementację.
> Dzięki temu klasy implementujące ten interfejs mogą korzystać z tej implementacji, ale mogą ją również nadpisać,
> jeśli potrzebują innej logiki.
> 
> Metody domyślne definiuje się za pomocą słowa kluczowego `default` przed deklaracją metody w interfejsie.

## 1.3. Klasa `User` - użytkownik biblioteki
Klasa `User` będzie reprezentować pojedynczego użytkownika biblioteki, który może wypożyczać lub oddawać przedmioty,
które wcześniej wypożyczył.
`User` będzie dziedziczył po `Person` a dodatkowo zawierał swój własny identyfikator oraz listę wypożyczonych przedmiotów.

### 1.3.1. Implementacja klasy
1. W katalogu `model` stwórz klasę `User`, która będzie dziedziczyć po klasie `Person`.
2. Dodaj **prywatne** pole `userId` typu `final int`, które będzie unikalnym identyfikatorem użytkownika.
3. Dodaj **prywatne** pole `borrowedItems`, które będzie listą przechowującą wypożyczone przedmioty.
   - Użyj typu `final List<LibraryItem>`, będzie to pierwsza relacja między klasami, gdzie `User` będzie przechowywał listę przedmiotów implementujących interfejs `LibraryItem`.
4. Dodaj **publiczny** konstruktor, który przyjmuje imię, nazwisko i identyfikator użytkownika jako argumenty i inicjalizuje odpowiednie pola.
5. Dodaj **publiczną** metodę `getUserId()`, która zwraca identyfikator użytkownika.
6. Dodaj **publiczną** metodę `getBorrowedItems()`, która zwraca listę wypożyczonych przedmiotów.
7. Dodaj **publiczną** metodę `addItem(LibraryItem item)`, `hasItem(LibraryItem item)` i `removeItem(LibraryItem item)`.
   - `addItem(LibraryItem item)` - dodaje przedmiot do listy wypożyczonych przedmiotów.
   - `hasItem(LibraryItem item)` - sprawdza, czy użytkownik ma dany przedmiot wypożyczony.
     - Metoda ta powinna zwracać `true`, jeśli użytkownik ma dany przedmiot wypożyczony, w przeciwnym razie `false`.
   - `removeItem(LibraryItem item)` - usuwa przedmiot z listy wypożyczonych przedmiotów.
     - Podczas usuwania przedmiotu sprawdź, czy użytkownik posiada ten przedmiot.
       Jeśli nie, rzuć wyjątek `IllegalArgumentException` z komunikatem `"Użytkownik nie posiada: {tytuł}"`.
       Zamień `{tytuł}` na tytuł przedmiotu, który próbuje zostać usunięty.
   - Do stworzenia tych metod przyjrzyj się metodom z interfejsu `List`.
8. Nadpisz metodę `info()` z klasy `Person`, aby zwracała informacje o użytkowniku w formacie:
   <br>
   `{firstName} {lastName} ({userId}): {X} wypożyczone przedmioty`, gdzie `X` to liczba wypożyczonych przedmiotów przez użytkownika.

#### Poprawna implementacja klasy `User` powinna wyglądać następująco:
```java
public class User extends Person {

   private final int userId;
   private final List<LibraryItem> borrowedItems = new ArrayList<>();

   public User(String firstName, String lastName, int userId) {
      super(firstName, lastName);
      this.userId = userId;
   }

   @Override
   public String info() {
      return this.getFullName() + " (" + userId + "): " + borrowedItems.size() + " wypożyczone przedmioty";
   }

   public int getUserId() {
      return userId;
   }

   public List<LibraryItem> getBorrowedItems() {
      return borrowedItems;
   }

   public void addItem(LibraryItem item) {
      borrowedItems.add(item);
   }

   public boolean hasItem(LibraryItem item) {
      return borrowedItems.contains(item);
   }

   public void removeItem(LibraryItem item) {
      if (!hasItem(item)) {
         throw new IllegalArgumentException("Użytkownik nie posiada: " + item.getTitle());
      }
      borrowedItems.remove(item);
   }

}
```

W ten sposób otrzymaliśmy pierwszą relację dziedziczenia między klasami, gdzie `User` dziedziczy po `Person`:

<p><img src="/assets/User-Person-Relation.png" alt="User-Person" width="600"/></p>

> ### Jak działa `final` w polach?
> Słowo kluczowe `final` oznacza, że pole nie może być zmienione po jego inicjalizacji.
> 
> Często używamy `final` w polach, które powinny być stałe i niezmienne, takie jak identyfikatory użytkowników czy
> tytuły książek.

> ### Co oznacza `@Override`?
> Adnotacja `@Override` jest używana do oznaczenia, że metoda w klasie potomnej nadpisuje metodę z klasy nadrzędnej.
> 
> Służy jako informacja dla kompilatora i innych programistów, że metoda ta jest zamierzona do nadpisania metody
> z klasy nadrzędnej.
> 
> #### Czy muszę jej używać?
> **Nie**, ale warto. Adnotacja jasno wskazuje, że metoda jest nadpisywana i pozwala uniknąć błędów, jeśli nazwa
> metody lub jej sygnatura zostanie zmieniona w klasie nadrzędnej.

## 1.4 Tworzenie klasy `Book`
Pierwszym rodzajem przedmiotu możliwym do wypożyczenia będzie książka, która powinna implementować interfejs `LibraryItem`
i zawierać dodatkowe informacje specyficzne dla książek, takie jak **autor**, **kod ISBN** i **liczba stron**.

<p><img src="/assets/Book-LibraryItem-Relation.png" alt="User-Person" width="500"/></p>

Aby jeszcze bardziej urozmaicić naszą strukturę, stworzymy `Book` jako klasę **abstrakcyjną**, która będzie dziedziczona przez inne konkretne rodzaje książek.

1. W katalogu `item` utwórz podkatalog `book`.
   
   Będzie to katalog, w którym będziemy przechowywać klasy reprezentujące różne rodzaje książek.
2. W katalogu `book` stwórz klasę abstrakcyjną `Book`, która będzie implementować interfejs `LibraryItem`.
3. Dodaj **prywatne** pola:
   - `title` typu `final String` - tytuł książki.
   - `author` typu `final String` - autor książki.
   - `isbn` typu `final String` - numer ISBN książki.
   - `pages` typu `final int` - liczba stron w książce.
4. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISBN i liczbę stron jako argumenty i inicjalizuje odpowiednie pola.
5. Zaimplementuj metodę `getTitle()` z interfejsu `LibraryItem`, która zwraca tytuł książki.
6. Dodaj dodatkowe **publiczne** metody `getAuthor()`, `getIsbn()` i `getPages()`, które zwracają odpowiednio autora, ISBN i liczbę stron książki.
7. Nadpisz metodę `info()` z interfejsu `LibraryItem`, aby zwracała informacje o książce w formacie:
   <br>
   `"{tytuł}", {autor} (strony: {strony}, ISBN: {isbn})`.
   - Zamień `{tytuł}`, `{autor}`, `{strony}` i `{isbn}` na odpowiednie wartości z pól klasy.
   - Aby wypisać znak `"` w Stringu, użyj znaku `\` przed cudzysłowem, np. `\"`.

#### Poprawna implementacja klasy `Book` powinna wyglądać następująco:
```java
public abstract class Book implements LibraryItem {

   private final String title;
   private final String author;
   private final String isbn;
   private final int pages;

   public Book(String title, String author, String isbn, int pages) {
      this.title = title;
      this.author = author;
      this.isbn = isbn;
      this.pages = pages;
   }

   @Override
   public String getTitle() {
      return title;
   }

   @Override
   public String info() {
      return "\"" + getTitle() + "\", " + author + " (strony: " + pages + ", ISBN: " + isbn + ")";
   }

   public String getAuthor() {
      return author;
   }

   public String getIsbn() {
      return isbn;
   }

   public int getPages() {
      return pages;
   }

}
```

> ### Dlaczego klasa abstrakcyjna, a nie zwykła klasa?
> Klasa `Book` jest abstrakcyjna, ponieważ nie chcemy, aby była instancjonowana bezpośrednio, ale posiadała wspólne pola i metody dla
> wszystkich rodzajów książek, które będą dziedziczyć po tej klasie.
> Dzięki temu możemy łatwiej rozszerzać nasz system o nowe rodzaje książek w przyszłości, bez konieczności duplikowania kodu.

Mając taką podstawę, możemy teraz stworzyć konkretne rodzaje książek, które będą dziedziczyć po klasie `Book`.

## 1.5 Rodzajaje książek: `Textbook`, `Novel`, `Manga`
Pierwszymi konkretnymi rodzajami książek, które stworzymy, będą:
- `Textbook` - podręcznik
- `Novel` - powieść
- `Manga` - japoński komiks

Każda z tych klas będzie dziedziczyć po klasie `Book` i dodawać swoje specyficzne pola oraz metody.

### 1.5.1. Textbook

1. W katalogu `book` stwórz klasę `Textbook`, która będzie dziedziczyć po klasie `Book`.
2. Dodaj **prywatne** pole `subject` typu `String`, które będzie przechowywać przedmiot, którego dotyczy podręcznik.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISBN, liczbę stron i przedmiot jako argumenty i inicjalizuje odpowiednie pola.
   - Z racji, że rozszerzamy abstrakcyjną klasę `Book`, musimy wywołać konstruktor klasy nadrzędnej `Book` w konstruktorze klasy `Textbook`.
   - Użyj słowa kluczowego `super` do wywołania konstruktora klasy `Book` z odpowiednimi argumentami.
     ##### Przykład:
     ```java
     super(title, author, isbn, pages);
     ```
   - Słowo kluczowe `super` odnosi się do klasy nadrzędnej i pozwala na wywołanie jej konstruktora lub metod.
4. Dodaj **publiczną** metodę `getSubject()`, która zwraca przedmiot podręcznika.

#### Poprawna implementacja klasy `Textbook` powinna wyglądać następująco:
```java
public class Textbook extends Book {

    private final String subject;

    public Textbook(String title, String author, String isbn, int pages, String subject) {
        super(title, author, isbn, pages);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

}
```

> ### Dlaczego używamy `super` w konstruktorze?
> Słowo kluczowe super odnosi się do klasy nadrzędnej (w tym przypadku `Book`). Wywołanie `super(...)` w konstruktorze
> klasy potomnej (`Textbook`) służy do wywołania konstruktora z klasy nadrzędnej.
> 
> Musi to być pierwsza instrukcja w konstruktorze, ponieważ Java wymaga, aby obiekt klasy nadrzędnej został w pełni
> zainicjalizowany, zanim zaczniemy inicjalizować pola specyficzne dla klasy potomnej.
> To zapewnia, że wszystkie odziedziczone pola (jak title czy author) mają już swoje wartości,
> zanim przejdziemy do ustawiania pola subject.

### 1.5.2. Novel

1. W katalogu `book` stwórz klasę `Novel`, która będzie dziedziczyć po klasie `Book`.
2. Dodaj **prywatne** pole `genre` typu `String`, które będzie przechowywać gatunek powieści.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISBN, liczbę stron i gatunek jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `getGenre()`, która zwraca gatunek powieści.

#### Poprawna implementacja klasy `Novel` powinna wyglądać następująco:
```java
public class Novel extends Book {

    private final String genre;

    public Novel(String title, String author, String isbn, int pages, String genre) {
        super(title, author, isbn, pages);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

}
```

### 1.5.3. Manga

1. W katalogu `book` stwórz klasę `Manga`, która będzie dziedziczyć po klasie `Book`.
2. Dodaj **prywatną** listę `illustrators` typu `List<String>`, która będzie przechowywać imiona i nazwiska ilustratorów mangi.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISBN, liczbę stron i listę ilustratorów jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `getIllustrators()`, która zwraca listę ilustratorów mangi.

#### Poprawna implementacja klasy `Manga` powinna wyglądać następująco:
```java
public class Manga extends Book {

    private final List<String> illustrators;

    public Manga(String title, String author, String isbn, int pages, List<String> illustrators) {
        super(title, author, isbn, pages);
        this.illustrators = illustrators;
    }

    public List<String> getIllustrators() {
        return illustrators;
    }

}
```

<br>

> Zauważ, że nie nadpisujemy metody `info()`, ponieważ klasa `Book` już ją implementuje i zwraca wszystkie potrzebne informacje.
> Jeśli jednak chcielibyśmy dodać dodatkowe informacje specyficzne dla danego rodzaju książki,
> moglibyśmy nadpisać tę metodę w odpowiedniej klasie.

W te sposób otrzymaliśmy trzy konkretne rodzaje książek, które dziedziczą po klasie `Book` i implementują swoje specyficzne pola i metody.

<img src="/assets/Book-LibraryItem.png" alt="Book" width="800"/>

> ### Co nam dało to podejście?
> Dzięki temu podejściu możemy łatwo rozszerzać nasz system o nowe rodzaje książek w przyszłości,
> bez konieczności duplikowania kodu.
> Każda nowa klasa książki będzie dziedziczyć po klasie `Book` i implementować swoje specyficzne pola i metody,
> co pozwoli nam na łatwe zarządzanie różnymi rodzajami książek w bibliotece.

## 1.6 Testowanie tworzenia użytkownika i książek

Aby przetestować nasze klasy `User` i `Book`, stwórz przykładowe obiekty w istniejącej już klasie `Main` w katalogu `project`.

1. W katalogu `project` otwórz plik `Main.java`.
2. W metodzie `main` stwórz obiekt `User` z przykładowymi danymi, np.:
   ```java
   User janKowalski = new User("Jan", "Kowalski", 1);
   User adamNowak = new User("Adam", "Nowak", 2);
   ```
3. Stwórz kilka obiektów `Textbook`, `Novel` i `Manga` z przykładowymi danymi, np.:
   ```java
   Textbook textbook = new Textbook("Analiza Matematyczna", "Jan Nowak", "978-83-123456-7", 300, "Matematyka");
   Novel novel = new Novel("W pustyni i w puszczy", "Henryk Sienkiewicz", "978-83-123456-8", 400, "Przygodowa");
   Manga manga = new Manga("Naruto", "Masashi Kishimoto", "978-83-123456-9", 200, List.of("Masashi Kishimoto", "Yasuharu Takanashi"));
   ```
4. Dodaj te przedmioty do wypożyczonych przedmiotów użytkownika, np.:
   ```java
   janKowalski.addItem(textbook);
   janKowalski.addItem(novel);
   adamNowak.addItem(manga);
   ```
5. Wyświetl informacje o użytkownikach i wypożyczonych przedmiotach, np.:
   ```java
   System.out.println(janKowalski.info());
   System.out.println(adamNowak.info());
   System.out.println(textbook.info());
   System.out.println(novel.info());
   System.out.println(manga.info());
   ```
6. Uruchom program `Main`, aby sprawdzić, czy wszystko działa poprawnie i czy informacje o użytkownikach i przedmiotach są wyświetlane zgodnie z oczekiwaniami.
   
   Wynik powinien wyglądać w taki sposób:
    ```text
    Jan Kowalski (1): 2 wypożyczone przedmioty
    Adam Nowak (2): 1 wypożyczone przedmioty
    "Analiza Matematyczna", Jan Nowak (strony: 300, ISBN: 978-83-123456-7)
    "W pustyni i w puszczy", Henryk Sienkiewicz (strony: 400, ISBN: 978-83-123456-8)
    "Naruto", Masashi Kishimoto (strony: 200, ISBN: 978-83-123456-9)
    ```

Jeżeli wszystko działa poprawnie, to mamy już podstawową strukturę naszego systemu bibliotecznego, która pozwala na tworzenie użytkowników i książek.

## 1.7. Tworzenie klasy `Magazine`

Kolejnym rodzajem przedmiotu, który dodamy do naszego systemu bibliotecznego, będzie magazyn.
Magazyn będzie również implementował interfejs `LibraryItem` i będzie zawierał dodatkowe informacje specyficzne dla magazynów, takie jak **autor**,
**kod ISSN** i **numer wydania**.

### 1.7.1. Implementacja klasy

1. W katalogu `item` stwórz podkatalog `magazine`.
   
   Będzie to katalog, w którym będziemy przechowywać klasy reprezentujące magazyny.
2. W katalogu `magazine` stwórz abstrakcyjną klasę `Magazine`, która będzie implementować interfejs `LibraryItem`.
3. Dodaj **prywatne** pola:
   - `title` typu `final String` - tytuł magazynu.
   - `author` typu `final String` - autor magazynu.
   - `issn` typu `final String` - numer ISSN magazynu.
   - `issueNumber` typu `final int` - numer wydania magazynu.
4. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISSN i numer wydania jako argumenty i inicjalizuje odpowiednie pola.
5. Dodaj **publiczne** metody `getTitle()`, `getAuthor()`, `getIssn()` i `getIssueNumber()`, które zwracają odpowiednio tytuł, autora, ISSN i numer wydania magazynu.
6. Nadpisz metodę `info()` z interfejsu `LibraryItem`, aby zwracała informacje o magazynie w formacie:
   
   `"{title}", wydanie {issueNumber}, {author} (ISSN: {issn})`.
   - Zamień `{title}`, `{issueNumber}`, `{author}` i `{issn}` na odpowiednie wartości z pól klasy.
   - Aby wypisać znak `"` w Stringu, użyj znaku `\` przed cudzysłowem, np. `\"`.

Super, oddzieliliśmy klasę `Magazine` od innych przedmiotów, co tak jak w przypadku `Book` pozwoli nam na łatwe dodawanie nowych rodzajów magazynów.

## 1.8. Rodzaje magazynów: `NewsMagazine`, `ScienceMagazine`

Kolejnymi konkretnymi rodzajami magazynów, które stworzymy, będą:
- `NewsMagazine` - magazyn informacyjny.
- `ScienceMagazine` - magazyn naukowy.

Podobnie jak w `Book`, każda z tych klas będzie dziedziczyć po klasie `Magazine` i dodawać swoje specyficzne pola oraz metody.

### 1.8.1. NewsMagazine

1. W katalogu `magazine` stwórz klasę `NewsMagazine`, która będzie dziedziczyć po klasie `Magazine`.
2. Dodaj **prywatne** pole `featuredTopics` typu `List<String>`, które będzie przechowywać tematy przewodnie magazynu.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISSN, numer wydania i tematy przewodnie jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `getFeaturedTopics()`, która zwraca `featuredTopics`.

### 1.8.2. ScienceMagazine

1. W katalogu `magazine` stwórz klasę `ScienceMagazine`, która będzie dziedziczyć po klasie `Magazine`.
2. Dodaj **prywatne** pole `fieldOfStudy` typu `String`, które będzie przechowywać dziedzinę nauki, której dotyczy magazyn.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, autora, ISSN, numer wydania i dziedzinę nauki jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `getFieldOfStudy()`, która zwraca `fieldOfStudy`.

## 1.8.3. Testowanie tworzenia magazynów

Aby przetestować nasze klasy `Magazine`, `NewsMagazine` i `ScienceMagazine`, stwórz przykładowe obiekty w istniejącej już klasie `Main` w katalogu `project`.

1. W metodzie `main` stwórz obiekt `Magazine` z przykładowymi danymi, np.:
   ```java
   Magazine scienceMagazine = new ScienceMagazine("Nature", "John Doe", "1234-5678", 1, "Biologia");
   Magazine newsMagazine = new NewsMagazine("The Times", "Jane Smith", "8765-4321", 2, List.of("Polityka", "Ekonomia"));
   ```
2. Następnie dodaj te magazyny do wypożyczonych przedmiotów użytkownika, np.:
   ```java
   janKowalski.addItem(scienceMagazine);
   adamNowak.addItem(newsMagazine);
   ```
3. Dodaj wyświetlanie informacji o magazynach, np.:
   ```java
   System.out.println(scienceMagazine.info());
   System.out.println(newsMagazine.info());
   System.out.println("Szczegółowe informacje o " + scienceMagazine.getTitle() + ":");
   System.out.println("  Tytuł: " + scienceMagazine.getTitle());
   System.out.println("  Autor: " + scienceMagazine.getAuthor());
   System.out.println("  ISSN: " + scienceMagazine.getIssn());
   System.out.println("  Numer wydania: " + scienceMagazine.getIssueNumber());
   System.out.println("  Dziedzina nauki: " + scienceMagazine.getFieldOfStudy());
   ```
4. Teraz oprócz informacji o użytkownikach, powinieneś zobaczyć również informacje o magazynach:
   ```text
   Jan Kowalski (1): 2 wypożyczone przedmioty
   Adam Nowak (2): 2 wypożyczone przedmioty
   "Nature", wydanie 1, John Doe (ISSN: 1234-5678)
   "The Times", wydanie 2, Jane Smith (ISSN: 8765-4321)
   Szczegółowe informacje o Nature:
     Tytuł: Nature
     Autor: John Doe
     ISSN: 1234-5678
     Numer wydania: 1
     Dziedzina nauki: Biologia
   ```
   
Jeżeli wszystko działa poprawnie, to udało nam się dodać nowe rodzaje przedmiotów do naszego systemu bibliotecznego.

## 1.9. Ulepszenie struktury: interfejs `Authored` z `Author` oraz refaktoryzacja klas `Book` i `Magazine`

Zauważ, że zarówno klasa `Book`, jak i klasa `Magazine` mają pole `author`, które przechowuje autora przedmiotu.
Aby uniknąć duplikacji kodu i zwiększyć elastyczność naszego systemu, możemy stworzyć interfejs `Authored`, który będzie definiował autorów danego przedmiotu.
W ten sposób stworzyć część wspólną dla wszystkich przedmiotów, które mają autorów, niezależnie od tego, czy są to książki, magazyny czy inne przedmioty.

Dodatkowo co w przypadku, jeżeli przedmiot ma więcej niż jednego autora?
Aby to obsłużyć, możemy stworzyć klasę `Author`, która będzie reprezentować pojedynczego autora i będzie zawierać jego imię, nazwisko oraz pseudonim.
Interfejs `Authored` będzie zawierał metodę `getAuthors()`, która zwraca listę autorów (`List<Author>`).

W ten sposób będziemy mogli łatwo zarządzać autorami przedmiotów w bibliotece, niezależnie od tego, czy są to książki, magazyny czy inne przedmioty.

> ### Czym jest refaktoryzacja?
> Refaktoryzacja to proces ulepszania struktury istniejącego kodu bez zmieniania jego zewnętrznego zachowania.
> Wyobraź sobie, że masz działający silnik, ale jego wewnętrzne części są chaotycznie ułożone.
> Rozbierasz go i składasz na nowo, używając lepszych, bardziej uporządkowanych komponentów.
> Z zewnątrz silnik nadal robi to samo, ale teraz jest łatwiejszy w utrzymaniu, naprawie i dalszej rozbudowie.
> 
> W naszym przypadku *refaktoryzujemy* sposób obsługi autorów, aby kod był czystszy, unikał powtórzeń i był gotowy na przyszłe zmiany (np. obsługę wielu autorów). To jedna z najważniejszych umiejętności każdego programisty.

W naszym przypadku "refaktoryzujemy" sposób obsługi autorów, aby kod był czystszy, unikał powtórzeń i był gotowy na przyszłe zmiany (np. obsługę wielu autorów). To jedna z najważniejszych umiejętności każdego programisty.

### 1.9.1. Klasa `Creator`

Żeby podążać za zasadą [pojedynczej odpowiedzialności](https://pl.wikipedia.org/wiki/Zasada_jednej_odpowiedzialno%C5%9Bci), możemy stworzyć klasę `Creator`, która będzie reprezentować osobę tworzącą przedmiot biblioteczny.

Klasa ta będzie dziedziczyć po klasie `Person` i będzie zawierać dodatkowe informacje specyficzne dla twórcy, takie jak pseudonim, data urodzenia i data śmierci (jeśli dotyczy).

1. W katalogu `item` stwórz klasę `Creator`, która będzie dziedziczyć po klasie `Person`.
2. Dodaj **prywatne** pole `pseudonym` typu `final String`, które będzie przechowywać pseudonim twórcy.
3. Dodaj **prywatne** pole `birthDate` typu `final LocalDate`, które będzie przechowywać datę urodzenia twórcy.
4. Dodaj **prywatne** pole `deathDate` typu `LocalDate`, które będzie przechowywać datę śmierci twórcy.
5. Dodaj **publiczny** konstruktor, który przyjmuje imię, nazwisko, pseudonim, datę urodzenia i datę śmierci (jeśli dotyczy) jako argumenty i inicjalizuje odpowiednie pola.
   - Użyj słowa kluczowego `super` do wywołania konstruktora klasy `Person` z odpowiednimi argumentami.
6. Dodaj **publiczne** metody `getPseudonym()`, `getBirthDate()` i `getDeathDate()`, które zwracają odpowiednio pseudonim, datę urodzenia i datę śmierci twórcy.
7. Dodaj **publiczną** metodę dla settera `setDeathDate(LocalDate deathDate)`, która ustawia datę śmierci twórcy.
   - Metoda ta powinna przyjmować argument `deathDate` typu `LocalDate` i ustawiać pole `deathDate` na tę wartość.
   - Jeśli twórca jeszcze żyje, pole `deathDate` powinno pozostać `null`.
8. Nadpisz metodę `getFullname()` z klasy `Person`, aby zwracała pseudonim autora, jeśli jest dostępny:
   - Jeśli pseudonim jest dostępny, zwróć `{pseudonym}`.
   - Jeśli pseudonim nie jest dostępny, zwróć `{firstName} {lastName}`.
   - Zamień `{firstName}`, `{lastName}` i `{pseudonym}` na odpowiednie wartości z pól klasy.
9Nadpisz metodę `info()` z klasy `Person`, aby zwracała informacje o twórcy w formacie:
   - Jeśli autor jeszcze żyje:
     - `{pseudonym} ({firstName} {lastName}), {birthDate}`.
   - Jeśli autor nie żyje: 
     - `{pseudonym} ({firstName} {lastName}), {birthDate}-{deathDate}`.
   - Zamień `{pseudonym}`, `{firstName}`, `{lastName}`, `{birthDate}` i `{deathDate}` na odpowiednie wartości z pól klasy.

> ### Co nam da ta klasa?
> Klasa `Creator` pozwoli nam na odseparowanie twórców od innych osób, takich jak użytkownicy biblioteki.
> Oprócz tego da nam solidny entry-point do dalszego rozwijania systemu, np. dodawania nowych rodzajów twórców,

> ### Dlaczego `deathDate` nie jest `final`?
> Ponieważ twórca może jeszcze żyć. :P
> 
> Możemy więc nie inicjalizować tego pola w konstruktorze, a pozostawić je jako `null`, jeśli autor jeszcze żyje.
> A w późniejszym czasie, jeśli autor umrze, możemy ustawić tę datę.

### 1.9.2. Klasa `Author`

Posiadając klasę `Creator`, możemy teraz stworzyć klasę `Author`, która będzie reprezentować autora książek i magazynów.
Klasa ta będzie dziedziczyć po klasie `Creator` i będzie zawierać dodatkowe informacje specyficzne dla autora, takie jak
języki, w których tworzy autor.

1. W katalogu `item` stwórz klasę `Author`, która będzie dziedziczyć po klasie `Creator`.
2. Dodaj **prywatne** pole `languages` typu `List<String>`, które będzie przechowywać języki, w których tworzy autor.
3. Dodaj **publiczny** konstruktor, który przyjmuje imię, nazwisko, pseudonim, datę urodzenia, datę śmierci
   (jeśli dotyczy) i listę języków jako argumenty i inicjalizuje odpowiednie pola.
   - Użyj słowa kluczowego `super` do wywołania konstruktora klasy `Creator` z odpowiednimi argumentami.
4. Dodaj **publiczną** metodę `getLanguages()`, która zwraca listę języków, w których tworzy autor.
5. Nadpisz metodę `info()` z klasy `Creator`, aby zwracała również języki:
   - Skorzystaj z metody `info()` z klasy `Creator` i dodaj do niej informacje o językach, w których tworzy autor w formacie:
      - `{info() z Creator}, języki: {languages}`.
   - Zamień `{info() z Creator}` i `{languages}` na odpowiednie wartości z pól klasy.

> ### W jaki sposób wywołać metodę `info()` z klasy `Creator` skoro ją nadpisujemy?
> Możemy użyć słowa kluczowego `super` do wywołania metody `info()` z klasy nadrzędnej `Creator`.
> ##### Przykład:
> ```java
> super.info();
> ```
> Słowo kluczowe `super` odnosi się do klasy nadrzędnej i pozwala na wywołanie jej metod lub pól.

### 1.9.3. Interfejs `Authored`

Aby umożliwić przedmiotom bibliotecznym posiadanie wielu autorów, stworzymy interfejs `Authored`,
który będzie definiował metody związane z autorami.

1. W katalogu `item` stwórz interfejs `Authored`.
2. Dodaj metodę `getAuthors()`, która będzie zwracać listę autorów (`List<Author>`).
3. Dodaj **domyślną** metodę `getAuthorNames()`, która zwraca ciąg znaków z imionami i nazwiskami autorów, oddzielonymi przecinkami.
   - Metoda ta powinna wykorzystywać metodę `getFullName()` z klasy `Creator` do uzyskania pełnych imion i nazwisk autorów
     oraz ich pseudonimów, jeśli są dostępne.
   - Zadbaj o to, aby autorzy byli poprawnie oddzieleni przecinkami, np. żeby nie było przecinka na końcu listy.

> ### Jak oddzielić autorów?
> <details>
> <summary>Kliknij aby odsłonić</summary>
> <p>Do oddzielenia autorów możesz skorzystać z pętli <code>for</code> i <code>StringBuilder</code> lub strumieni.</p>
> 
> <h3>Przykład użycia z pętlą <code>for</code> i <code>StringBuilder</code>:</h3>
> <pre>
> StringBuilder authors = new StringBuilder();
> for (int i = 0; i < getAuthors().size(); i++) {
>     Author author = getAuthors().get(i);
>     authors.append(author.getFullName());
>     if (i < getAuthors().size() - 1) {
>         authors.append(", ");
>     }
> }
> </pre>
> <p>W tym przykładzie używamy pętli <code>for</code> do iteracji po liście autorów i budowania ciągu znaków za pomocą <code>StringBuilder</code> z ich pseudonimami lub pełnymi imionami i nazwiskami, oddzielając ich przecinkami.</p>
>
> <h3>Przykład użycia strumieni:</h3>
> <pre>
> String authors = authorsList.stream()
>     .map(author -> author.getPseudonym() != null ? author.getPseudonym() : author.getFullName())
>     .collect(Collectors.joining(", "));
> </pre>
> <p>W tym przykładzie używamy strumieni do przetworzenia listy autorów i połączenia ich pseudonimów lub pełnych imion i nazwisk w jeden ciąg znaków, oddzielony przecinkami.</p>
>
> <hr>
> <p>W obu przypadkach, jeśli autor nie ma pseudonimu, używamy metody `getFullName()` z klasy `Person`, aby uzyskać jego pełne imię i nazwisko.</p>
> </details>

Teraz możemy zrefaktoryzować nasze klasy `Book` i `Magazine`, aby implementowały interfejs `Authored` i zamiast pojedynczego pola `author` miały listę autorów.

### 1.9.4. Refaktoryzacja klas `Book`

1. Zaktualizuj klasę `Book`, aby implementowała interfejs `Authored`.
2. Zamiast pojedynczego pola `author`, dodaj **prywatne** pole `authors` typu `List<Author>`.
3. Usuń pole `author` oraz metodę `getAuthor()`, zastąp je metodą `getAuthors()`, która zwraca `authors`.
4. Zaktualizuj konstruktory klas `Book`, `Textbook`, `Novel` i `Manga`, aby przyjmowały listę autorów jako argumenty
   i inicjalizowały pole `authors`.
5. Zaktualizuj metodę `info()` w klasie `Book`, aby uwzględniała wszystkich autorów książki:
   - Zamiast jednego autora, metoda powinna zwracać wszystkich autorów w formacie:
     
     `"{tytuł}", {autorzy} (strony: {strony}, ISBN: {isbn})`, gdzie `{autorzy}` to lista autorów oddzielona przecinkami.
     - Skorzystaj z metody `getAuthorNames()` z interfejsu `Authored`, aby uzyskać listę autorów w odpowiednim formacie.
6. Upewnij się, że nie zapomniałeś zaktualizować wszystkich miejsc, gdzie wcześniej używano pola `author`.

#### 1.9.4.1 Refaktoryzacja mangi

Nie zapomnij również zaktualizować pola `illustrators` w klasie `Manga`, aby było typu `List<Author>` zamiast `List<String>`.

### 1.9.5. Refaktoryzacja klas `Magazine`

Powtórz podobne kroki dla klas `Magazine`.

### 1.9.6. Testowanie ulepszeń

Aby przetestować nasze ulepszenia, zaktualizuj klasę `Main` w katalogu `project`.
1. W katalogu `project` otwórz plik `Main.java`.
2. Zaktualizuj tworzenie obiektów `Textbook`, `Novel` i `Manga`, aby używały listy autorów zamiast pojedynczego autora, np.:
   ```java
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
   ```
3. Dodaj te przedmioty do wypożyczonych przedmiotów użytkownika, np.:
   ```java
   janKowalski.addItem(textbook);
   janKowalski.addItem(novel);
   adamNowak.addItem(manga);
   adamNowak.addItem(scienceMagazine);
   adamNowak.addItem(newsMagazine);
   ```
4. Wyświetl informacje o użytkownikach i wypożyczonych przedmiotach, np.:
   ```java
   System.out.println(janKowalski.info());
   System.out.println(adamNowak.info());
   System.out.println(textbook.info());
   System.out.println(novel.info());
   System.out.println(manga.info());
   System.out.println(scienceMagazine.info());
   System.out.println(newsMagazine.info());
   ```

Po uruchomieniu `Main`, powinieneś zobaczyć informacje o użytkownikach i przedmiotach, które zawierają listę autorów
oraz ich pseudonimy, jeśli są dostępne. Wynik powinien wyglądać mniej więcej tak:
```text
Jan Kowalski (1): 3 wypożyczone przedmioty
Adam Nowak (2): 2 wypożyczone przedmioty
"Analiza Matematyczna", J.N. (strony: 300, ISBN: 978-83-123456-7)
"W pustyni i w puszczy", Henryk Sienkiewicz (strony: 400, ISBN: 978-83-123456-8)
"Naruto", Masashi Kishimoto, Yasuharu Takanashi (strony: 200, ISBN: 978-83-123456-9)
"Nature", wydanie 1, John Doe (ISSN: 1234-5678)
"The Times", wydanie 2, Jane Smith (ISSN: 8765-4321)
```

Jeżeli program się kompiluje i wyświetla poprawne informacje o użytkownikach i przedmiotach, to znaczy, że nasze 
ulepszenia zostały poprawnie zaimplementowane.

> ### Dlaczego to ulepszenie jest ważne?
> Dzięki temu ulepszeniu możemy łatwo zarządzać autorami przedmiotów w bibliotece, niezależnie od tego, czy są to książki, magazyny czy inne przedmioty.
> Dodatkowo, jeśli w przyszłości dodamy nowe rodzaje przedmiotów, które również będą miały autorów,
> będziemy mogli po prostu zaimplementować interfejs `Authored` i skorzystać z tej samej logiki zarządzania autorami.

> ### Czy nie lepiej byłoby użyć abstrakcyjnej klasy?
> To zależy od kontekstu i wymagań projektu. Jeśli wszystkie przedmioty, które mają autorów, będą miały wspólne pola 
> i metody, to abstrakcyjna klasa może być lepszym rozwiązaniem. Jednak w naszym przypadku interfejs `Authored`
> jest wystarczający, ponieważ nie mamy wspólnych pól ani metod poza listą autorów.

## 1.10. Nowy rodzaj przedmiotu: `MusicTrack`

Podobno w bibliotece można wypożyczać nie tylko książki i magazyny, ale także muzykę.
W takim razie dodamy nowy rodzaj przedmiotu, który będzie reprezentować utwór muzyczny.

Najpierw zastanówmy się, jakie informacje powinien zawierać taki utwór muzyczny.
- Tytuł utworu — można skorzystać z pola `title` z interfejsu `LibraryItem`.
- Autorzy utworu — można skorzystać z interfejsu `Authored`, który już mamy.
- Czas trwania utworu — pole unikalne dla utworu muzycznego, które będzie przechowywać czas trwania w sekundach.
- Gatunek muzyczny — również unikalne, które będzie przechowywać gatunek muzyczny utworu.

Czas trwania utworu możemy przechowywać jako `int`, który będzie reprezentować liczbę sekund.
Stworzymy w tym celu interfejs `Playable`, będzie on oznaczał przedmiot, który można odtwarzać.

Dla gatunku muzycznego możemy użyć specjalnego Enum'a `MusicGenre`, który będzie zawierał różne gatunki muzyczne,
takie jak:
- ROCK
- POP
- JAZZ
- CLASSICAL
- HIP_HOP
- ELECTRONIC
- METAL

Będzie to wygodne podejście, ponieważ pozwoli nam na łatwe dodawanie nowych gatunków muzycznych w przyszłości,
a także zapewni, że gatunek muzyczny będzie zawsze poprawny i zgodny z naszymi oczekiwaniami.

### 1.10.1. Interfejs `Playable`

1. W katalogu `item` stwórz interfejs `Playable`.
2. Dodaj metodę `getDuration()`, która będzie zwracać czas trwania utworu w sekundach (`int`).
3. Dodaj domyślną metodę `formatDuration()`, która będzie zwracać sformatowany czas trwania utworu w formacie `(hh:mm:ss)`.
   - Metoda ta powinna wykorzystywać metodę `getDuration()` do uzyskania czasu trwania w sekundach i konwertować
     go na poprawny format czasu.
     - Spróbuj wykorzystać metodę `String.format()` do prostego formatowania czasu.
   - Możesz użyć operatora dzielenia i reszty z dzielenia, aby uzyskać minuty i sekundy.

### 1.10.2. Enum `MusicGenre`

1. W katalogu `item` stwórz podkatalog `music`.
2. W katalogu `music` stwórz Enum `MusicGenre`.
3. Dodaj wartości, które będą reprezentować różne gatunki muzyczne:
   - `ROCK`
   - `POP`
   - `JAZZ`
   - `CLASSICAL`
   - `HIP_HOP`
   - `ELECTRONIC`
   - `METAL`

> ### Dlaczego Enum a nie klasa albo po prostu String?
> Enum pozwala zdefiniować z góry ustalony, zamknięty zbiór stałych wartości.
> Jest to znacznie lepsze rozwiązanie niż używanie Stringów ("ROCK", "POP") z kilku powodów:
> - **Bezpieczeństwo typów**: Masz gwarancję, że zmienna typu `MusicGenre` może przyjąć tylko jedną
> ze zdefiniowanych wartości. Nie da się przez pomyłkę przypisać jej wartości `String`.
> - **Czytelność**: Enumy są bardziej czytelne i zrozumiałe dla innych programistów.
> - **Rozszerzalność**: Jeśli w przyszłości będziesz chciał dodać nowe gatunki muzyczne, wystarczy dodać nową
> wartość do Enuma, a nie martwić się o poprawność danych.

### 1.10.3. Klasa `MusicTrack`

1. W katalogu `music` stwórz **abstrakcyjną** klasę `MusicTrack`, która będzie implementować interfejsy `LibraryItem`, `Authored` i `Playable`.
2. Dodaj **prywatne** pola:
   - `title` typu `final String` - tytuł utworu.
   - `authors` typu `final List<Author>` - lista autorów utworu.
   - `duration` typu `final int` - czas trwania utworu w sekundach.
   - `genre` typu `final MusicGenre` - gatunek muzyczny utworu.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, listę autorów, czas trwania i gatunek muzyczny jako argumenty
   i inicjalizuje odpowiednie pola.
4. Dodaj lub nadpisz **publiczne** metody:
   - `getTitle()` - zwraca tytuł utworu.
   - `getAuthors()` - zwraca listę autorów utworu.
   - `getDuration()` - zwraca czas trwania utworu w sekundach.
   - `getGenre()` - zwraca gatunek muzyczny utworu.
5. Nadpisz metodę `info()` z interfejsu `LibraryItem`, aby zwracała informacje o utworze w formacie:
   - `{autorzy} - {title} ({duration}) :: {genre}`, gdzie `{autorzy}` to lista autorów oddzielona przecinkami.
   - Skorzystaj z metody `getAuthorNames()` z interfejsu `Authored` oraz metody `formatDuration()` z interfejsu
     `Playable`, aby uzyskać odpowiednie wartości.

## 1.11. Rodzaje utworów muzycznych: `VocalTrack`, `InstrumentalTrack`

Kolejnymi konkretnymi rodzajami utworów muzycznych, które stworzymy, będą:
- `VocalTrack` - utwór muzyczny z wokalem.
- `InstrumentalTrack` - utwór muzyczny bez wokalu.

### 1.11.1. Klasa `VocalTrack`

1. W katalogu `music` stwórz klasę `VocalTrack`, która będzie dziedziczyć po klasie `MusicTrack`.
2. Dodaj **prywatne** pola:
    - `vocalists` typu `List<Author>` - lista wokalistów utworu.
    - `isExplicit` typu `boolean` - informacja, czy utwór zawiera wulgarny lub kontrowersyjny tekst.
    - `language` typu `String` - język, w którym jest wykonywany utwór.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, listę autorów, czas trwania, gatunek muzyczny,
   listę wokalistów, informację o wulgarnym tekście i język jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczne** metody:
   - `getVocalists()` - zwraca listę wokalistów utworu.
   - `isExplicit()` - zwraca informację, czy utwór zawiera wulgarny lub kontrowersyjny tekst.
   - `getLanguage()` - zwraca język, w którym jest wykonywany utwór.

### 1.11.2. Klasa `InstrumentalTrack`

1. W katalogu `music` stwórz klasę `InstrumentalTrack`, która będzie dziedziczyć po klasie `MusicTrack`.
2. Dodaj **prywatne** pola:
   - `instruments` typu `List<String>` - lista instrumentów użytych w utworze.
   - `isElectronic` typu `boolean` - informacja, czy utwór jest elektroniczny.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, listę autorów, czas trwania, gatunek muzyczny,
   listę instrumentów i informację o elektroniczności jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczne** metody:
   - `getInstruments()` - zwraca listę instrumentów użytych w utworze.
   - `isElectronic()` - zwraca informację, czy utwór jest elektroniczny.

## 1.12. Testowanie tworzenia utworów muzycznych

Aby przetestować nasze klasy `MusicTrack`, zaktualizuj klasę `Main` w katalogu `project`.

1. W katalogu `project` otwórz plik `Main.java`.
2. Stwórz obiekt `MusicTrack` z przykładowymi danymi, np.:
   ```java
   List<Author> musicAuthors = List.of(
           new Author(null, null, "rów babicze", null, null, List.of("Polski")));
   List<Author> vocalists = List.of(
           new Author(null, null, "Bardal", null, null, List.of("Polski")));
   VocalTrack musicTrack = new VocalTrack("W GORĄCEJ WODZIE COMPANY", musicAuthors, 167, 
           MusicGenre.HIP_HOP, vocalists, true, "Polski");
   ```
3. Dodaj ten utwór do wypożyczonych przedmiotów użytkownika, np.:
   ```java
   janKowalski.addItem(musicTrack);
   ```
4. Dodaj wyświetlanie informacji o utworze, np.:
   ```java
   System.out.println(musicTrack.info());
   System.out.println("Szczegółowe informacje o " + musicTrack.getTitle() + ":");
   System.out.println("  Tytuł: " + musicTrack.getTitle());
   System.out.println("  Autorzy: " + musicTrack.getAuthorsNames());
   System.out.println("  Czas trwania: " + musicTrack.formatDuration());
   System.out.println("  Gatunek: " + musicTrack.getGenre());
   System.out.println("  Wokaliści: " + musicTrack.getVocalists());
   System.out.println("  Wulgarny: " + musicTrack.isExplicit());
   System.out.println("  Język: " + musicTrack.getLanguage());
   ```
5. Teraz oprócz informacji o użytkownikach, powinieneś zobaczyć również informacje o utworach muzycznych:
   ```text
   rów babicze - W GORĄCEJ WODZIE COMPANY (00:02:47) :: HIP_HOP
   Szczegółowe informacje o W GORĄCEJ WODZIE COMPANY:
     Tytuł: W GORĄCEJ WODZIE COMPANY
     Autorzy: rów babicze
     Czas trwania: 00:02:47
     Gatunek: HIP_HOP
     Wokaliści: [project.model.item.Author@2328c243]
     Wulgarny: true
     Język: Polski
   ```
   
Jak można zauważyć, lista wokalistów jest wyświetlana jako referencja do obiektu `Author`, a nie jako ciąg znaków.
Aby poprawić to wyświetlanie, możemy nadpisać metodę `toString()` w klasie `Creator`, aby zwracała pełne imię i nazwisko
lub pseudonim autora.

### 1.12.1. Nadpisanie metody `toString()` w klasie `Creator`

W klasie `Creator` nadpisz metodę `toString()`, aby zwracała pełne imię i nazwisko lub pseudonim autora (możesz skorzystać z metody `getFullName()`).

Metoda `toString()` to jedna z kilku metod bazowej klasy `Object`, która jest używana do reprezentacji obiektu w postaci ciągu znaków, więc nadpisanie jej pozwoli nam
na łatwe wyświetlanie informacji o autorze w konsoli lub w innych miejscach, gdzie obiekt jest konwertowany na ciąg znaków.

> ### Skąd się bierze metoda `toString()`?
> Metoda `toString()` jest dziedziczona z klasy `Object`, która jest klasą bazową dla wszystkich klas w Javie.
> Każda klasa w Javie dziedziczy po `Object`, choć nie jest to jawnie widoczne.
> 
> Klasa `Object` dostarcza kilka podstawowych metod, takich jak `equals()`, `hashCode()`, `toString()` i inne,
> które są używane do podstawowych operacji na obiektach.
>
> Nadpisanie metody `toString()` pozwala na dostarczenie własnej implementacji, która będzie zwracać
> reprezentację obiektu w postaci ciągu znaków, co jest przydatne do debugowania i logowania.

> ### Jaka jest różnica między `toString()` a `info()`?
> Chociaż obie metody zwracają String, służą nieco innym celom:
> - `info()` to metoda, którą **sami zdefiniowaliśmy na potrzeby naszej aplikacji**.
>    
>   Jej celem jest dostarczenie ładnie sformatowanego, czytelnego dla użytkownika końcowego opisu obiektu
> - `toString()` to standardowa metoda z Javy, używana głównie do celów **technicznych i deweloperskich**.
>   Jest automatycznie wywoływana podczas logowania, debugowania, a także, gdy próbujesz wydrukować obiekt
>   bezpośrednio (np. `System.out.println(ksiazka)`).
> 
> Dobrą praktyką jest nadpisywanie `toString()`, aby dostarczała zwięzłej, deweloperskiej reprezentacji obiektu.
> W naszym projekcie często sprawiamy, że robi to samo co `info()` dla wygody, ale warto pamiętać o tym rozróżnieniu.

### 1.12.2. Ponowne testowanie utworów muzycznych

Po nadpisaniu metody `toString()` w klasie `Creator`, możemy ponownie przetestować nasze utwory muzyczne.
Tym razem, gdy wyświetlimy informacje o utworze muzycznym, lista wokalistów powinna być poprawnie sformatowana.

```
rów babicze - W GORĄCEJ WODZIE COMPANY (00:02:47) :: HIP_HOP
Szczegółowe informacje o W GORĄCEJ WODZIE COMPANY:
  Tytuł: W GORĄCEJ WODZIE COMPANY
  Autorzy: rów babicze
  Czas trwania: 00:02:47
  Gatunek: HIP_HOP
  Wokaliści: [rów babicze]
  Wulgarny: true
  Język: Polski
```

Jeżeli wszystko działa poprawnie, to udało nam się dodać już trzeci rodzaj przedmiotu do naszego systemu bibliotecznego.

## 1.13. Nowy rodzaj przedmiotu: `Video`

Skoro nasza biblioteka wypożycza nawet utwory muzyczne, to czemu nie miałaby wypożyczać filmów?
Tym razem dodamy nowy rodzaj przedmiotu, który będzie reprezentować film lub inny materiał wideo.

Jak zawsze najpierw zastanówmy się, jakie informacje powinien zawierać taki film.
- Tytuł filmu — można skorzystać z pola `title` z interfejsu `LibraryItem`.
- Czas trwania filmu — możemy skorzystać z interfejsu `Playable`, który już mamy.
- Reżyser filmu — moglibyśmy skorzystać z interfejsu `Authored`, ale lepiej będzie stworzyć osobny interfejs `Directed`,
  który będzie zawierał specjalny obiekt `Director`, reprezentujący reżysera filmu.
  - Dodatkowo reżyser może przechowywać specjalnego Enuma `DirectorAward`, który będzie odwzorowywał nagrody,
    jakie zdobył reżyser.

### 1.13.1. Reżyser i nagrody

Wpierw stwórzmy Enum `DirectorAward`, który będzie reprezentować nagrody zdobywane przez reżyserów.

1. W katalogu `item` stwórz enum `DirectorAward`.
2. Dodaj **prywatne** pole `fullName` typu `final String`, które będzie przechowywać pełną nazwę nagrody.
3. Stwórz konstruktor, który przyjmuje pełną nazwę nagrody jako argument i inicjalizuje pole `fullName`.
4. Dodaj **publiczną** metodę `getFullName()`, która zwraca pełną nazwę nagrody.
5. Dodaj wartości:
   - `OSCAR("Academy Award")`
   - `GOLDEN_GLOBE("Golden Globe Award")`
   - `BAFTA("British Academy Film Award")`
   - `POLISH_FILM_AWARD("Polska Nagroda Filmowa (Orły)")`

Teraz możemy stworzyć klasę `Director`, która będzie reprezentować reżysera filmu.

1. W katalogu `item` stwórz klasę `Director`.
2. Dodaj **prywatne** pole `awards` typu `List<DirectorAward>`, będzie to lista nagród zdobytych przez reżysera.
3. Dodaj **publiczny** konstruktor, który przyjmuje imię, nazwisko, pseudonim, datę urodzenia, datę śmierci (jeśli dotyczy)
   oraz listę nagród jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `getAwards()`, która zwraca listę nagród zdobytych przez reżysera.

### 1.13.2. Zabezpieczenie listy nagród

Aktualnie w metodzie `getAwards()` zwracamy instancje listy nagród.
Dzięki temu możemy modyfikować tę listę poza klasą `Director`, co nie zawsze może być pożądane.

Aby zabezpieczyć się przed modyfikacją listy nagród, możemy zwrócić niemodyfikowalną kopię tej listy.
W ten sposób obiekt listy będzie niemodyfikowalny poza klasą `Director`.

Daje nam to również możliwość definiowania sposób modyfikacji listy nagród w klasie `Director`, np. poprzez osobne
metody `addAward(DirectorAward award)` i `removeAward(DirectorAward award)`, które będą dodawać lub usuwać nagrody.

1. Zrefaktoruj metodę `getAwards()` w klasie `Director`, aby zwracała kopię listy nagród:
   - Zamiast zwracać `awards`, zwróć `Collections.unmodifiableList(awards)`.
2. Dodaj metody `addAward(DirectorAward award)` i `removeAward(DirectorAward award)`, które będą dodawać lub usuwać
   nagrody z wewnętrznej listy `awards`.

### 1.13.3. Interfejs `Directed`

Aby umożliwić przedmiotom bibliotecznym posiadanie reżysera, stworzymy interfejs `Directed`,
który będzie definiował metody związane z reżyserem.

1. W katalogu `item` stwórz interfejs `Directed`.
2. Dodaj metodę `getDirector()`, która będzie zwracać reżysera (`Director`).

### 1.13.4. Klasa `Video`

1. W katalogu `item` stwórz podkatalog `video`.
2. W katalogu `video` stwórz **abstrakcyjną** klasę `Video`, która będzie implementować interfejsy
`LibraryItem`, `Directed` i `Playable`.
3. Dodaj **prywatne** pola:
   - `title` typu `final String` - tytuł filmu.
   - `duration` typu `final int` - czas trwania filmu w sekundach.
   - `director` typu `final Director` - reżyser filmu.
4. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, czas trwania i reżysera jako argumenty
   i inicjalizuje odpowiednie pola.
5. Dodaj lub nadpisz **publiczne** metody:
   - `getTitle()` - zwraca tytuł filmu.
   - `getDuration()` - zwraca czas trwania filmu w sekundach.
   - `getDirector()` - zwraca reżysera filmu.
6. Nadpisz metodę `info()` z interfejsu `LibraryItem`, aby zwracała informacje o filmie w formacie:
   - `{title}, {director} ({duration})`
     - Zamień `{title}` na tytuł filmu, 
     - Zamień `{director}` na imię i nazwisko reżysera lub jego pseudonim, możesz do tego wykorzystać metodę
       `getFullName()` z klasy `Creator`.
     - Zamień `{duration}` na sformatowany czas trwania filmu w formacie `(hh:mm:ss)`. Wspomóż się metodą
       `formatDuration()` z interfejsu `Playable`.
7. Nadpisz metodę `toString()` w klasie `Video`, aby zwracała to samo, co metoda `info()`.
   - Dzięki temu, gdy wyświetlimy obiekt `Video` w konsoli, zobaczymy jego informacje w odpowiednim formacie.

## 1.14 Klasa `Movie`

Teraz możemy zabrać się za tworzenie konkretnych rodzajów filmów. 
Film fabularny to najpopularniejszy rodzaj filmu, więc zaczniemy od niego.

Najważniejszą częścią filmów fabularnych jest obsada aktorska.
Dlatego stworzymy pole `actors`, które będzie przechowywać listę aktorów występujących w filmie.

Jednak w tym przykładzie znacząco ulepszymy przechowywanie aktorów!
Zamiast przechowywać ich w liście `List<String>` lub `List<Author>` stworzymy dla nich osobną klasę `Actor` oraz
`ActingRole`, która będzie reprezentować rolę, jaką odgrywa aktor w filmie.

### 1.14.1. Klasa `Actor`

1. W katalogu `video` stwórz klasę `Actor`, która będzie dziedziczyć po klasie `Creator`.
2. Dodaj **prywatne** pole `isVoiceActor` typu `final boolean` będziemy mogli tego użyć, aby określić, czy aktor jest
   aktorem głosowym (np. w filmach animowanych).
3. Dodaj **publiczny** konstruktor, który przyjmuje imię, nazwisko, pseudonim, datę urodzenia, datę śmierci (jeśli dotyczy)
   oraz informację o tym, czy aktor jest aktorem głosowym jako argumenty i inicjalizuje odpowiednie pola.
4. Dodaj **publiczną** metodę `isVoiceActor()`, która zwraca informację, czy aktor jest aktorem głosowym.

### 1.14.2. Klasa `ActingRole`

1. W katalogu `video` stwórz klasę `ActingRole`.
2. Dodaj **prywatne** pola:
   - `name` typu `final String` - nazwa roli, jaką odgrywa aktor w filmie.
   - `description` typu `final String` - opis roli, może być pusty, jeśli nie jest potrzebny.
3. Dodaj **publiczny** konstruktor, który przyjmuje nazwę roli i opis jako argumenty
   i inicjalizuje odpowiednie pola.
4. Dodaj **publiczne** metody:
   - `getName()` - zwraca nazwę roli.
   - `getDescription()` - zwraca opis roli.
5. Nadpisz metodę `toString()`, aby zwracała nazwę roli i opis w formacie: `{name} ({description})`
   - Jeśli opis jest pusty, zamień `{description}` na `brak opisu`.

### 1.14.3. Klasa `Movie`

Po stworzeniu klas `Actor` i `ActingRole`, możemy w dogodny sposób przechowywać aktorów i ich role w filmie fabularnym.
Do przechowywania aktorów i ich ról użyjemy mapy `Map<Actor, List<ActingRole>>`, gdzie kluczem będzie aktor,
a wartością będzie lista ról, jakie odgrywa w filmie.

1. W katalogu `video` stwórz klasę `Movie`, która będzie dziedziczyć po klasie `Video`.
2. Dodaj **prywatne** pole `actors` typu `Map<Actor, List<ActingRole>>`, które będzie przechowywać aktorów i ich role.
3. Dodaj **publiczny** konstruktor, który przyjmuje tytuł, czas trwania, reżysera i mapę aktorów jako argumenty
   i inicjalizuje odpowiednie pola.
   - Jeśli mapa aktorów jest nullem, zainicjalizuj ją jako pustą mapę.
4. Dodaj **publiczne** metody:
   - `addActor(Actor actor, ActingRole... roles)` - dodaje aktora do filmu wraz z jego rolami.
     - Jeśli `actor` lub `roles` jest nullem, rzuć wyjątek `IllegalArgumentException`.
       - Dodaj wiadomość do wyjątku, że rola oraz aktor nie może być nullem.
     - Jeśli `roles` jest pustą tablicą, rzuć wyjątek `IllegalArgumentException`.
       - Dodaj wiadomość do wyjątku, że aktor musi mieć co najmniej jedną rolę.
     - Jeśli aktor już występuje w filmie, dodaj nowe role do istniejącej listy ról.
     - Możesz skorzystać z metody `computeIfAbsent()` z klasy `Map`, aby utworzyć nową listę ról, jeśli aktor nie istnieje.
   - `getActors()` - zwraca **niemodyfikowalne** zestawienie aktorów (`Set<Actor>`) występujących w filmie.
     - Możesz skorzystać z metody `keySet()` z klasy `Map`.
   - `getRolesForActor(Actor actor)` - zwraca **niemodyfikowalną** listę ról (`List<ActingRole>`) dla danego aktora.
     
     Jeżeli aktor nie występuje w filmie, zwróć pustą listę.
     - Możesz skorzystać z metody `getOrDefault()` z klasy `Map`, aby uzyskać listę ról dla danego aktora
       lub zwrócić pustą listę, jeśli aktor nie występuje w filmie.
   - `removeActor(Actor actor)` - usuwa aktora z filmu.
     - Jeśli `actor` jest nullem, rzuć wyjątek `IllegalArgumentException`.
     - Możesz skorzystać z metody `remove()` z klasy `Map`, aby usunąć aktora i jego role.
   - `removeRoleForActor(Actor actor, ActingRole role)` - usuwa konkretną rolę dla danego aktora.
     - Jeśli `actor` lub `role` jest nullem, rzuć wyjątek `IllegalArgumentException`.
     - Sprawdź, czy aktor występuje w filmie, a następnie usuń rolę z listy ról tego aktora.
     - Jeśli lista ról stanie się pusta po usunięciu roli, usuń aktora z mapy.
5. Nadpisz metodę `info()` z klasy `Video`, aby zwracała informacje o filmie w formacie:
   - `{title}, {director} ({duration}) :: {actors}`, gdzie `{actors}` to lista aktorów i ich ról oddzielonych przecinkiem
   w formacie:
     - `{actor} ({roles})`, gdzie `{actor}` to pełne imię i nazwisko lub pseudonim aktora,
       a `{roles}` to lista ról oddzielona przecinkami.
     - Skorzystaj z metody `getFullName()` z klasy `Creator` oraz metody `toString()` z klasy `ActingRole`.

W taki sposób stworzyliśmy klasę `Movie`, która przechowuje aktorów i ich role w wygodny i bezpieczny sposób.

> ### Dlaczego używamy `Map` do przechowywania aktorów i ich ról?
> `Map` to struktura danych, która przechowuje pary klucz-wartość. W naszym przypadku kluczem jest obiekt `Actor`,
> a wartością lista jego ról (`List<ActingRole>`).
> 
> Dzięki temu możemy łatwo uzyskać dostęp do ról dla danego aktora, a także sprawdzić, czy dany aktor występuje w filmie.
> 
> Dodatkowo, `Map` pozwala na szybkie wyszukiwanie aktorów i ich ról, co jest przydatne w przypadku filmów z dużą obsadą.

### 1.14.4. Testowanie klasy `Movie`

1. W katalogu `project` otwórz plik `Main.java`.
2. Stwórz przykładowego reżysera:
   ```java
   Director nolan = new Director("Christopher", "Nolan", null, LocalDate.of(1970, 7, 30),
           null, List.of(DirectorAward.OSCAR, DirectorAward.GOLDEN_GLOBE));
   ```
3. Stwórz przykładowych aktorów:
   ```java
   Actor dicaprio = new Actor("Leonardo", "DiCaprio", null, LocalDate.of(1974, 11, 11), null, false);
   Actor gordonLevitt = new Actor("Joseph", "Gordon-Levitt", null, LocalDate.of(1981, 2, 17), null, false);
   ```
4. Stwórz przykładowe role:
   ```java
   ActingRole cobbRole = new ActingRole("Cobb", "Główny bohater, specjalista od ekstrakcji snów.");
   ActingRole arthurRole = new ActingRole("Arthur", "Partner Cobba, odpowiedzialny za research.");
   ```
5. Stwórz instancje `Movie`:
   ```java
   Movie inception = new Movie("Incepcja", 8880, nolan, null);
   ```
6. Dodaj aktorów i ich role do filmu:
   ```java
   inception.addActor(dicaprio, cobbRole);
   inception.addActor(gordonLevitt, arthurRole);
   ```
7. Dodaj film do wypożyczonych przedmiotów użytkownika:
   ```java
   janKowalski.addItem(inception);
   ```
8. Dodaj wyświetlanie informacji o filmie:
   ```java
   System.out.println("\n--- TESTOWANIE FILMU ---");
   System.out.println(inception.info());
   System.out.println(janKowalski.info());
   ```
9. Dodaj dodawanie i usuwanie ról aktorów:
   ```java
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
   ```

Po uruchomieniu programu powinieneś zobaczyć informacje o filmie, aktorach i ich rolach w odpowiednim formacie
tak jak poniżej:
```
--- TESTOWANIE FILMU ---
Incepcja, Christopher Nolan (02:28:00) :: Joseph Gordon-Levitt (Arthur (Partner Cobba, odpowiedzialny za research.)), Leonardo DiCaprio (Cobb (Główny bohater, specjalista od ekstrakcji snów.))
Jan Kowalski (1): 4 wypożyczone przedmioty

...Dodawanie nowego aktora...
Incepcja, Christopher Nolan (02:28:00) :: Joseph Gordon-Levitt (Arthur (Partner Cobba, odpowiedzialny za research.)), Tom Hardy (Eames (Fałszerz, potrafi zmieniać wygląd w świecie snów.)), Leonardo DiCaprio (Cobb (Główny bohater, specjalista od ekstrakcji snów.))

...Usuwanie roli aktora...
Incepcja, Christopher Nolan (02:28:00) :: Tom Hardy (Eames (Fałszerz, potrafi zmieniać wygląd w świecie snów.)), Leonardo DiCaprio (Cobb (Główny bohater, specjalista od ekstrakcji snów.))
Czy Joseph Gordon-Levitt nadal jest w obsadzie? false
```

### 1.14.5. Klasa `Documentary`

Kolejnym rodzajem filmu, który możemy dodać, jest film dokumentalny.
Wykorzystamy w nim klasę `Actor`, ale nie będziemy przechowywać ról aktorów.

1. W katalogu `video` stwórz klasę `Documentary`, która będzie dziedziczyć po klasie `Video`.
2. Dodaj **prywatne** pola:
   - `subject` typu `final String` - temat dokumentu
   - `narrator` typu `final Actor` - narrator filmu. To pole może być `null`, jeśli dokument nie ma narratora
     lub jest nieznany.
3. Dodaj główny, **publiczny** konstruktor, który przyjmuje wszystkie argumenty, w tym narratora:
   
   `public Documentary(String title, int duration, Director director, String subject, Actor narrator)`
   - Wewnątrz konstruktora sprawdź, czy przekazany narrator nie jest `null`.
     Jeśli nie jest, upewnij się, że jest on aktorem głosowym (jego metoda `isVoiceActor()` zwraca true).
     Jeśli warunek nie jest spełniony, rzuć wyjątek `IllegalArgumentException` z odpowiednim komunikatem,
     np. `Narrator musi być aktorem głosowym!`.
4. Stwórz drugi, przeciążony konstruktor. Będzie on służył do wygodnego tworzenia filmów dokumentalnych,
   które nie mają narratora lub nie jest on znany.
   - Konstruktor ten powinien przyjmować tylko `title`, `duration`, `director` i `subject`.
   - Jego jedynym zadaniem powinno być wywołanie głównego konstruktora za pomocą słowa kluczowego `this()`,
     przekazując mu `null` w miejsce narratora.
5. Dodaj **publiczne** metody:
   - `getSubject()` - zwraca temat dokumentu.
   - `getNarrator()` - zwraca narratora dokumentu.
     - Metoda powinna zwracać typ `Optional<Actor>`, a nie `Actor`.
       Użyj `Optional.ofNullable(narrator)`, aby *opakować* potencjalnie pustą wartość.
6. Nadpisz metodę `info()`, aby wyświetlała szczegóły dokumentu. Wykorzystaj metody z `Optional`,
   aby bezpiecznie dodać informację o narratorze tylko wtedy, gdy on istnieje w formacie:
   - `{title}, {director} ({duration}) :: {subject} (Narracja: {narrator})`
     - Podczas formatowania sprawdź, czy narrator jest obecny korzystając z metod dostępnych w `Optional`.
       Jeśli tak, dodaj `(Narracja: {narrator})`, gdzie `{narrator}` to pełne imię i nazwisko lub pseudonim narratora.
7. Nadpisz metodę `toString()`, aby zwracała to samo, co metoda `info()`.

> ### Co oznacza `this(...)`?
> `this(...)` to specjalna konstrukcja w Javie, która pozwala na wywołanie innego konstruktora **w tej samej klasie**.
> 
> Najczęściej wykorzystuje się ją do unikania duplikacji kodu w konstruktorach, w naszym przypadku
> aby wywołać główny konstruktor z innymi argumentami.

> ### Dlaczego używamy `Optional`?
> `Optional` to specjalny typ w Javie, który reprezentuje wartość, która może być obecna lub nieobecna.
> 
> Jego głównym celem jest uniknięcie błędów typu `NullPointerException`.
> Zamiast zwracać `null`, co jest ryzykowne, zwracamy `Optional`.
> Programista, który wywołuje metodę `getNarrator()`, jest wtedy zmuszony *"otworzyć pudełko"* i świadomie
> obsłużyć przypadek, gdy jest ono puste.
> To sprawia, że kod jest znacznie bezpieczniejszy i bardziej czytelny.
> 
> Oprócz tego, `Optional` dostarcza wiele przydatnych metod do pracy z wartościami, które mogą być puste,
> np. `isPresent()`, `ifPresent()`, `orElse()`, `map()` i inne.
> Dzięki nim możemy łatwo sprawdzić, czy wartość jest obecna, i wykonać odpowiednie operacje.

### 1.14.6. Testowanie klasy `Documentary`

1. Stwórz przykładowego reżysera oraz narratora filmu:
   ```java
   Director herzog = new Director("Werner", "Herzog", null, LocalDate.of(1942, 9, 5), null, List.of());
   Actor narrator = new Actor("Krystyna", "Czubówna", null, LocalDate.of(1954, 8, 2), null, true);
   ```
2. Stwórz dla obiekty `Documentary`, jeden z nich będzie zawierał narratora a drugi nie:
   ```java
   // Dokument z narratorem - używamy głównego konstruktora
   Documentary lifeOnEarth = new Documentary("Życie na Ziemi", 5400, herzog, "Przyroda", narrator);
   
   // Dokument bez narratora - używamy przeciążonego konstruktora
   Documentary industrialRevo = new Documentary("Rewolucja Przemysłowa", 3600, herzog, "Historia");
   ```
3. Dodaj oba dokumenty do wypożyczonych przedmiotów użytkownika:
   ```java
   adamNowak.addItem(lifeOnEarth);
   adamNowak.addItem(industrialRevo);
   ```
4. Dodaj wyświetlanie informacji o dokumentach:
   ```java
   System.out.println("\n--- TESTOWANIE FILMU DOKUMENTALNEGO ---");
   System.out.println(lifeOnEarth.info());
   System.out.println(industrialRevo.info());
   ```
5. Na koniec przetestuj działanie `Optional` z `getNarrator()`.
   Użyjemy metody ifPresent(), która wykonuje podaną akcję tylko wtedy, gdy Optional **nie jest pusty**:
   ```java
   System.out.println("\nSprawdzanie narratora w '" + lifeOnEarth.getTitle() + "':");
   lifeOnEarth.getNarrator().ifPresent(n -> {
       System.out.println("  Narratorem jest: " + n.getFullName());
   });
   
   System.out.println("\nSprawdzanie narratora w '" + industrialRevo.getTitle() + "':");
   industrialRevo.getNarrator().ifPresent(n -> {
       // Ten tekst nie powinien się wyświetlić
       System.out.println("  Narratorem jest: " + n.getFullName());
   });
   // Możemy też sprawdzić inaczej
   if (industrialRevo.getNarrator().isEmpty()) {
       System.out.println("  Ten dokument nie ma narratora.");
   }
   ```

Po uruchomieniu programu powinieneś zobaczyć informacje o dokumentach, narracji i sprawdzeniu narratora w odpowiednim
formacie:
```text
--- TESTOWANIE FILMU DOKUMENTALNEGO ---
Życie na Ziemi, Werner Herzog (01:30:00) :: Przyroda (Narracja: Krystyna Czubówna)
Rewolucja Przemysłowa, Werner Herzog (01:00:00) :: Historia

Sprawdzanie narratora w 'Życie na Ziemi':
  Narratorem jest: Krystyna Czubówna

Sprawdzanie narratora w 'Rewolucja Przemysłowa':
  Ten dokument nie ma narratora.
```

### 1.14.7. Klasa `Anime`

Jako ostatni rodzaj filmu, jaki dodamy do naszej biblioteki, będzie anime.

1. W katalogu `video` stwórz podkatalog `anime`.
2. W katalogu `anime` stwórz enum `AnimeType`, który będzie reprezentować typy anime:
   - `TV_SERIES("TV Series")`
   - `MOVIE("Movie")`
   - `OVA("OVA")`
   - `ONA("ONA")`
   - `SPECIAL("Special")`
3. W katalogu `anime` stwórz klasę `Character`.
   1. Zmień typ klasy na `record`, aby uprościć definicję.
      Aby to zrobić, zmień deklarację klasy na:
      ```java
      public record Character(...) { }
      ```
   2. Wewnątrz rekordu dodaj pola:
      - `name` typu `String` - będzie przechowywać nazwę postaci.
      - `voiceActor` typu `Actor` - będzie przechowywać aktora głosowego, który podkłada głos pod tę postać.
      - `isMainCharacter` typu `boolean` - będzie przechowywać informację, czy postać jest główną postacią w anime.
      ```java
      public record Character(
           String name,
           Actor voiceActor,
           boolean isMainCharacter
      ) { }
      ```
4. W katalogu `anime` stwórz klasę `Anime`, która będzie dziedziczyć po klasie `Video`.
   - Dodaj **prywatne** pola:
      - `originalTitle` typu `final String` - japoński tytuł anime.
      - `type` typu `final AnimeType` - typ anime.
      - `characters` typu `final Set<Character>` - Zbiór postaci w anime.
   - Dodaj **publiczny** konstruktor, który przyjmuje wszystkie argumenty i inicjalizuje odpowiednie pola.
   - Dodaj **publiczne** metody:
      - `getOriginalTitle()` - zwraca japoński tytuł anime.
      - `getType()` - zwraca typ anime.
      - `getCharacters()` - zwraca listę postaci w anime.
   - Nadpisz metodę `info()`, aby wyświetlała szczegóły anime w formacie:
      ```text
      {japaneseTitle} ({englishTitle}) {type} ({duration})
      ```
   - Nadpisz metodę `toString()`, aby zwracała to samo, co metoda `info()`.

## 1.14.8. Testowanie klasy `Anime`

1. Stwórz najpierw aktorów głosowych dla postaci:
   ```java
   Actor kaji = new Actor("Yūki", "Kaji", null, LocalDate.of(1985, 9, 3), null, true);
   Actor ishikawa = new Actor("Yui", "Ishikawa", null, LocalDate.of(1989, 5, 30), null, true);
   
   Actor murakawa = new Actor("Rie", "Murakawa", null, LocalDate.of(1990, 1, 1), null, true);
   Actor minase = new Actor("Inori", "Minase", null, LocalDate.of(1995, 12, 2), null, true);
   ```
2. Teraz możemy stworzyć obiekty postaci:
   ```java
   Character eren = new Character("Eren Yeager", kaji, true);
   Character mikasa = new Character("Mikasa Ackerman", ishikawa, true);
   
   Character ram = new Character("Ram", murakawa, true);
   Character rem = new Character("Rem", minase, true);
   ```
3. Następnie reżysera/twórcę anime:
   ```java
   Director araki = new Director("Tetsurō", "Araki", null, LocalDate.of(1976, 11, 5), null, List.of());
   Director watanabe = new Director("Masaharu", "Watanabe", null, null, null, List.of());
   ```
4. A na koniec instancje `Anime`:
   ```java
   Anime attackOnTitan = new Anime("Attack on Titan", 1440, araki,
           "進撃の巨人 (Shingeki no Kyojin)", AnimeType.TV_SERIES, Set.of(eren, mikasa));
   
   Anime reZero = new Anime("Re:ZERO - Starting Life in Another World", 1500, watanabe,
           "Re:ゼロから始める異世界生活", AnimeType.TV_SERIES, Set.of(ram, rem));
   ```
5. Dodaj oba anime do wypożyczonych przedmiotów użytkownika:
   ```java
   janKowalski.addItem(attackOnTitan);
   janKowalski.addItem(reZero);
   ```
6. Dodaj wyświetlanie informacji o anime:
   ```java
   System.out.println("\n--- TESTOWANIE ANIME ---");
   System.out.println(attackOnTitan.info());
   System.out.println(reZero.info());
   ```

Po uruchomieniu programu powinieneś zobaczyć informacje o anime w odpowiednim formacie, np.:
```text
--- TESTOWANIE ANIME ---
進撃の巨人 (Shingeki no Kyojin) (Attack on Titan), TV (00:24:00)
Re:ゼロから始める異世界生活 (Re:ZERO - Starting Life in Another World), TV (00:25:00)
```

W ten sposób pomyślnie przetestowaliśmy ostatni element naszej biblioteki.

## 1.15 Podsumowanie

I to by było na tyle na tym etapie!

Jeśli wykonałeś/wykonałaś wszystkie kroki, to właśnie udało Ci się zbudować od zera szkielet złożonej,
ale elastycznej aplikacji w Javie.

To nie jest już prosty programik, a system z przemyślaną architekturą, który można łatwo rozbudowywać o nowe
funkcje i typy danych.
Zobaczyliśmy, jak z małych, prostych klas można budować coraz większe i bardziej skomplikowane struktury,
które współgrają ze sobą.

<p><img src="/assets/Final.png" alt="Final" width="900"/></p>

### Czego się nauczyłeś?

#### Fundamenty Programowania Obiektowego (OOP):
  - **Abstrakcja i Enkapsulacja:** Tworzyłeś/tworzyłaś klasy abstrakcyjne (`Person`, `Book`, `Video`) i interfejsy
    (`LibraryItem`, `Playable`, `Authored`), ukrywając szczegóły implementacji za pomocą prywatnych pól.
  - **Dziedziczenie:** Rozbudowywałeś klasy bazowe, tworząc bardziej wyspecjalizowane wersje,
    np. `Movie` i `Documentary` dziedziczące po `Video`.
  - **Polimorfizm:** Przechowywałeś w jednej liście (`List<LibraryItem>`) obiekty różnych typów
    (książki, filmy, muzykę), co jest sercem elastycznego projektowania.
#### Kluczowe narzędzia Javy:
  - **Kolekcje:** Używałeś fundamentalnych struktur danych jak `List`, `Set` i `Map`, ucząc się, kiedy i dlaczego
    wybrać każdą z nich.
  - **Typy Wyliczeniowe (enum):** Stworzyłeś bezpieczne i czytelne typy dla gatunków muzycznych czy nagród reżyserskich,
    zamiast używać zwykłych Stringów.
  - **Słowa kluczowe:** W praktyce zobaczyłeś, jak działają `final`, `super`, `this`, `default` i `@Override`.
  - **Obsługa błędów:** Nauczyłeś się rzucać wyjątki (`IllegalArgumentException`), aby Twój kod był bardziej odporny
    na błędy i łatwiejszy do debugowania.
#### Nowoczesna Java i dobre praktyki:
  - **Refaktoryzacja:** Ulepszyłeś istniejący kod (np. zmieniając pole author na listę autorów), co jest jedną
    z najważniejszych umiejętności praktycznych podczas pracy z kodem.
  - **Optional:** Nauczyłeś się, jak bezpiecznie obsługiwać wartości, które mogą być `null`, unikając najczęstszego
    błędu w Javie, jakim jest `NullPointerException`.
  - **Rekordy:** Poznałeś nowoczesny sposób na tworzenie zwięzłych, niezmiennych klas do przechowywania danych (`Character`).
  - **Programowanie defensywne:** Zabezpieczałeś listy przed modyfikacją (`Collections.unmodifiableList`)
    i walidowałeś dane w konstruktorach.

Dzięki tym wszystkim umiejętnościom jesteś teraz w stanie tworzyć bardziej złożone aplikacje w Javie,
które są nie tylko funkcjonalne, ale także łatwe do rozbudowy i utrzymania.

## 2. Zarządzanie Biblioteką

W tej części projektu zajmiemy się zarządzaniem biblioteką, czyli tworzeniem systemu, który pozwoli na
wypożyczanie i zwracanie przedmiotów, a także na zarządzanie przedmiotami i użytkownikami biblioteki.

`TBA`

---

<div style="text-align: center">
   © 2025 erpix.dev
</div>

---