public class SortedDoublyLinkedList implements LinkedList{
    private Node head;
    public int size;
    public int assignmentCount;

    public SortedDoublyLinkedList(){
        head = null;
        size = 0;
        assignmentCount = 2;
    }

    public void insert(Warrior warrior){
        Node newNode = new Node(warrior, null, null);
        if (head == null) {
            head = newNode;
            assignmentCount++;
        } else if (head.data.getSpeed() < newNode.data.getSpeed()){
            newNode.next = head;
            assignmentCount = assignmentCount + 2;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && (newNode.data.getSpeed() <= current.data.getSpeed())){
                current = current.next;
                assignmentCount++;
            }
            current.next = newNode;
            assignmentCount++;
        }
        size++;
    }

    public String toString(){
        String result = "";
        result = result + "[";
        Node ptr = head;
        for (int i = 0; i < size; i++){
            result = result + ptr.data + " ";
            ptr = ptr.next;
        }
        if (size > 0){
            result = result.substring(0, result.length() - 1);
        }
        result = result + "]\n";
        return result;
    }
}
