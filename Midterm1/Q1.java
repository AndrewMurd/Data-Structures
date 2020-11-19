public class Q1{
    public static void main(String[] args) {
        int[] list1 = { 1, 6, 3, 4, 14, 16, 14 };
        System.out.println("Max: " + maximumDivideAndConquer(list1));
        // 14

        int[] list2 = { 32, 6, 11, 17, 2, 12, 30, 8, 27 };
        System.out.println("Max: " + maximumDivideAndConquer(list2));
        // 32
    }

    public static int maximumDivideAndConquer(int[] list) {
        int mid = list.length / 2;

        int[] list1 = new int[mid];
        int[] list2 = new int[mid + 1];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = list[i];
        }

        for (int i = 0; i < list2.length; i++) {
            list2[i] = list[i + mid];
        }

        if (max(list1) > max(list2)){
            return max(list1);
        } else{
            return max(list2);
        }
    }

    public static int max(int[] list) {
        int Max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] > Max){
                Max = list[i];
            }
        }
        return Max;
    }
}