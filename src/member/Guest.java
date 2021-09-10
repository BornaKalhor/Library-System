package member;

public class Guest extends Memmber{
    private static int count =1;
    public Guest(String firstName, String familyName, int date){
        super(Kind.GUEST, firstName, familyName, date);
        count++;

    }
}