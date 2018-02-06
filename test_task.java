import java.util.Scanner;

public class DemoApp1 {

Node head;

// Create Node
class Node {
    int data;   // Data part
    Node next;  // Address to next node

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Method to add new node
public void addNode(int data) {

    // if new node is the very first node
    if (head == null) {
        head = new Node(data);
        return;
    }

    // Create new node
    Node newNode = new Node(data);
    // Set next of new node to null as its going to be last node of the list
    newNode.next = null;

    // Find last node of the list
    Node last = head;
    while (last.next != null) {
        last = last.next;
    }

    // Append new node at the end of list
    last.next = newNode;
}

// Delete node on the last position
public void deleteLastNode() {

    // List is empty
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    // If there is only one node in list
    if (head.next == null) {
        head = null;
        return;
    }

    Node last = head;
    Node prev = null;

    // Traverse to the last node
    while (last.next != null) {
        prev = last;
        last = last.next;
    }

    // Delete last node, set Address part of second last node to null
    prev.next = null;
}

// Delete all nodes containing data greater than given data
public void deletNode(int data) {

    // if list is empty
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    //if there is only one node in the list
    if (head.next == null && head.data > data) {
        head = null;
        return;
    }

    Node current = head;
    Node prev = null;

    // traverse to the last node
    while (current.next != null) {
        if (current.data > data) {
            // if node to be deleted is the first node
            if (current == head) {
                // move head to next position
                head = head.next;
            } else {
                // delete node
                // prev will stick to its current position
                prev.next = current.next;
            }
        } else {
            // move prev to next position
            prev = current;
        }
            // move current to next position
        current = current.next;
    }

    // delete last node data greater than given data
    if (current.data > data) {
      prev.next = null;
    }

}

public void traverse() {

    // if new node is the very first node
    if (head == null) {
        System.out.println("List is Empty.");
        return;
    }

    Node last = head;
    System.out.println("Linked List :");
    while (last.next != null) {
        System.out.print(last.data + " > ");
        last = last.next;
    }
    System.out.print(last.data + "  ");
    System.out.println("");
}

public static void main(String args[]) {
    DemoApp1 app = new DemoApp1();
    while (true) {
        System.out.println("");
        System.out.println("-- Operations --");
        System.out.println("-- 1.Add New Node--");
        System.out.println("-- 2.Delete Last Node --");
        System.out.println("-- 3.Delete Nodes Greater Than  --");
        System.out.println("-- 4.Exit --");
        System.out.println("-----------");
        System.out.println("");
        System.out.println("Enter your choice.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int inputData;

        switch (choice) {
            case 1:
                System.out.print("Enter Input Data : ");
                inputData = sc.nextInt();
                app.addNode(inputData);
                app.traverse();
                break;
            case 2:
                app.deleteLastNode();
                app.traverse();
                break;
            case 3:
                System.out.print("Enter Input Data : ");
                inputData = sc.nextInt();
                app.deletNode(inputData);
                app.traverse();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice. Try again.");
        }
    }
}
}
