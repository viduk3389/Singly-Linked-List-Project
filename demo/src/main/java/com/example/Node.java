package com.example;

public class Node {
    int data;  // Changed data type to int for simplicity
    Node nextNode = null;

    // Constructor
    public Node(int dataValue) {
        this.data = dataValue;
    }

    // Getter and Setter
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNodeValue) {
        this.nextNode = nextNodeValue;
    }

    // Add a node at a specific position (in this case, after 30)
    public void insertNode(int targetData, Node insertingNode) {
        Node currentNode = this;
        while (true) {
            if (currentNode.data == targetData) {
                insertingNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(insertingNode);
                break;
            } else if (currentNode.getNextNode() == null) {
                System.out.println("Warning: Target data not found.");
                break;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
    }

// Remove a specific node by value
  public Node removeNode(int value) {
    // If the node to be removed is the head
    if (this.data == value) {
        return this.nextNode; 
    }

    Node currentNode = this;
    while (currentNode != null && currentNode.nextNode != null) {
        if (currentNode.nextNode.data == value) {
            currentNode.setNextNode(currentNode.nextNode.nextNode);
            break;
        }
        currentNode = currentNode.nextNode;
    }
    return this; 
}

    // Add a node after the tail node
    public void insertNodeAfterTail(Node insertingNode) {
        Node currentNode = this;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(insertingNode);
    }

    // Add a node before the head
    public void insertBeforeHead(Node newHead) {
        Node copyOfList = new Node(this.data);
        copyOfList.setNextNode(this.getNextNode());
        this.data = newHead.data;
        this.setNextNode(copyOfList);
    }
    

    // Find the size of the list
    public int getSize() {
        Node currentNode = this;
        int size = 0;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return this.data == 0 && this.getNextNode() == null;
    }

    // Element Search in Singly Linked List
    public int searchElement(int targetValue) {
        Node currentNode = this;
        int position = 0;

        while (currentNode != null) {
            if (currentNode.data == targetValue) {
                return position; 
            }
            currentNode = currentNode.getNextNode();
            position++;
        }

        return -1; // Return -1 if element not found
    }

    // Reverse the linked list
    public Node getReversedList() {
        Node nextNode = null;
        Node previousNode = null;
        Node currentNode = this;
        while (currentNode != null) {
            if (previousNode == null) {
                previousNode = new Node(currentNode.data);
            } else {
                nextNode = new Node(currentNode.data);
                nextNode.setNextNode(previousNode);
                previousNode = nextNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return nextNode;
    }
}
