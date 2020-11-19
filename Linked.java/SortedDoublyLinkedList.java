class Node {
    Node next, prev;
    Warrior data;

    public Node(){
        next = null;
        prev = null;
        data = null;
    }

    public Node(Warrior a, Node next, Node prev){
        this.next = next;
        this.prev = prev;
        this.data = a;
    }
}

public class SortedDoublyLinkedList implements LinkedList{
    private Node head;
    public int size;

    public SortedDoublyLinkedList(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void insert(Warrior warrior){
        Node newNode = new Node(warrior, null, null);
        if (head == null) {
            head = newNode;
        } else if (head.data.getSpeed() < newNode.data.getSpeed()){
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && (newNode.data.getSpeed() <= current.data.getSpeed())){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public String toString(){
        String result = "";
        result = result + "[";
        Node ptr = this.head;
        for (int i = 0; i < this.size; i++){
            result = result + ptr.data + " ";
            ptr = ptr.next;
        }
        if (this.size > 0){
            result = result.substring(0, result.length() - 1);
        }
        result = result + "]\n";
        return result;
    }
}
