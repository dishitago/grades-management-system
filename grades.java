import java.util.Scanner;

public class grades_management_system {
    public static void displayMarks(int[] marks){
        System.out.println("Entered marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
            System.out.println();
        }
    }
    public static int totalMarks(int[] marks){
        int sum=0;
        for(int i=0;i< marks.length;i++){
            sum+=marks[i];
        }
        return sum;
    }
    public static double avgValue(int[] marks){
        int sum=totalMarks(marks);
        double avg=(double) sum/marks.length;
        return avg;
    }
    public static int maxValue(int[] marks){
        int max=Integer.MIN_VALUE;
        int n=marks.length;
        for(int i=0;i<n;i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }
    public static int minValue(int[] marks) {
        int min = Integer.MAX_VALUE;
        int n = marks.length;
        for (int i = 0; i < n; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }
    public static int searchno(int[] marks){
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        for(int i=0;i<marks.length;i++){
            if(marks[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static int[] passFailcount(int[] marks){
        int pcount=0;
        int fcount=0;
        for(int i=0;i<marks.length;i++){
            if(marks[i]>=35){
                pcount++;
            }else{
                fcount++;
            }
        }
        return new int[]{pcount,fcount};
    }

    public  static int[] updateMarks(int[] marks){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student number:");
        int n=sc.nextInt();
        System.out.println("Enter new marks:");
        int m=sc.nextInt();
        if(n>=1 && n<=marks.length){
            marks[n-1]=m;
            System.out.println("Marks Updated Successfully.");
        }
        else{
            System.out.println("Invalid Student Number");
        }
        return marks;
    }

    public static int[] gradecount(int[] marks){
        int acount=0;
        int bcount=0;
        int ccount=0;
        int dcount=0;
        int fcount=0;
        for(int i=0;i<marks.length;i++){
            if(marks[i]>=85){
                acount++;
            } else if (marks[i]>=70) {
                bcount++;
            } else if (marks[i]>=55) {
                ccount++;
            } else if (marks[i]>=35) {
                dcount++;
            }else{
                fcount++;
            }
        }
        return new int[]{acount,bcount,ccount,dcount,fcount};
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n=sc.nextInt();
        int[] marks=new int[n];
        System.out.print("Enter the marks:");
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }
        boolean hvemarks=true;
        while(hvemarks) {
            System.out.println("===== Student Marks Management =====");
            System.out.println("1.Show Marks");
            System.out.println("2.Calculate Total");
            System.out.println("3.Calculate average");
            System.out.println("4.Highest Marks");
            System.out.println("5.Lowest Marks");
            System.out.println("6.Search Marks");
            System.out.println("7.Update Marks");
            System.out.println("8.Pass/Fail Count");
            System.out.println("9.Grade Count");
            System.out.println("10.Exit");
            System.out.print("Enter the choice:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    displayMarks(marks);
                    break;
                case 2:
                System.out.println("Total of the marks:" + totalMarks(marks));
                break;
                case 3:
                    System.out.println("The Average is:"+avgValue(marks));
                    break;
                case 4:
                    System.out.println("Highest Marks:"+maxValue(marks));
                    break;
                case 5:
                    System.out.println("Lowest Marks:"+minValue(marks));
                    break;
                case 6:
                    System.out.println("Enter the marks you want to search:");
                    int result=searchno(marks);
                    if(result==-1){
                        System.out.println("Not Found");
                    }else{
                        System.out.println("Found at student:"+(result+1));
                    }
                    break;
                case 7:
                    updateMarks(marks);
                    displayMarks(marks);
                    break;
                case 8:
                    int[] passfail=passFailcount(marks);
                    System.out.println("Pass Student:"+passfail[0]);
                    System.out.println("Fail Student:"+passfail[1]);
                    break;
                case 9:
                    int[] gradeco=gradecount(marks);
                    System.out.println("A Grade:"+gradeco[0]);
                    System.out.println("B Grade:"+gradeco[1]);
                    System.out.println("C Grade:"+gradeco[2]);
                    System.out.println("D Grade:"+gradeco[3]);
                    System.out.println("F Grade:"+gradeco[4]);
                    break;
                case 10:
                    hvemarks=false;
                    System.out.println("Exit");
                    break;
                default:
                System.out.println("Invalid choice");
                System.out.println("Pls choice again");
            }
        }
    }
}

