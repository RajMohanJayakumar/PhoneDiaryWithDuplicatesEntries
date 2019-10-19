import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.*;

 public class Directory {

//     MultiMap mPhoneBook = new MultiValueMap();
    Map<String, String> mPhoneBook = new HashMap<>();
    Map<String,String> mName = new HashMap<String,String>();
    TreeSet<String> mOrdered = new TreeSet<>();
//    ArrayList<String> mOrdered  = new ArrayList();
    Pojo p = new Pojo();
    String mTemp;

    public void add() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Name");
        mTemp = scan.nextLine();
        mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
        p.setmName(mTemp);

        System.out.println("Enter the Phone Number");
        p.setmPhonenumber(scan.next());

        System.out.println("Enter the Email Address");
        p.setmEmail(scan.next());

        mTemp = p.getmName() + "&/&" + p.getmPhonenumber() + "&/&" + p.getmEmail();
        p.setmName(p.getmName().toLowerCase());
        mPhoneBook.put(p.getmEmail(), mTemp);

        mName.put(p.getmName(),mName.get(p.getmName())+p.getmEmail()+"&/&");
        System.out.println(mName.get(p.getmName()));
        mOrdered.add(p.getmEmail());
    }

    public void search() {
        System.out.println("Enter the Name to Search");
        Scanner scan2 = new Scanner(System.in);
        mTemp = scan2.nextLine();

        mTemp = mName.get(mTemp).substring(4);
        String emailSplit[] = mTemp.split("&/&");
//        System.out.println(emailSplit[1]);
        System.out.print("No.");
        System.out.format("%6s", " ");
        System.out.format("%-20s", "Name");
        System.out.format("%-20s", "Phone Number");
        System.out.format("%-20s", "Email");
        System.out.println();
        int count = 0;
        for(String i: emailSplit){
            count++;
            mTemp = ((String)(mPhoneBook.get(i)));
            String lDetails[] = ((String)(mPhoneBook.get(i))).split("&/&");
            System.out.print(count);
            System.out.format("%6s", " ");
            System.out.format("%-20s", lDetails[0]);
            System.out.format("%-20s", lDetails[1]);
            System.out.format("%-20s", lDetails[2]);
            System.out.println();

        }

//        if (mPhoneBook.containsKey(mTemp)) {
//            mTemp = ((String)(mPhoneBook.get(mTemp)));
//            String lDetails[] = mTemp.split("&/&");
//            System.out.println("Name : " + lDetails[0]);
//            System.out.println("Phone Number : " + lDetails[1]);
//            System.out.println("Email : " + lDetails[2]);
//        } else {
//            System.out.println("Contact not found");
//        }
    }

    public void remove() {
        System.out.println("Enter the email to remove the record");
        Scanner scan3 = new Scanner(System.in);
        mTemp = scan3.nextLine();
        mPhoneBook.remove(mTemp);
        mOrdered.remove(mTemp);
    }

    public void showAll() {
        int count = 0;
//        Iterator i = new Iterator() {
//            @Override
//            public boolean hasNext() {
//            }
//
//            @Override
//            public Object next() {
//                return null;
//            }
//        }

        System.out.print("No.");
        System.out.format("%6s", " ");
        System.out.format("%-20s", "Name");
        System.out.format("%-20s", "Phone Number");
        System.out.format("%-20s", "Email");
        System.out.println();
        for (String i : mOrdered) {
            count++;
//            String lDetails[] = i.split("&/&");

            String lDetails[] = ((String)(mPhoneBook.get(i))).split("&/&");
            System.out.print(count);
            System.out.format("%6s", " ");
            System.out.format("%-20s", lDetails[0]);
            System.out.format("%-20s", lDetails[1]);
            System.out.format("%-20s", lDetails[2]);
            System.out.println();
        }
    }

    public void edit() {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Enter the email to edit");
        String mTempEmail = scan4.next();
        if(!mPhoneBook.containsKey(mTempEmail)){
            System.out.println("--------------------------\nRecord Not Found");
            return;
        }
        int lTemp2;
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Phone Number");
        System.out.println("3.Edit Email");
        System.out.println("4.Return to Phonebook");
        switch (lTemp2 = scan4.nextInt()) {
            case 1:
            case 2:
            case 3:{
//                System.out.println(mPhoneBook.get(mTempEmail));
                String lDetails[] = ((String)(mPhoneBook.get(mTempEmail))).split("&/&");
//                System.out.println(lDetails.length);
                System.out.println("Enter the new value:");
                scan4.nextLine();
                lDetails[lTemp2-1] = scan4.nextLine();
                mPhoneBook.remove(lDetails[2]);
                mOrdered.remove(mTempEmail);
                mOrdered.add(lDetails[2]);
                mPhoneBook.put(lDetails[2].substring(0,1).toUpperCase(),lDetails[0] + "&/&" + lDetails[1] + "&/&" + lDetails[2]);
                break;
            }
            case 4:{
                return;
            }
        }
    }

//    public void map(){
//        for(Map.Entry<String, String> i : mPhoneBook.entrySet()){
//            System.out.println(i);
//        }
//    }
}