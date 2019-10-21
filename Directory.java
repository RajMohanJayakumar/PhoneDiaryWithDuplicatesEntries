import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.*;

public class Directory {

    //     MultiMap mPhoneBook = new MultiValueMap();
    Map<String, String> mPhoneBook = new HashMap<>();
    Map<String, String> mName = new HashMap<String, String>();
    TreeSet<String> mOrdered = new TreeSet<>();
    //    ArrayList<String> mOrdered  = new ArrayList();
    Pojo p = new Pojo();
    String mTemp;
    String lcomponent[];

    public void add() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Name");
        mTemp = scan.nextLine();
        mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
        p.setmName(mTemp);

        System.out.println("Enter the Phone Number");
        invalid:
        while (true) {
            p.setmPhonenumber(scan.next());
            for (int i = 0; i < p.getmPhonenumber().length(); i++) {
                if (!('0' <= p.getmPhonenumber().charAt(i) && p.getmPhonenumber().charAt(i) <= '9') || p.getmPhonenumber().charAt(i) == '+') {
                    System.out.println("Enter a Valid Phone Number");
                    continue invalid;
                }
                if (i == p.getmPhonenumber().length())
                    break;
            }
            break;
        }

        //Email with Validation
        System.out.println("Enter the Email Address");
        while (true) {
            p.setmEmail(scan.next());
            lcomponent = p.getmEmail().split("@");

            if (!(lcomponent.length == 2))
                System.out.println("Enter a Valid Email");
            else
                break;
        }

        mTemp = p.getmName() + "&/&" + p.getmPhonenumber() + "&/&" + p.getmEmail();
//        p.setmName(p.getmName().toLowerCase());
        mPhoneBook.put(p.getmEmail(), mTemp);

