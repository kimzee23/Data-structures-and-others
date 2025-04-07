import java.util.Scanner;

public class pizzaWahala{

public static void main(String[]args){
    Scanner input = new Scanner(System.in);

    String[] pizzaTypes ={"Sapa Size","Mr Chibuzo size","Big boys","Chife size"};
    int[] sliceBox = {4,6,8,12};
    int[] pricePerbox ={2500,2900,4000,5200};

//input user data

System.out.println("Welcome to Iya Moses Pizza joint Ajegunle");

System.out.println("Enter the number of guests:");
int numberOfGuests = scanner.nextInt();
scanner.nextInt();

System.out.println("Choose the type of pizza:");
for (int item = 0; item < pizzaTypes.length; item++) {
    System.out.println((item + 1) + ". " + pizzaTypes[item]);

}
System.out.println("Enter the number of the pizza type:");
int pizzaChoice = scanner.nextInt()- 1;
if(pizzaChoice <= 0 || pizzaChoice > pizzaTypes.length){
    System.out.println("Not vaild choice. please try again");
    return;
}
//calculations
int slicesPerGuest = 1; 
int totalSlicesNeeded = numberofGuests * slicesPerGuest;
int slicePerBoxChosen = slicesPerBox[pizzaChoice];
int pricePerBoxChosen = pricePerBox[pizzaChoice];

int boxesNeeded = (int) math.cell((double)totalSlicesNeeded / slicePerBoxChosen);
int totalSlices = boxesNeeded * slicePerBoxChosen;
int leftoverSlices = totalSlices - totalSlicesNeeded;
int totalPrice = boxesNeeded * pricePerBoxChosen;

//out
System.out.println("\nOrder summary:");
System.out.println("Number of boxes of pizza to buy: " + boxesNeeded + "box(es)" );
System.out.println("Number of leftover slice: " + leftoverSlices + "slice(s)");
System.out.println("Total price: N " + totalPrice);
}




}



