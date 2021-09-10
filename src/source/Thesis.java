package source;

import member.Kind;
import member.Memmber;

public class Thesis extends Source {

    private String thesisname;
    private int releasedate;
    private String authorname;
    public  enum grade{
        BACHELOR,MASTER,PHD;
    }
    public static grade grade;


    public Thesis(String name, int code, String thesisname, int releasedate, String authorname, Thesis.grade grade) {
        super(name);
        this.thesisname = thesisname;
        this.releasedate = releasedate;
        this.authorname = authorname;
        this.grade = grade;
    }

    public long maxDayOfBorrow(Memmber memmber){
        Kind type=memmber.getKind();
        switch (type){
            case PROFESSOR:
                return 15;
            case GUEST:
                return 0;
            case EMPLOYEE:
                return 0;
            case STUDENT:
                return 5;
        }
        return 0;
    }

    public String getThesisname() {
        return thesisname;
    }

    public void setThesisname(String thesisname) {
        this.thesisname = thesisname;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Thesis.grade getGrade() {
        return grade;
    }

    public void setGrade(Thesis.grade grade) {
        this.grade = grade;
    }
}
