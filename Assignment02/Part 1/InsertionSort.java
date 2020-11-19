/**
* Algorithm 1 is Inserstion Sort
*/

public class InsertionSort extends Sorter {

    public void sort(double[] list){
        int n = list.length;
        countOp(2);
        for (int i = 1; i < n; i++) {
            double key = list[i];
            int j = i - 1;
            countOp(2);

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
                countOp(2);
            }
            list[j + 1] = key;
            countOp(1);
        }
    }
}