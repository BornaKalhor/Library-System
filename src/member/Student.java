package member;

public class Student extends Memmber{
    private static int count =1;
    public Student(String firstName, String familyName, int date){
        super(Kind.STUDENT, firstName, familyName, date);
        count++;

    }
}