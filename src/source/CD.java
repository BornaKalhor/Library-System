package source;
import member.Kind;
import member.Memmber;
import source.Source;

public class CD extends Source {
        private String CDname;


        public CD(String name) {
            super(name);
            this.CDname = CDname;
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
                return 50;
        }
        return 0;
    }
        public String getCDname() {
            return CDname;
        }

        public void setCDname(String CDname) {
            this.CDname = CDname;
        }


    }


