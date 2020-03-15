/**
 * Syntax of SinglyLinkedList
 * Written by: Mohammed Ismail Al-Taifi
 */

/**
 * As it's supposed to be in java the super class should be name after the file
 * name and what inside the angle brackets <> works as a Variable for Data types
 * to genericise the class for instance to use it with either String, Integer,
 * Double, etc..
 */
public class SinglyLinkedList<DataType> {
    /**
     * For the Singly linked list there is A node, this node contains two attributes
     * Data, Next; the Data containes any data that is passed to it as long as the
     * node is genericised, and the Next attribute is used for pointing to the
     * following node in the Linked List
     * 
     * Tips: Make the node class private for more safty And Generic to genericise
     * the inserted data types, making the node staic is design choise since the
     * Node class is neasted
     */
    private static class Node<DataType> {
        /**
         * Again as it has been clarified before the Linked list has to attributes The
         * 'Data' attribute that stores data
         */
        private DataType data;
        /**
         * And the 'Next' attribute that point to the following Node and normally it
         * should be a "Node<DataType>" data typed because it stores another node
         */
        private Node<DataType> next;

        // Constructor
        Node(DataType data, Node<DataType> next) {
            this.data = data;
            this.next = next;
        }

        // Usual accessors methods (Getters and Setters)
        public DataType getData() {
            return data;
        }

        public Node<DataType> getNext() {
            return next;
        }

        public void setData(DataType data) {
            this.data = data;
        }

        public void setNext(Node<DataType> next) {
            this.next = next;
        }

        // That's all for the singly linked list's node//
    }

    // The following are the SinlgyLinkedList Attributes
    /**
     * The head: is the first element in the list and its Heart! if the Head made to
     * be null the whole linked list would get garbage collected
     */
    private Node<DataType> head = null; // The head is valued to null! so no linked list is created yet
    private Node<DataType> tail = null; // The tail is the last element in the list and counted as the closer
    private int size = 0; // We'd need a counter to check easly how many elements have we got in our list
    // End of attributes

    // Constructor
    SinglyLinkedList(){}

    // Access methods
    public int size(){return size;} // To safily get the Linked list size
    public boolean isEmpty(){return size == 0;} // To safily get the Linked list size

    // First and Last methods are made to show what does the head contain or the tail
    public DataType first(){return isEmpty()?null:head.getData();}
    public DataType last(){return isEmpty()?null:tail.getData();}

    // Update methods 
    /**
     *  Add first method is to add a node to the first of the node
     *          How it works?
     *                  it creates a new node with 'head' as a value for next then makes that node the new head
     *                  ```
     *                  NewNode = NewData, next is head
     *                  head = NewNode
     */
    public void addFirst(DataType data){
        // The privous algorithm is simply expressed in java like the following
        head = new Node<DataType>(data, head);
        // In case the empty has only one node! Thus it should be the head and should be the tail at the same time
        if(isEmpty())tail = head;
        // And of course the size would get increasement
        size++;
    }
    /**
     * Add last method is to add a node as the tail
     */
    public void addLast(DataType data){
        Node<DataType> newNode = new Node<DataType>(data, null); // the next is null because the tail alaways points to null
        if(isEmpty())head = newNode; // Obviously when the linkedlist is empty the head would be the only node
        else tail.setNext(newNode); /** But when there's a tail, the tail will preced the new node */
        tail = newNode;/** and finally the new tail would be new node we've just created 
                           noticing that the varibal 'tail' works as a pointer and don't remove the previous tail
                           by updating it
                           */
        size++;

    }
    public DataType removeFirst(){
        if(isEmpty())return null; // We don't need to do anything when the list is empty
        DataType garbage = head.getData(); // We need to know what element is gettign elimination so we kept it here to return it later on
        head = head.getNext(); /**
                                In this line of code we set the head pointer to what follows it 
                                and the preivous head will get disconnected from the linked list 
                                automatically will get collected as a garbage
                                */
        size--; // The liss size shall get decrement
        return isEmpty()?null: garbage; // Check if list is empty so null would be returned else the element we removed
    }
}