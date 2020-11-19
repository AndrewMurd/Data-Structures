public class AVLDriver {
  public static void add(AVLTree tree, int value) {
    tree.insert(value);
    System.out.printf("After insert %d:\n", value);
    tree.print();
    System.out.println("");
  }
  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    System.out.println("Initial:");
    tree.print();

    // double rotation left
    add(tree, 2);
    add(tree, 1);
    add(tree, 6);
    add(tree, 7);
    add(tree, 4);
    add(tree, 3);
    add(tree, 5);
    

    //double right
    // add(tree, 6);
    // add(tree, 7);
    // add(tree, 2);
    // add(tree, 1);
    // add(tree, 4);
    // add(tree, 3);
    // add(tree, 5);

    // add(tree, 4);
    // add(tree, 8);
    // add(tree, 9);

    // add(tree, 2);
    // add(tree, 1);
    // add(tree, 6);
    // add(tree, 7);
    // add(tree, 4);
    // add(tree, 3);
    // add(tree, 5);
    // add(tree, 2);
    // add(tree, 1);
    // add(tree, 6);
    // add(tree, 7);
    // add(tree, 4);
    // add(tree, 3);
    // add(tree, 10);
    // add(tree, 11);
    // add(tree, 12);
    // add(tree, 13);
    // add(tree, 14);
    // add(tree, 15);
    // add(tree, 16);
    // add(tree, 17);
  }
}
