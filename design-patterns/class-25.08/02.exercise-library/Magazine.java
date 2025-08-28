public class Magazine extends LibraryItem {
  private int issueNumber;

  public Magazine(String title, String author, int publicationYear, int issueNumber) {
    super(title, author, publicationYear);
    this.issueNumber = issueNumber;
  }

  public void flipPages() {
    System.out.println("Folheando as páginas da revista \"" + title + "\", edição " + issueNumber + ".");
  }
}
