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
        Scanner scanner = new Scanner(System.in);
        numRows = student.length;

        switch (num) {
            case 1:
                student = AddNewStudent();
                break;
            case 2:
                student = AddNewStudentWithMarks();
                break;
            case 3:
                  student = AddNewMarks();
                break;
            case 4:
                break;
            case 5:                 
                break;
            case 6:
                print2DArray(student);
                break;
            case 7:
                printStudentDetails(student);                   
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
        System.out.print("Do you want to go manu enter(y) : ");
        char val = scanner.next().charAt(0);
        if (val == 'y'){
            header();
        }
            
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

    public static String[][] AddNewMarks(){

        line();
        System.out.println("|\t\t\t\t    ADD MARKS    \t\t\t\t |");
        line();

        Scanner scanner = new Scanner(System.in);
        char val = 'y';
        while(val == 'y') {

            //String[] newRow = new String[4];
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
    
    public static String[][] AddNewStudentWithMarks(){

        line();
        System.out.println("|\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t |");
        line();

        Scanner scanner = new Scanner(System.in);
        char val = 'y';
        while(val == 'y') {

            String[] newRow = new String[4];
            
            for (int i=0; i<4; i++){
                if (i==0){
                    System.out.print("Enter Student Id \t\t\t : ");

                    String IDdup ;
                    IDdup = scanner.next();
                    boolean have;
                    have = CheckId(IDdup);
                    if (have){
                        System.out.println("The Student ID already Exist ");
                        System.out.print("Enter Student Id \t\t : ");
                        newRow[i] = scanner.next();
                    } else {
                        newRow[i] = IDdup;
                    }
                } else if(i==1){
                    System.out.print("Enter Student Name \t\t\t : ");
                    newRow[i] = scanner.next();
                }  else if(i==2){
                    System.out.print("Enter Programming Fundamentals marks  \t : ");
                    newRow[i] = scanner.next();
                } else if(i==3){
                    System.out.print("Enter Database Management System marks   : ");
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

    public static String[][] AddNewStudent(){

        line();
        System.out.println("|\t\t\t\t    ADD STUDENT    \t\t\t\t |");
        line();
        
        Scanner scanner = new Scanner(System.in);

        char val = 'y';
        while(val == 'y') {

            String[] newRow = new String[4];
            
            for (int i=0; i<2; i++){
                if (i==0){
                    System.out.print("Enter Student Id \t\t : ");
       
                    String IDdup ;
                    IDdup = scanner.next();
                    boolean have;
                    have = CheckId(IDdup);
                    if (have){
                        System.out.println("The Student ID already Exist ");
                        System.out.print("Enter Student Id \t\t : ");
                        newRow[i] = scanner.next();
                    } else {
                        newRow[i] = IDdup;
                    }
                } else {
                    System.out.print("Enter Student Name \t\t : ");
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

    public static boolean CheckId(String ID){
        for(int i=0; i<student.length; i++){
            if (ID.equals(student[i][0])){ 
                return true;
            } 
        }
        return false;
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

    static void printStudentDetails(String[][] student) {

        line();
        System.out.println("|\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t |");
        line();

        Scanner input = new Scanner(System.in);

        // Average values of all students
            double[] average = new double[numRows];
            for(int i=0; i<student.length; i++){
                int total1 =0;
                
                for(int j=2; j<4; j++){
                    if(j==2){
                        total1 += Integer.parseInt(student[i][j]);
                    } else if (j==3){
                        total1 += Integer.parseInt(student[i][j]);
                    }
                }
                average[i] = (double)total1/2;
            }
            // Set average values in Desending order
            for (int j = 0; j < average.length; j++) {
                for (int i = 0;  i < average.length-1; i++) {
                    if (average[i] < average[i + 1]) {
                        double t = average[i];
                        average[i] = average[i + 1];
                        average[i + 1] = t;
                    }
                }
            }

        char val = 'F';
        while (val != 'T'){
            System.out.print("Enter Student ID :");
            String ID = input.next();
            System.out.print("Enter Student name :");
            String name = input.next();

            String ID1;
            String name1;
            System.out.println("+-------------------------------+---------------+");
            for(int i=0; i<student.length; i++){
                ID1 = student[i][0];
                name1 = student[i][1];

                if (ID1.equals(ID) && name1.equals(name)){
                    val = 'T';
                     if(val == 'T'){
                        int total =0;
                        for(int j=2; j<4; j++){
                            if(j==2){
                                System.out.println("|Programming Fundermental Marks |\t" + student[i][j]+"\t|");
                                total += Integer.parseInt(student[i][j]);
                            } else if (j==3){
                                System.out.println("|Database Management Marks \t|\t" + student[i][j]+"\t|");
                                total += Integer.parseInt(student[i][j]);
                            }
                        }
                        System.out.println("|Total Marks \t\t\t|\t" + total+"\t|");
                        double avg = (double)total/2;
                        System.out.println("|Avg. Marks \t\t\t|\t" +avg+"\t|");

                        for (int k = 0; k < average.length; k++) {
                            if (average[k] == avg){
                                System.out.println("|Rank \t\t\t\t|\t"+ (k+1)+"\t|");
                            }
                        }
                    }
                    break;
                } else {
                    val = 'F';
                }
            }
            System.out.println("+-------------------------------+---------------+"); 

            if (val == 'F'){
                System.out.println("This student not exist, plese enter correct details");
            } 
        }
    }

    static void print2DArray(String[][] array) {
        System.out.println("ID\tNAME\tP.F\tD.M");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){

         header(); 
              
    }
}