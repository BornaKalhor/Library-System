package borna;

public class CanNotRead extends Exception{
    public CanNotRead(){
        System.err.println("FAILED TO READ THE CONTENT :( ");
    }
}
