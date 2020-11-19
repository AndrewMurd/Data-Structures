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