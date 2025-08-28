public class LibraryManagementSystem {
  public static void main(String[] args) {
    LibraryItem book = new Book("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia");
    LibraryItem magazine = new Magazine("National Geographic", "Vários", 2023, 150);
    LibraryItem digitalMedia = new DigitalMedia("Curso de Java", "Alura", 2021, "MP4");
  
    LibraryItem[] items = {book, magazine, digitalMedia};

    for (LibraryItem item : items) {
      System.out.println("\n---------------------------");
      item.displayInfo();
      item.borrow();
      item.returnItem();

      // Usando instanceof para chamar métodos específicos
      if (item instanceof Book) {
        ((Book) item).readSample();
      } else if (item instanceof Magazine) {
        ((Magazine) item).flipPages();
      } else if (item instanceof DigitalMedia) {
        ((DigitalMedia) item).play();
      }
    }
  }
}
