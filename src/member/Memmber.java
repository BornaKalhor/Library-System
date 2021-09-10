// IMPORTING REQUIRED LIBRARIES
package member;
import borna.CanNotRead;
import borna.CanNotWrite;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Date;

public abstract class Memmber implements Comparable<Memmber>{

    // ATTRIBUTES
    private String name;
    private String familyname;
    //private final int code;
    private int code;
    private int joindate;
    private static int professorCount = 0, studentCount = 0, guestCount = 0;
    private static int memberCount = 0;

    private Kind kind;
    private static final int NAME_LENGTH = 50;
    private static final int FAMILY_LENGTH = 50;
    private static final int CODE_LENGTH = 20;
    private static final int JOINDATE_LENGTH = 20;
    private static final int RECORD_LENGTH = (NAME_LENGTH + FAMILY_LENGTH) * 2 + (CODE_LENGTH + JOINDATE_LENGTH) * 4;
    Memmber[] members = new Memmber[100];


        // CONSTRUCTORS
        public Memmber(Kind kind, String name, String familyname, int joindate) {
            setName(name);
            setFamilyname(familyname);
            setJoindate(joindate);
            codeAssigner(kind);

        }
    /*public Memmber(){

    }*/

        // SET AND GET METHODS
    /*public void setCode(int code) {
        this.code = code;
    }*/

        public void setFamilyname(String familyname) {
            this.familyname = familyname;
        }

        public void setJoindate(int joindate) {
            this.joindate = joindate;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setKind(Kind kind) {
            this.kind = kind;
        }

        public Kind getKind() {
            return kind;
        }

        public int getJoindate() {
            return joindate;
        }

        public int getCode() {
            return code;
        }

        public String getFamilyname() {
            return familyname;
        }

        public String getName() {
            return name;
        }

        // METHODS************************************************************

/*    Formatter format;
    File file = new File("mytext.txt");
    Scanner scan;
    public void openMemberfile() {
        try {

            scan = new Scanner(new File("mytext.txt"));

        } catch (Exception e) {
            System.out.println("could not find file");
        }

    }

    public void readMemberfile () {
        while (scan.hasNext()) {
            name = scan.next();
            familyname = scan.next();
            code = scan.nextInt();
            joindate =scan.nextInt();
        }
    }*/

        public void readSourceFile(File file) throws CanNotRead{
            File myFile = new File(file.getAbsolutePath());
            File ProfessorInfo = new File("Professor.bin");
            File StudentInfo = new File("Student.bin");
            File GuestInfo = new File("Guest.bin");
            try {
                int i = 0;
                RandomAccessFile professor = new RandomAccessFile(ProfessorInfo, "rwd");
                RandomAccessFile student = new RandomAccessFile(StudentInfo, "rwd");
                RandomAccessFile guest = new RandomAccessFile(GuestInfo, "rwd");
                Scanner input = new Scanner(myFile);
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] word = line.split(",");
                    if (word[0].equalsIgnoreCase("Professor")) {
                        members[i].setName(word[1]);
                        members[i].setFamilyname(word[2]);
                        members[i].codeAssigner(Kind.PROFESSOR);
                        members[i].setJoindate(Integer.parseInt(word[3]));
                        members[i].writeMemberFile(professor);
                        i++;
                    }
                    if (word[0].equalsIgnoreCase("Student")) {
                        members[i].setName(word[1]);
                        members[i].setFamilyname(word[2]);
                        members[i].codeAssigner(Kind.STUDENT);
                        members[i].setJoindate(Integer.parseInt(word[3]));
                        members[i].writeMemberFile(student);
                        i++;

                    }
                    if (word[0].equalsIgnoreCase("Guest")) {

                        members[i].setName(word[1]);
                        members[i].setFamilyname(word[2]);
                        members[i].codeAssigner(Kind.GUEST);
                        members[i].setJoindate(Integer.parseInt(word[3]));
                        members[i].writeMemberFile(guest);
                        i++;
                    }
                /*name = input.next();
                familyname = input.next();
                joindate = input.nextInt();*/
                }
            } catch (Exception err) {
                throw new CanNotRead();
            }
        }

        public void writeMemberFile(RandomAccessFile file) throws CanNotWrite{
            try {
                StringBuilder builder = new StringBuilder();
                builder.append(name);
                builder.append(familyname);
                builder.setLength(Memmber.NAME_LENGTH);
                builder.setLength(Memmber.FAMILY_LENGTH);
                file.writeChars(builder.toString());
                file.writeInt(code);
                file.writeInt(joindate);

            } catch (IOException e) {
                throw new CanNotWrite();
            }

        }

    public int compareTo(Memmber o) {
        return (CovertToint(this.code, this.id)) - (CovertToint(o.code, o.id));
    }

        public void codeAssigner(Kind unknown) {

            Kind guest = kind.GUEST;
            Kind professor = kind.PROFESSOR;
            Kind student = kind.STUDENT;

            boolean x = unknown == guest;
            boolean y = unknown == professor;
            boolean z = unknown == student;


            if (x = unknown.equals(guest)) {

                guestCount++;
                print(guest);
            }
            if (y = unknown.equals(professor)) {
                professorCount++;
                print(kind.PROFESSOR);
            }
            if (z = unknown.equals(student)) {
                studentCount++;
                print(kind.STUDENT);
            }

        }


        public String print(Kind mykind) {
            if (mykind == kind.PROFESSOR) {
                return "L" + professorCount;
            }
            if (mykind == kind.STUDENT) {
                return "S" + studentCount;
            }
            if (mykind == kind.GUEST) {
                return "G" + guestCount;
            } else {
                return ("false input!!!");
            }
        }

    @Override
    public int compareTo(Memmber o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
