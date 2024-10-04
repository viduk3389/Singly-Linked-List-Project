package com.example;

public class SinglyLinkedList {
    public static void main(String[] args) {
        // Create the initial linked list and print it
        Node linkedList = getLinkedList();
        System.out.println("Initial List:");
        printList(linkedList);

        // Add a new node before the head (insert 10 at the beginning)
        Node newNode = new Node(10);
        newNode.setNextNode(linkedList); 
        linkedList = newNode;            
        System.out.println("Inserting 10 at the beginning:");
        printList(linkedList);

        // Remove a node with value 50
        linkedList = linkedList.removeNode(50); 
        System.out.println("Removing node with value 50:");
        printList(linkedList);

        // Add a node after the tail
        Node anotherNode = new Node(70);
        linkedList.insertNodeAfterTail(anotherNode);
        System.out.println("List after inserting node after the tail:");
        printList(linkedList);

        // Insert a node with value 35 between nodes 30 and 40
        Node nodeToInsert = new Node(35);
        linkedList.insertNode(30, nodeToInsert); 
        System.out.println("List after inserting 35 between 30 and 40:");
        printList(linkedList);

        // Reverse the list and print it
        Node reversedList = linkedList.getReversedList();
        System.out.println("Reversed list:");
        printList(reversedList);

        // Check if the list is empty
        System.out.println("Is list empty? " + linkedList.isEmpty());

        // Find the size of the list
        System.out.println("Size of the list: " + linkedList.getSize());

        // Search for an element in the list
        int targetValue = 30;
        int position = linkedList.searchElement(targetValue);

        if (position != -1) {
            System.out.println("Element " + targetValue + " found at position: " + position);
        } else {
            System.out.println("Element " + targetValue + " not found in the list.");
        }
    }

    // Create a linked list with values 20, 30, 40, 50, 60
    public static Node getLinkedList() {
        Node nodeOne = new Node(20);
        Node nodeTwo = new Node(30);
        Node nodeThree = new Node(40);
        Node nodeFour = new Node(50);
        Node nodeFive = new Node(60);

        nodeFour.setNextNode(nodeFive);
        nodeThree.setNextNode(nodeFour);
        nodeTwo.setNextNode(nodeThree);
        nodeOne.setNextNode(nodeTwo);
        return nodeOne;
    }

    // Traversal and Printing of a Singly Linked List
    public static void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println("null");
    }
}

