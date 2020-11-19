public class QuadraticHashtable<T> extends Hashtable<T>{

    public QuadraticHashtable(int capacity){
        super(capacity);
    }

    public int rehash(int previousHash){
        return (previousHash * previousHash) % capacity;
    }
}