package member;

public class Professor extends Memmber{
    private static int count =1;
    public Professor(String firstName, String familyName, int date){
        super(Kind.PROFESSOR, firstName, familyName, date);
        count++;

    }
}