        mName.put(p.getmName().substring(0, 1).toUpperCase() + p.getmName().substring(1), mName.get(p.getmName()) + p.getmEmail() + "&/&");
        mOrdered.add(p.getmEmail());
    }

    public void search() {
        System.out.println("Enter the Name to Search");
        while (true) {
            Scanner scan2 = new Scanner(System.in);
            mTemp = scan2.nextLine();
            mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
            if (!mName.containsKey(mTemp)) {
                System.out.println("Record Not Found..");
                return;
            } else
                break;
        }

        mTemp = mName.get(mTemp).substring(4);
        String emailSplit[] = mTemp.split("&/&");

        System.out.print("No.");
        System.out.format("%6s", " ");
        System.out.format("%-20s", "Name");
        System.out.format("%-20s", "Phone Number");
        System.out.format("%-20s", "Email");
        System.out.println();
        int count = 0;
        for (String i : emailSplit) {
            count++;
            mTemp = ((String) (mPhoneBook.get(i)));
            String lDetails[] = ((String) (mPhoneBook.get(i))).split("&/&");
            System.out.print(count);
            System.out.format("%6s", " ");
            System.out.format("%-20s", lDetails[0]);
            System.out.format("%-20s", lDetails[1]);
            System.out.format("%-20s", lDetails[2]);
            System.out.println();
        }
    }

    public void remove(){
        System.out.println("Enter the email to remove the record");
        Scanner scan3 = new Scanner(System.in);
        mTemp = scan3.nextLine();
        remove(mTemp);
    }
    public void remove(String mTemp) {

        if (!mPhoneBook.containsKey(mTemp)) {
            System.out.println("Record Not Found");
            return;
        }
        ///////////////////////////////////////////////////////////////////////
        String mTempstr="null";
        String lTemp[] = mPhoneBook.get(mTemp).split("&/&");
        String lTemp2[] = mName.get(lTemp[0]).substring(4).split("&/&");
        if(lTemp2.length==1){
            mName.remove(lTemp[0]);
        }
        else {
            for (int i = 0; i < lTemp.length; i++) {
                if (!(lTemp[i] == mTemp))
                    mTempstr = mTempstr + lTemp + "&/&";
            }
            mName.put(lTemp[0], mTempstr);
        }
            mPhoneBook.remove(mTemp);
            mOrdered.remove(mTemp);
            /////////////////////////////////////////////////////////////////////////
        }

    public void showAll() {
        int count = 0;

        System.out.print("No.");
        System.out.format("%6s", " ");
        System.out.format("%-20s", "Name");
        System.out.format("%-20s", "Phone Number");
        System.out.format("%-20s", "Email");
        System.out.println();
        for (String i : mOrdered) {
            count++;

            String lDetails[] = ((String) (mPhoneBook.get(i))).split("&/&");
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
        if (!mPhoneBook.containsKey(mTempEmail)) {
            System.out.println("--------------------------\nRecord Not Found");
            return;
        }
        int lTemp2;
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Phone Number");
        System.out.println("3.Edit Email");
        System.out.println("4.Return to Phonebook");
        switch (lTemp2 = scan4.nextInt()) {
            case 1:{
                String lDetails[] = ((String) (mPhoneBook.get(mTempEmail))).split("&/&");

                String temp2[] = mName.get(lDetails[0]).split("&/&");

                mPhoneBook.remove(lDetails[2]);
                Scanner scan5 = new Scanner(System.in);
                System.out.println("Enter new Name");
                lDetails[0] = scan5.nextLine();

                mPhoneBook.put(lDetails[2],lDetails[0] + "&/&" + lDetails[1] + "&/&" + lDetails[2]);

                if(temp2.length == 1){
                    mName.put(lDetails[0],lDetails[2]);
                }
                else{
                    String str = "null";
                    for(int i=0;i<temp2.length;i++){
                        if(temp2[i]==lDetails[2])
                            str = str+temp2[i]+"&/&";
                    }
                    mName.put(lDetails[0],str);
                }
                break;
            }
            case 2:{
                Scanner scan5 = new Scanner(System.in);
                String lDetails[] = ((String) (mPhoneBook.get(mTempEmail))).split("&/&");
                System.out.println("Enter new Phone Number");
                mPhoneBook.put(lDetails[2],lDetails[0]+"&/&"+scan5.nextLine()+"&/&"+lDetails[2]);
                break;
            }
            case 3: {
                Scanner scan5 = new Scanner(System.in);
                String lcomp[] = ((String) (mPhoneBook.get(mTempEmail))).split("&/&");
                System.out.println("Enter the new Email:");
                String str = scan5.nextLine();

//                String lcomp[] = mPhoneBook.get(str).split("&/&");

                lcomp[2] = str;

                mPhoneBook.remove(mTempEmail);
                mPhoneBook.put(lcomp[2],lcomp[0]+"&/&"+lcomp[1]+"&/&"+lcomp[2]);

                mOrdered.remove(mTempEmail);
                mOrdered.add(lcomp[2]);

                String lt[] = mName.get(lcomp[0]).substring(4).split("&/&");
                if(lt.length==1){
                    mName.remove(lcomp[0]);
                    mName.put(lcomp[0],"null"+lcomp[2]+"&/&");
                }
                else{
                    String str1 = "null"+str+"&/&";
                    for(int i=0;i<lt.length;i++){
                        if(!(lt[i]==mTempEmail)){
                            str1 = str1+lt[i];
                        }
                    }
                    mName.remove(lcomp[0]);
                    mName.put(lcomp[0],str1);
                }

//                if(lTemp2 == 1){
//                    mOrdered.remove(lDetails[2]);/*Note*/
//                    remove(lDetails[2]);/*Note*/
//                }
//                    lDetails[lTemp2 - 1] = scan4.nextLine();
//
////                mPhoneBook.remove(lDetails[2]);
////                mOrdered.remove(mTempEmail);
//
//                mOrdered.add(lDetails[2]);
//                mPhoneBook.put(lDetails[2].substring(0, 1).toUpperCase(), lDetails[0] + "&/&" + lDetails[1] + "&/&" + lDetails[2]);
                break;
            }
            case 4: {
                return;
            }
        }
    }
}