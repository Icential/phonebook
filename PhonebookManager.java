// Marco Soekmono
// 2/8/23
// CS145
// Assignment #1

// This program will serve as a database like
// a LinkedList except it's not made from said class.
// It is able to store ListNode entries which can be
// modified, added and removed accordingly that inherits
// most of LinkedList's methods.

import java.util.ArrayList;

public class PhonebookManager {
    // store list collection
    private ArrayList<ListNode> collection;

    // constructor; init collection
    public PhonebookManager() {
        this.collection = new ArrayList<ListNode>();
    }

    // add node to last
    public void add(ListNode node) {
        collection.add(node);
    }

    // set an index's node
    public void set(int i, ListNode node) {
        collection.set(i, node);
    }

    // add a node to the first entry
    public void addFirst(ListNode node) {
        ArrayList<ListNode> filler = new ArrayList<ListNode>();
        filler.add(node);
        filler.addAll(collection);
        collection = filler;
    }

    // add node to last (alt)
    public void addLast(ListNode node) {
        collection.add(node);
    }

    // get node of an index
    public ListNode get(int i) {
        return collection.get(i);
    }

    // get node of first index
    public ListNode getFirst() {
        return collection.get(0);
    }

    // get node of last index
    public ListNode getLast() {
        return collection.get(collection.size()-1);
    }

    // remove node of an index
    public void remove(int i) {
        collection.remove(i);
    }

    // remove node of first index
    public void removeFirst() {
        collection.remove(0);
    }
    
    // remove node of last index
    public void removeLast() {
        collection.remove(collection.size()-1);
    }

    // get node size
    public int size() {
        return collection.size();
    }

    // check if a string or node exists in the collection
    public boolean contains(Object o) {
        if (o instanceof ListNode) {
            return collection.contains(o);
        } else if (o instanceof String) {
            for (ListNode node : collection) {
                for (int i = 0; i < 5; i++) {
                    if (node.get(i).equals(o)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    // print entire collection to a breakline'd string
    public String toString() {
        String total = "";
        for (ListNode n : collection) {
            total += n.toString() + "\n";
        }
        return total;
    }
}
