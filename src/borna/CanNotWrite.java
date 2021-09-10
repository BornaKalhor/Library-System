package borna;

public class CanNotWrite extends Exception{
    public CanNotWrite(){
        System.err.println("FAILED TO WIRTE THE CONTENT :( ");
    }

}
