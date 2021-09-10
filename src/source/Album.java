package source;


import member.Kind;
import member.Memmber;

public class Album extends Source
{
    private String albumname;


    public Album(String name) {
        super(name);
        this.albumname = albumname;
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
                return 90;
        }
        return 0;
    }
    public String getAlbumname() {
        return albumname;
    }

    public void setalbumname(String albumname) {
        this.albumname = albumname;
    }


}


