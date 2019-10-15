import java.util.Scanner;
public class PhoneDiary {
    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Show All Contacts");
            System.out.println("4. Edit a Contact");
            System.out.println("5. Remove a Contact");
            System.out.println("6. Exit");
            switch (scan.next()){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":break;
                case "6":
                    System.out.println("Exiting Windows..");
                    return;
                default:
                    System.out.println("Invalid input, Try Again");
                    System.out.println();
            }
        }
    }
}
