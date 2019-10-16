import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class PhoneDiary implements Serializable {

    Pojo p = new Pojo();
    String mTemp;

    Map<String,String> mPhoneBook = new HashMap<>();
    TreeSet<String> mOrdered = new TreeSet<>();
    Scanner scan = new Scanner(System.in);
    public void run() throws Exception{

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
                case "3":{
                    this.showAll();
                    break;
                }
                case "4":{
                    break;
//                    this.edit();
//                    break;
                }
                case "5": {
                    this.remove();
                    break;
                }
                case "6":
                    System.out.println("Exiting Windows..");
                    return;
                default:
                    System.out.println("Invalid input, Try Again");
                    System.out.println();
            }
        }
    }

    public void add() throws  Exception{
        scan.nextLine();
        System.out.println("Enter the Name");
        p.setmName(scan.nextLine());
        System.out.println("Enter the Phone Number");
        p.setmPhonenumber(scan.next());
        System.out.println("Enter the Email Address");
        p.setmEmail(scan.next());
        mTemp=p.getmName()+"&/&"+p.getmPhonenumber()+"&/&"+p.getmEmail();
        mPhoneBook.put(p.getmName(),mTemp);
        mOrdered.add(p.getmName());

    }

    public void search(){
        System.out.println("Enter the Name to Search");
        Scanner scan2 = new Scanner(System.in);
        mTemp = mPhoneBook.get(scan2.nextLine());
        String lDetails[] = mTemp.split("&/&");
        System.out.println("Name : "+lDetails[0]);
        System.out.println("Phone Number : "+lDetails[1]);
        System.out.println("Email : "+lDetails[2]);

    }

    public void showAll(){
        for (String i: mOrdered) {
            String lDetails[] = mPhoneBook.get(i).split("&/&");
            System.out.println("Name : "+lDetails[0]);
            System.out.println("Phone Number : "+lDetails[1]);
            System.out.println("Email : "+lDetails[2]);
        }
    }

    public void remove(){
        System.out.println("Enter the Name to be removed");
        Scanner scan3 = new Scanner(System.in);
        mTemp = scan3.nextLine();
        mPhoneBook.remove(mTemp);
        mOrdered.remove(mTemp);
    }

    public void edit(){
        System.out.println("Enter the Name to edit");
        Scanner scan4 = new Scanner(System.in);
        mTemp = scan4.nextLine();
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Email");
        System.out.println("3.Edit Phone Number");
        System.out.println("3.Return to Phonebook");
        System.out.println("5.");
        switch(scan4.nextInt()){
            case 1:{
                break;
            }
            case 2:{
//                break;
            }
            case 3:{
//                break;
            }
            case 4:{
//                break;
            }
        }

    }
}