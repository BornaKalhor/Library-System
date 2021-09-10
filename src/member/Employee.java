package member;

public class Employee extends Memmber{
    private static int count =1;
    public Employee(String firstName, String familyName, int date){
        super(Kind.EMPLOYEE, firstName, familyName, date);
        count++;

    }
}