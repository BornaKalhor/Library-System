package source;

import member.Kind;
import member.Memmber;

import java.util.ArrayList;

public class Book extends Source {
    private String bookname;
    private int date;
    ArrayList<String> authors=new ArrayList<>()[];
    private String author = new String();


    public Book(String name,int code, String bookname, int date, String authors) {
        super(name);
        this.bookname = bookname;
        this.date = date;
        this.author = author;
    }

    public long maxDayOfBorrow(Memmber memmber){
        Kind type=memmber.getKind();
        switch (type){
            case PROFESSOR:
                return 30;
            case GUEST:
                return 10;
            case EMPLOYEE:
                return 20;
            case STUDENT:
                return 14;
        }
        return 0;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }
}
