package task2;

public class Textbook {
    private String isbn;
    private String title;
    private String author;

    public Textbook(){};

    Textbook(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String toString(){
        return "Isbn: " + " " + isbn + " " + "Title: " + title + " " + "Author: " + author;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Textbook) {
            Textbook other = (Textbook) obj;

            if (!isbn.equals(other.isbn)) return false;

            else if (!title.equals(other.title)) return false;

            else if (!author.equals((other.author))) return false;

            else return true;
        }
        else return false;
    }

}
