import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

 class product{
    String name;
    double price;
    int quantity;

    public product (String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
 } 
public double calculateTotal(){
    return price * quantity;
} 
}
public class checkout {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      System.out.println("Welcome to semicolon checkout store ");
      System.out.println("Enter costrume ID: ");
      String man = input.nextLine();

      System.out.println("Enter product name:");
      String name = input.nextLine();

       System.out.println("Enter product price");
       double price = input.nextDouble();

       System.out.println("Enter the quantity:");
       int quantity = input.nextInt();

       product product = new product(name, price, quantity);

       double total = product.calculateTotal();
       double vat = total * 0.075;
       double billTotal = total + vat;

       LocalDate currentDate = LocalDate.now();
       


       //output
       System.out.println("SEMICOLON STORE");
       System.out.println("MAIN LAND BRANCH");
       System.out.println("LOCATION: 312, HARBART MACULAY WAY, SABO YABA, LAGOS.");
       System.out.println("Tel: 0329828342");
       System.out.println("Date:  "+ currentDate);
       System.out.println("Costomer Name" + man);
       System.out.println("Casher Name: Chiman");
       System.out.println("Input customer name");
       String cusname = input.nextLine();
       System.out.println("Customer name:" + cusname);
       System.out.println("\n=======================================================");
       System.out.println("\t ITEM        PRICE     TOTAL(NGN)");
       System.out.println("\t  " + name   +       "\t     "+  price +   "\t" +total );
       System.out.println("\n-------------------------------------------------------");
       System.out.println("\n product:" + product.name);
       System.out.println("\n price:" + product.price);
       System.out.println("\n uantity:" + product.quantity);
       System.out.println("\n Total:" + total);
       System.out.println("\n vat 7.5:" + vat);
       System.out.println("\n========================================================"); 
       System.out.println("\n Bill total:" + billTotal);
       System.out.println("\n========================================================"); 
       System.out.println("\n THIS IS NOT AN RECEIPT KINDLY PAY: " + billTotal);
       System.out.println("\n========================================================"); 
   
     System.out.println("How much did the customer give you? :");
     int customerPaid = input.nextInt();

     double balance = customerPaid - billTotal;
System.out.println("==========================================================================");
     System.out.println("\n---- Checkout inovie-------");
       System.out.println("SEMICOLON STORE");
       System.out.println("MAIN LAND BRANCH");
       System.out.println("LOCATION: 312, HARBART MACULAY WAY, SABO YABA, LAGOS.");
       System.out.println("Tel: 0329828342");
       System.out.println("Date:  "+ currentDate);
       System.out.println("Costomer Name" + man);
       System.out.println("Casher Name: Chiman");
       System.out.println("Input customer name");
       String custromerName = input.nextLine();
       System.out.println("Customer name:" + custromerName);
       System.out.println("\n=======================================================");
       System.out.println("\t ITEM        PRICE     TOTAL(NGN)");
       System.out.println("\t  " + name   +       "\t     "+  price +   "\t" +total );
       System.out.println("\n-------------------------------------------------------");
       System.out.println("\n product:" + product.name);
       System.out.println("\n price:" + product.price);
       System.out.println("\n uantity:" + product.quantity);
       System.out.println("\n Total:" + total);
       System.out.println("\n vat 7.5:" + vat);
       System.out.println("\n========================================================"); 
       System.out.println("\n Bill total:" + billTotal);
       System.out.println("\n Anoumt Paid:" + customerPaid);
       System.out.println("\n       Balance:" + balance);
       System.out.println("\n========================================================"); 

    }
}
