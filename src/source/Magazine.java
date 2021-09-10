package source;

import member.Kind;
import member.Memmber;
import source.Source;

public class Magazine extends Source {


    private String magazinename;
    private int magazinenumber;
    private int releasedate;


    public Magazine(String name, int code, String magazinename, int magazinenumber, int releasedate) {
        super(name);
        this.magazinename = magazinename;
        this.magazinenumber = magazinenumber;
        this.releasedate = releasedate;
    }

    public long maxDayOfBorrow(Memmber memmber){
        Kind type=memmber.getKind();
        switch (type){
            case PROFESSOR:
                return 20;
            case GUEST:
                return 0;
            case EMPLOYEE:
                return 2;
            case STUDENT:
                return 10;
        }
        return 0;
    }
    public String getMagazinename() {
        return magazinename;
    }

    public void setMagazinename(String magazinename) {
        this.magazinename = magazinename;
    }

    public int getMagazinenumber() {
        return magazinenumber;
    }

    public void setMagazinenumber(int magazinenumber) {
        this.magazinenumber = magazinenumber;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }
}
