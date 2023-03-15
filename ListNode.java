// Marco Soekmono
// 2/8/23
// CS145
// Assignment #1

// This program will serve as a database like
// a LinkedList except it's not made from said class.
// It is able to store ListNode entries which can be
// modified, added and removed accordingly that inherits
// most of LinkedList's methods.


public class ListNode {
    
    // init array variable
    private String[] info;

    // constructor for init info
    public ListNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        String[] info = {firstName, lastName, address, city, phoneNumber};
        this.info = info;
    }

    // get string from this index
    public String get(int i) {
        return info[i];
    }

    // set string of an index
    public void set(int i, String value) {
        info[i] = value;
    }

    // put all info into readable strings with breaklines
    public String toString() {
        String total = "";
        String[] descriptions = {"First Name", "Last Name", "Address", "City", "Phone Number"};
        int i = 0;
        for (String s : info) {
            total += descriptions[i] + ": " +  s + "\n";
            i++;
        }
        return total;
    }

}