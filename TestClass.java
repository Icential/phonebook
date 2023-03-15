// Marco Soekmono
// 2/8/23
// CS145
// Assignment #1

// This program will serve as a database like
// a LinkedList except it's not made from said class.
// It is able to store ListNode entries which can be
// modified, added and removed accordingly that inherits
// most of LinkedList's methods.

// For this TestClass, I have made a user input and
// for extra credit I made it user-friendly so that it
// wouldn't crash on weird inputs


// import relevant libraries
import java.util.Scanner;

// class creation
public class TestClass {

    // print introduction upon program startup
    public static void intro() {
        System.out.println("Welcome to Phonebook Manager");
        System.out.println("This program is able to create, store and delete information");
        System.out.println("from a notebook.");
        System.out.println();
    }

    // print options that the user can do
    public static void options() {
        System.out.println("Add a contact (a)");
        System.out.println("Remove a contact (r)");
        System.out.println("Edit the phonebook manager (e)");
        System.out.println("View the entirety of the phonebook (p)");
        System.out.println("Check if an entry is in the phonebook (c)");
        System.out.println("Get a specific contact (g)");
        System.out.println("Print the size of the phonebook (s)");
        System.out.println("Quit the program (q)");
    }

    // adds a node based on user input
    public static ListNode addNode(Scanner scan) {
        String[] infoNames = {"First Name", "Last Name", "Address", "City", "Phone Number"};
        String[] info = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a " + infoNames[i] + ": ");
            info[i] = scan.nextLine();
            System.out.println();
        }
        System.out.println();

        ListNode node = new ListNode(info[0], info[1], info[2], info[3], info[4]);
        return node;
    }

    // checks if an entry is in the phonebook
    public static boolean contains(PhonebookManager phonebook, Scanner scan) {
        System.out.println("What entry would you like to check?");
        String input = scan.nextLine();
        return phonebook.contains(input);
    }

    // main session
    public static void session() {

        // main variables
        PhonebookManager phonebook = new PhonebookManager();
        Scanner scan = new Scanner(System.in);
        boolean active = true;

        // loop session
        while (active) {

            // print options
            options();

            // get user input
            String input = scan.nextLine();
            input = input.toLowerCase();
            System.out.println();

            // option
            switch(input.charAt(0)) {

                // add a node
                case 'a':

                    // make node
                    ListNode node = addNode(scan);

                    // print index options
                    if (phonebook.size() == 0) {
                        System.out.println("What index would you like to add it to? (0)");
                    } else {
                        System.out.println("What index would you like to add it to? (0-" + (phonebook.size()) + ")");
                    }

                    // add to corresponding nodes
                    try {
                        int pos = scan.nextInt();
                        scan.nextLine();
                        if (pos == 0) {
                            phonebook.addFirst(node);
                            System.out.println("Successfully added to first node");
                        } else if (pos == phonebook.size()) {
                            phonebook.addLast(node);
                            System.out.println("Successfully added to last node");
                        } else if (pos <= phonebook.size() && pos >= 0){
                            phonebook.add(node);
                            System.out.println("Successfully added node");
                        } else {
                            System.out.println("Index out of bounds!");
                        }
                    } catch (Exception e) {
                        System.out.println("Not a valid integer!");
                        break;
                    }

                    break;

                // remove a node
                case 'r':

                    // print index options
                    if (phonebook.size() == 0) {
                        System.out.println("No contacts exists!");
                        break;
                    } else if (phonebook.size() == 1) {
                        System.out.println("What index would you like to remove? (0)");
                    } else {
                        System.out.println("What index would you like to remove? (0-" + (phonebook.size()-1) + ")");
                    }

                    // remove corresponding nodes
                    try {
                        int pos = scan.nextInt();
                        scan.nextLine();
                        if (pos == 0) {
                            phonebook.removeFirst();
                            System.out.println("Successfully removed first node");
                        } else if (pos == phonebook.size()-1) {
                            phonebook.removeLast();
                            System.out.println("Successfully removed last node");
                        } else if (pos < phonebook.size() && pos >= 0){
                            phonebook.remove(pos);
                            System.out.println("Successfully removed node no." + pos);
                        } else {
                            System.out.println("Index out of bounds!");
                        }
                    } catch (Exception e) {
                        System.out.println("Not a valid integer!");
                        break;
                    }
                    break;

                // edit nodes
                case 'e':

                    // print index options
                    if (phonebook.size() == 0) {
                        System.out.println("No contacts exists!");
                        break;
                    } else if (phonebook.size() == 1) {
                        System.out.println("What index would you like to edit? (0)");
                    } else {
                        System.out.println("What index would you like to edit? (0-" + (phonebook.size()-1) + ")");
                    }

                    // edit corresponding nodes
                    try {
                        int index = scan.nextInt();
                        scan.nextLine();
                        if (index >= phonebook.size() || index < 0) {
                            System.out.println("Invalid index!");
                            break;
                        } else {
                            ListNode contact = addNode(scan);
                            phonebook.set(index, contact);
                            System.out.println("Successfully edited node at index " + index);
                        }
                    } catch (Exception e) {
                        System.out.println("Not an integer!");
                        break;
                    }
                    break;

                // tell if an entry exists in the phonebook
                case 'c':
                    boolean existence = contains(phonebook, scan);
                    if (existence) {
                        System.out.println("The phonebook contains such entry");
                    } else {
                        System.out.println("The phonebook does not contain such entry");
                    }
                    break;

                // print out all of the phonebook
                case 'p':
                    System.out.println(phonebook.toString());
                    break;

                // get a specific node
                case 'g':

                    // print index options
                    if (phonebook.size() == 0) {
                        System.out.println("No contacts exists!");
                        break;
                    } else if (phonebook.size() == 1) {
                        System.out.println("What index would you like to get? (0)");
                    } else {
                        System.out.println("What index would you like to get? (0-" + (phonebook.size()-1) + ")");
                    }

                    // get node correspondingly
                    try {
                        int pos = scan.nextInt();
                        scan.nextLine();
                        if (pos == 0) {
                            ListNode contact = phonebook.getFirst();
                            System.out.println(contact.toString());
                        } else if (pos == phonebook.size()-1) {
                            ListNode contact = phonebook.getLast();
                            System.out.println(contact.toString());
                        } else if (pos < phonebook.size() && pos >= 0){
                            ListNode contact = phonebook.get(pos);
                            System.out.println(contact.toString());
                        } else {
                            System.out.println("Index out of bounds!");
                        }
                    } catch (Exception e) {
                        System.out.println("Not a valid integer!");
                        break;
                    }
                    break;

                // print size of phonebook
                case 's':
                    System.out.println("The phonebook is of size " + phonebook.size());
                    break;

                // quit option
                case 'q':
                    System.out.println("Goodbye, thank you for using Phonebook Manager");
                    active = false;
                    break;

                // invalid input
                default:
                    System.out.println("Invalid command!");
                    break;
            }
            System.out.println();
        }

        scan.close();
    }

    // main
    public static void main(String[] args) {
        intro();
        session();
    }
}
