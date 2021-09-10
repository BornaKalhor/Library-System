package source;
import java.io.*;
import java.util.Scanner;


public abstract class Source implements Comparable<Source>{
    private String name;
    private final String code;
    private int lendtime;
    private static int sourceCount = 0;
    private static final int NAME_LENGTH = 50;
    private static final int CODE_LENGTH = 20;
    private static final int LENDTIME_LENGTH = 20;
    private static final int RECORD_LENGTH = (NAME_LENGTH) * 2 + (CODE_LENGTH + LENDTIME_LENGTH) * 4;
    private String path;
    private String sourceKind;
    private static int BookCounter = 0;
    private static int MagazineCounter = 0;
    private static int ThesisCounter = 0;
    private static int CDCounter = 0;
    private static int AlbumCounter = 0;
    private static int counter = 0;
    private String topic;
    int i = 0;

    public void setLendtime(int lendtime) {
        this.lendtime = lendtime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
//

    String[] bookNames = new String[60];
    String[] magazineNames = new String[60];
    String[] thesisesNames = new String[60];
    Source[] sources = new Source[60];

    public static int getCDCounter() {
        return CDCounter;
    }

    public static void setCDCounter(int CDCounter) {
        Source.CDCounter = CDCounter;
    }

    public static int getAlbumCounter() {
        return AlbumCounter;
    }

    public static void setAlbumCounter(int albumCounter) {
        AlbumCounter = albumCounter;
    }

    public static int getBookCounter() {
        return BookCounter;
    }

    public static void setBookCounter(int bookCounter) {
        BookCounter = bookCounter;
    }

    public static int getMagazineCounter() {
        return MagazineCounter;
    }

    public static void setMagazineCounter(int magazineCounter) {
        MagazineCounter = magazineCounter;
    }

    public static int getThesisCounter() {
        return ThesisCounter;
    }

    public static void setThesisCounter(int thesisCounter) {
        ThesisCounter = thesisCounter;
    }

    public Source(String name) {
       /* setCode(code);*/
        setName(name);
        code = "R" + counter;
        counter++;
    }

   /* public Source() {
    }*/

    public void setName(String name) {
        this.name = name;
    }

  /*  public void setCode(String code) {
        this.code = toString();
    }*/

    /* public void setLendtime(int lendtime) {

     if(Member.member.Kind.GUEST == object.kind && this instanceof Book){
         this.lendtime = lendtime;
     }
     if(Member.member.Kind.PROFESSOR == object.kind){
         this.lendtime = lendtime;
     }
     if(Member.member.Kind.STUDENT == object.kind){
         this.lendtime = lendtime;
     }

 } */

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public int getLendtime() {
        return lendtime;
    }

    /*Formatter format;
     private Scanner scan;
    File file = new File("mytext.txt");


    public void openSourcefile(){
        try {

            scan = new Scanner(new File("mytext.txt"));

        } catch (Exception e) {
            System.out.println("could not find file");
        }

    }

    public void readSourcefile () {
        while (scan.hasNext()) {
            name = scan.next();
            code = scan.nextInt();
            lendtime = scan.nextInt();
        }
    }*/

    public static int CovertToint(String code,int id){
        switch (code){
            case "b":
                return 1000+id;
            case "c":
                return 2000+id;
            case "p":
                return 3000+id;
            case "m":
                return 4000+id;
        }
        return 0;
    }

    public void readSourceFile(File file) {
        File myFile = new File(file.getAbsolutePath());
        BufferedReader buffer;
        try {
            File BookInfo = new File("bookInfo.bin");
            buffer = new BufferedReader(new FileReader(BookInfo));
            File MagazineInfo = new File("magazineInfo.bin");
            buffer = new BufferedReader(new FileReader(MagazineInfo));
            File ThesisInfo = new File("thesisInfo.bin");
            buffer = new BufferedReader(new FileReader(ThesisInfo));
            File cdInfo = new File("cdInfo.bin");
            buffer = new BufferedReader(new FileReader(cdInfo));
            File albumInfo = new File("albumInfo.bin");
            buffer = new BufferedReader(new FileReader(albumInfo));
            RandomAccessFile book = new RandomAccessFile(BookInfo, "rwd");
            RandomAccessFile magazine = new RandomAccessFile(MagazineInfo, "rwd");
            RandomAccessFile thesis = new RandomAccessFile(ThesisInfo, "rwd");

            Scanner input = new Scanner(myFile);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] word = line.split(",");


                if (word[0].equalsIgnoreCase("Book")) {
                    sources[i] = new Book(word[1], Integer.parseInt(word[2]), word[3], Integer.parseInt(word[4]), word[5]);
                    sources[i].writeSourceFile(book);
                    i++;
                }
                if (word[0].equalsIgnoreCase("Magazine")) {
                    sources[i] = new Magazine(word[1], Integer.parseInt(word[2]), word[3], Integer.parseInt(word[4]), Integer.parseInt(word[4]));
                    sources[i].writeSourceFile(magazine);
                    i++;

                }
                if (word[0].equalsIgnoreCase("Thesis")) {

                    sources[i] = new Thesis(word[1], Integer.parseInt(word[2]), word[3], Integer.parseInt(word[4]), word[5], /*com.company.*/Thesis.grade.valueOf(word[6]));
                    sources[i].writeSourceFile(thesis);
                    i++;
                }

                if (word[0].equalsIgnoreCase("CD")) {

                    sources[i] = new CD(word[1]);
                    sources[i].writeSourceFile(thesis);
                    i++;
                }

                if (word[0].equalsIgnoreCase("Album")) {

                    sources[i] = new Album(word[1]);
                    sources[i].writeSourceFile(thesis);
                    i++;
                }
          /*      name = input.next();
                code = input.next();
                lendtime = input.nextInt();*/
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
    }

}


    public void writeSourceFile(RandomAccessFile file){
        try{
            StringBuilder builder = new StringBuilder();
            builder.append(name);
            builder.setLength(Source.NAME_LENGTH);
            file.writeChars(builder.toString());
            file.writeChars(code);
            file.writeInt(lendtime);

        }catch(IOException e){
            System.err.println("SOMETHING WENT WRONG! :(");
        }

    }

    public void Lend(){
        boolean isLent = false;
        showSourceInfo();
        


    }

    public void returnSource(String sourceCode, String memberCode){


    }

    public void showSourceInfo(){
        System.out.println(name);
        System.out.println(code);
        System.out.println(lendtime);
    }


    @Override
    public String toString() {
        return "R" + sourceCount;
    }

    @Override
    public int compareTo(Source o) {
        return this.CovertToint(this.getCode(), i) - o.CovertToint(this.getCode(), i);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}