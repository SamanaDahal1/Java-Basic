//package CollectionFamework;
//
//import java.util.*;
//
//interface SearchStrategy{
//    List<String> search(Set<String> name, String searchText);
//}
//class ExactMatch implements SearchStrategy{
//    public List<String> search(Set<String> name, String searchText) {
//        List<String> result = new ArrayList<>();
//        for(String n : name){
//            if( n.equals(searchText)) {
//                result.add(n);
//            }
//        }
//        return result;
//    }
//}
//class PartialMatch implements SearchStrategy{
//    public List<String> search(Set<String> name, String searchText) {
//        List<String> result = new ArrayList<>();
//        for(String n : name){
//            if(n.contains(searchText)) {
//                result.add(n);
//            }
//        }
//        return result;
//    }
//}
//class Information{
//    TreeMap<String , String> info = new TreeMap<>();
//    void displayInfo(){
//        Scanner src = new Scanner(System.in);
//        while(true) {
//        System.out.println("1. Add a contact\n" +
//                "2. Display all contacts\n" +
//                "3. Search contacts\n" +
//                "4. Exit");
//        int choice = src.nextInt();
//
//
//            if (choice == 1) {
//                adding();
//
//            }
//            else if (choice == 2) {
//                disply();
//
//            }
//            else if (choice == 3) {
//
//                System.out.println(
//                        "Choose search strategy:\n" +
//                                "1. Exact\n" +
//                                "2. Partial"
//                );
//
//                int ser = src.nextInt();
//
//                if (ser == 1) {
//
//                    SearchStrategy searchStrategy = new ExactMatch();
//
//                    System.out.println("Enter what you want to search:");
//                    String searchName = src.next();
//
//                    List<String> result =
//                            searchStrategy.search(info.keySet(), searchName);
//
//                    System.out.println("Search Result: " + result);
//                }
//
//                else if (ser == 2) {
//
//                    SearchStrategy searchStrategy1 = new PartialMatch();
//
//                    System.out.println("Enter what you want to Partially search:");
//                    String psearchName = src.next();
//
//                    List<String> result =
//                            searchStrategy1.search(info.keySet(), psearchName);
//
//                    System.out.println("Search Result: " + result +" Phone number :" +e.getValue());
//                }
//            }
//            else if(choice==4){
//                System.exit(0);
//            }
//            else {
//                System.out.println("Please Valid input only");
//
//            }
//
//        }
//    }
//     void adding(){
//        Scanner src = new Scanner(System.in);
//        System.out.println("How many key/value you want to enter: ");
//        int size = src.nextInt();
//        for(int i = 0 ; i<size;i++) {
//            System.out.println("Enter you name: ");
//            String name = src.next();
//            System.out.println("Enter you Phone Number: ");
//            String phoNum = src.next();
//            info.put(name, phoNum);
//        }
//        System.out.println("Successfully Added");
//    }
//    void disply(){
//        for(Map.Entry<String, String> e: info.entrySet()){
//            System.out.println("Name: " + e.getKey() +" Phone Number: "+e.getValue());
//        }
//
//    }
//}
//public class ContactManager {
//    public static void main(String[] args){
//        Information information = new Information();
//        information.displayInfo();
//    }
//
//}
