/**
* Algorithm 2 is Merge Sort
*/

public class MergeSort extends Sorter {

    public void sort(double[] list){
        // get list length
        int n = list.length;
        countOp(1);
        // base case
        if (n < 2) {
            return;
        }
        // split list up into two different lists
        int mid = n / 2;
        double[] l = new double[mid];
        double[] r = new double[n - mid];
        countOp(3);

        countOp(1);
        for (int i = 0; i < mid; i++) {
            l[i] = list[i];
            countOp(1);
        }
        countOp(1);
        for (int i = mid; i < n; i++) {
            r[i - mid] = list[i];
            countOp(1);
        }
        // recursively call this until base case is met
        sort(l);
        sort(r);
        // merge the two lists 
        merge(list, l, r, mid, n - mid);
    }

    /**
    * Merge two divided lists together for each rucersive call
    */
    public void merge(double[] list, double[] l, double[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        countOp(3);
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                list[k++] = l[i++];
                countOp(1);
            } else {
                list[k++] = r[j++];
                countOp(1);
            }
        }
        while (i < left) {
            list[k++] = l[i++];
            countOp(1);
        }
        while (j < right) {
            list[k++] = r[j++];
            countOp(1);
        }
    }
}