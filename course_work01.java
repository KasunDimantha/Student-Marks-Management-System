import java.util.*;
class Cwork01 {

        private static int numRows = 0;
        private static String[][] student = new String[numRows][4];

    public static void header(){
        Scanner input = new Scanner(System.in);

        // header
        line();
        System.out.println("|\t\tWELCOME TO GDSE MARKES MANAGEMENT SYSTEM\t\t\t |");
        line();

        option();
        // select option
        System.out.print("Enter an option to continue > ");

        boolean right = true;
        while(right){
            int num = input.nextInt();
            if (0<num && num<11){
                Requirement(num); 
                right = false;
            } else {
                System.out.print("Invalid Number Re-Enter the Number > ");
                right = true;
            }    
        }
    }

    public static void Requirement(int num){

        numRows = student.length;

        switch (num) {
                    case 1:
                        student = AddNewStudent(student, numRows);
                        break;
                    case 2:
                        student = AddNewStudentWithMarks(student,numRows);
                        break;
                    case 3:
                          student = AddNewMarks(student);
                        break;
                    case 4:

                        break;
                    case 5:
                            
                        break;
                    case 6:

                        break;
                    case 7:
                        print2DArray(student);
                        break;
                    case 8:

                        break;
                    case 9:
                            
                        break;
                    case 10:

                        break;
                    default:
                        System.out.print("Enter again > ");
                        break;
            } 
            header();
    }

    public static void line(){
        for (int i=0; i<41; i++){
            System.out.print("--");
        }
        System.out.println();
    }

    public static void option(){
        System.out.println();
        System.out.print("[1] Add New Student \t\t\t");
        System.out.println("[2] Add New Student With Marks");
        System.out.print("[3] Add Marks \t\t\t\t");
        System.out.println("[4] Update Student Details");
        System.out.print("[5] Update Marks \t\t\t");
        System.out.println("[6] Delete Student");
        System.out.print("[7] Print Student Details \t\t");
        System.out.println("[8] Print Student Rank");
        System.out.print("[9] Best in Programming Fundamentals \t");
        System.out.println("[10] Best in Database Management System");
        System.out.println();
    }

    public static String[][] AddNewMarks(String[][] student){

        Scanner scanner = new Scanner(System.in);
        char val = 'y';
        while(val == 'y') {

            String[] newRow = new String[4];
            System.out.print("Enter student ID : ");
            String ID = scanner.next();

            for(int j=0; j<student.length; j++){
                String ID1 = student[j][0];
                if(ID == ID1){
                    for (int i=2; i<4; i++){
                        if(i==2){
                            System.out.print("Enter Programming Fundamentals marks : ");
                            student[j][i] = scanner.next();
                        } else if(i==3){
                            System.out.print("Enter Database Management System marks : ");
                            student[j][i] = scanner.next();
                        }
                    }
                }
            }
           
            System.out.print("Marks has been added successfully. Do you want to add a new Marks (y/n) : ");
            val = scanner.next().charAt(0);
        }
        return student; 
    }
    
    public static String[][] AddNewStudentWithMarks(String[][] student, int numRows){

        Scanner scanner = new Scanner(System.in);
        char val = 'y';
        while(val == 'y') {

            String[] newRow = new String[4];
            
            for (int i=0; i<4; i++){
                if (i==0){
                    System.out.print("Enter Student Id : ");
                    newRow[i] = scanner.next();
                } else if(i==1){
                    System.out.print("Enter Student Name : ");
                    newRow[i] = scanner.next();
                }  else if(i==2){
                    System.out.print("Enter Programming Fundamentals marks : ");
                    newRow[i] = scanner.next();
                } else if(i==3){
                    System.out.print("Enter Database Management System marks : ");
                    newRow[i] = scanner.next();
                }
            }
            
            student = increaseArraySize(student);
            student[numRows] = newRow;
            numRows++;

            System.out.print("Student has been added successfully. Do you want to add a new student (y/n) : ");
            val = scanner.next().charAt(0);
        }
        return student; 
    }

    public static String[][] AddNewStudent(String[][] student, int numRows){
        
        Scanner scanner = new Scanner(System.in);

        char val = 'y';
        while(val == 'y') {

            String[] newRow = new String[4];
            
            for (int i=0; i<2; i++){
                if (i==0){
                    System.out.print("Enter Student Id : ");
                    newRow[i] = scanner.next();
                } else {
                    System.out.print("Enter Student Name : ");
                    newRow[i] = scanner.next();
                }
            }
            
            student = increaseArraySize(student);
            student[numRows] = newRow;
            numRows++;

            System.out.print("Student has been added successfully. Do you want to add a new student (y/n) : ");
            val = scanner.next().charAt(0);
        }
        return student; 
    }

    public static String[][] increaseArraySize(String[][] array) {
        String[][] newArray = new String[array.length + 1][array.length > 0 ? array[0].length : 0];
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                
                newArray[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }
        return newArray;
    }

    
    static void print2DArray(String[][] array) {
        System.out.println("ID\tNAME");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

         header();      
    }
}