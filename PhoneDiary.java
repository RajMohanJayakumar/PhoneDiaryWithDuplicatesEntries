import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class PhoneDiary {

    String mName;
    String mEmail;
    String mPhonenumber;
    String mTemp;

    Map<String,String> mPhoneBook = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    public void run() {

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Enter the Option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Show All Contacts");
            System.out.println("4. Edit a Contact");
            System.out.println("5. Remove a Contact");
            System.out.println("6. Exit");
            switch (scan.next()){
                case "1":{
                    this.add();
                    break;
                }
                case "2":{
                    this.search();
                    break;
                }
                case "3":
                case "4":
                case "5": break;
                case "6":
                    System.out.println("Exiting Windows..");
                    return;
                default:
                    System.out.println("Invalid input, Try Again");
                    System.out.println();
            }
        }
    }

    public void add(){
        scan.nextLine();
        System.out.println("Enter the Name");
        mName = scan.nextLine();
        System.out.println("Enter the Phone Number");
        mPhonenumber = scan.next();
        System.out.println("Enter the Email Address");
        mEmail = scan.next();
        scan.reset();
        mTemp=mName+"&/&"+mPhonenumber+"&/&"+mEmail;
        mPhoneBook.put(mName,mTemp);
        for (String i: mPhoneBook.keySet()){
            System.out.println(i);
            System.out.println(mPhoneBook.get(i));
        }
    }

    public void search(){
//        scan.reset();
        System.out.println("Enter the Name to Search");
        Scanner ss = new Scanner(System.in);
        String s = ss.nextLine();
        mTemp = mPhoneBook.get(s);
        String lDetails[] = mTemp.split("&/&");
        System.out.println("Name : "+lDetails[0]);
        System.out.println("Phone Number : "+lDetails[1]);
        System.out.println("Email : "+lDetails[2]);

    }
}