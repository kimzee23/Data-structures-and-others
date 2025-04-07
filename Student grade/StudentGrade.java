import java.util.Scanner;
   public class StudentGrade{
     public static void main(String[]args){
             
     int numberStudent = 0;
     int numberOfSubject = 0;
       Scanner input = new Scanner(System.in);
 System.out.println("Enter Number Of Student");
     numberStudent = input.nextInt();

 System.out.println("How many subject do they offer?");
     numberOfSubject = input.nextInt();
     int[][] values = new int [numberStudent][numberOfSubject];



 System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
 System.out.println("Saved successfully");

    for(int item = 0; item < numberStudent; item++)
    {
      for(int counter = 0; counter < numberOfSubject; counter++)
      {

 System.out.println("Entering score for student " + (item + 1)); 
 System.out.println("Enter score for subject " + (counter + 1));
      values[item][counter] = input.nextInt();

 System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
 System.out.println("Saved successfully");
 System.out.println();


 }

}
System.out.print("STUDENT         ");
for(int count = 1; count <= numberOfSubject; count++)
{

   System.out.print("SUB" + count + "     " );
 
}
  System.out.print("TOT      ");
  System.out.print("AVE");
System.out.println();



 for(int rows = 0; rows < numberStudent; rows++){
	System.out.print("student " + (rows + 1) + "         ");

int totalScores = 0;
float average = 0;
      for(int column = 0; column < numberOfSubject; column++){
 System.out.print(values[rows][column] + "       ");
totalScores += values[rows][column];
average = (float) totalScores / numberOfSubject;
  }
System.out.print(totalScores + "       ");
System.out.println(average);

System.out.println();
}



 }
}