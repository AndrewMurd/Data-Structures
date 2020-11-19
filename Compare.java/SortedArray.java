public class SortedArray implements LinkedList {
    Warrior[] arr;
    int size;
    public int assignmentCount;

    public SortedArray() {
        arr = new Warrior[150];
        size = 0; 
        assignmentCount = 2;
    }

    public void insert(Warrior warrior) {
        if (size == 0) {
            arr[0] = warrior;
            assignmentCount++;
        } else {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null){
                    arr[i] = warrior;
                    assignmentCount++;
                    break;
                }else if (arr[i].getSpeed() < warrior.getSpeed()) {
                    for (int j = size; j > i; j--) {
                        arr[j + 1] = arr[j];
                        assignmentCount++;
                    }
                    assignmentCount++;
                    arr[i] = warrior;
                    break;
                }else if (arr[i] == null){
                    arr[i] = warrior;
                }  
            }
        }
        size++;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result = result + arr[i];
        }
        if (size == 0) {
            result = "Array is Empty!";
        }
        result = result + "]\n";
        return result;
    }
}