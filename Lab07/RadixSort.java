import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        String[] origNumbers = { "0011", "1001", "1000", "0111", "0101" };
        List<String> numbers = new ArrayList<>();
        for (String num : origNumbers) {
            numbers.add(num);
        }
        int numDigits = 4;

        print(numbers);
        numbers = sort(numbers, numDigits);
    }

    public static List<String> sort(List<String> list, int n) {

        for (int a = n - 1; a >= 0; a--) {
            Buckets bucket = new Buckets();

            for (String num : list) {
                if (num.charAt(a) == '1') {
                    bucket.addOne(num);
                } else {
                    bucket.addZero(num);
                }
            }
            list = bucket.getAllInOrder();
            print(list);
        }
        return list;
    }

    public static void print(List<String> list){
        System.out.print("[ ");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.print("]\n");
    }
}
