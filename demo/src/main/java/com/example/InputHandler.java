package com.example;

import java.util.Scanner;

public class InputHandler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node linkedList = SinglyLinkedList.getLinkedList();  // Start with an initial linked list
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add element at beginning");
            System.out.println("2. Add element at end");
            System.out.println("3. Add element at specific position");
            System.out.println("4. Remove element");
            System.out.println("5. Print list");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add at the beginning: ");
                    int valueAtBeginning = scanner.nextInt();
                    Node newHead = new Node(valueAtBeginning);
                    newHead.setNextNode(linkedList);
                    linkedList = newHead;  // Update head to new node
                    break;

                case 2:
                    System.out.print("Enter value to add at the end: ");
                    int valueAtEnd = scanner.nextInt();
                    Node newNodeEnd = new Node(valueAtEnd);
                    linkedList.insertNodeAfterTail(newNodeEnd);
                    break;

                case 3:
                    System.out.print("Enter value to add: ");
                    int valueAtPosition = scanner.nextInt();
                    System.out.print("Enter position to add at (0-based index): ");
                    int position = scanner.nextInt();
                    Node newNodePosition = new Node(valueAtPosition);
                    if (position == 0) {
                        newNodePosition.setNextNode(linkedList);
                        linkedList = newNodePosition;  // Update head
                    } else {
                        Node currentNode = linkedList;
                        for (int i = 0; i < position - 1 && currentNode != null; i++) {
                            currentNode = currentNode.getNextNode();
                        }
                        if (currentNode != null) {
                            newNodePosition.setNextNode(currentNode.getNextNode());
                            currentNode.setNextNode(newNodePosition);
                        } else {
                            System.out.println("Position out of bounds.");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter value to remove: ");
                    int valueToRemove = scanner.nextInt();
                    linkedList.removeNode(valueToRemove);
                    break;

                case 5:
                    System.out.println("Current list:");
                    SinglyLinkedList.printList(linkedList);
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}
