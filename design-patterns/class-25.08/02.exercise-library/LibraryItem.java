public class LibraryItem implements Borrowable {
  protected String title;
  protected String author;
  protected int publicationYear;
  protected boolean isBorrowed;

  public LibraryItem(String title, String author, int publicationYear) {
    this.title = title;
    this.author = author;
    this.publicationYear = publicationYear;
    this.isBorrowed = false;
  }

  public void displayInfo() {
    System.out.println("Título: " + title);
    System.out.println("Autor: " + author);
    System.out.println("Ano de Publicação: " + publicationYear);
    System.out.println("Emprestado: " + (isBorrowed ? "Sim" : "Não"));
  }

  @Override
  public void borrow() {
    if (!isBorrowed) {
      isBorrowed = true;
      System.out.println(title + " foi emprestado.");
    } else {
      System.out.println(title + " já está emprestado.");
    }
  }

  @Override
  public void returnItem() {
    if (isBorrowed) {
      isBorrowed = false;
      System.out.println(title + " foi devolvido.");
    } else {
      System.out.println(title + " não estava emprestado.");
    }
  }
}
