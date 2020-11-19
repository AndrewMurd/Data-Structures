public class AVLNode {
  public AVLNode left = null;
  public AVLNode right = null;
  public int value = 0;
  public AVLNode parent = null;

  public AVLNode insert(int newValue) {
    // perform binary-search style insertion
    if (newValue < this.value) {
      // insert the value to the left sub-tree
      if (this.left == null) {
        AVLNode newNode = new AVLNode();
        newNode.value = newValue;
        newNode.parent = this;
        this.left = newNode;
      } else {
        this.left.insert(newValue);
      }
    } else {
      // insert the value into the right sub-tree
      if (this.right == null) {
        AVLNode newNode = new AVLNode();
        newNode.value = newValue;
        newNode.parent = this;
        this.right = newNode;
      } else {
        this.right.insert(newValue);
      }
    }

    return rebalance();
  }

  public AVLNode rebalance() {
    // make a temp node for rotation and to the new tree
    AVLNode temp = null;

    if (getBalance() <= -2) {
      if (this.left != null && this.left.right != null && this.left.right.left != null) {
        temp = this.left.right;
        this.left.right = temp.left;
        temp.left = this.left;
        this.left = temp;
        this.left = temp.right;
        temp.right = this;
      } else { // perform a single right rotation
        temp = this.left;
        this.left = temp.right;
        temp.right = this;
      }
    } else if (getBalance() >= 2) {
      if (this.right != null && this.right.right != null && this.right.right.left != null) {
        temp = this.right.left;
        this.right.left = temp.right;
        temp.right = this.right;
        this.right = temp;
        temp = this.right;
        this.right = temp.left;
        temp.left = this;
      } else { // perform a single left rotation
        temp = this.right;
        this.right = temp.left;
        temp.left = this;
      }
    }

    // return the new balanced tree
    return temp;
  }

  public int getBalance() {
    int rightHeight = 0;
    if (this.right != null) {
      rightHeight = this.right.getHeight();
    }

    int leftHeight = 0;
    if (this.left != null) {
      leftHeight = this.left.getHeight();
    }

    return rightHeight - leftHeight;
  }

  public void print(int depth) {
    if (this.right != null) {
      this.right.print(depth + 1);
    }

    for (int i = 0; i < depth; i++) {
      System.out.print("\t");
    }
    System.out.println(this.value);

    if (this.left != null) {
      this.left.print(depth + 1);
    }
  }

  public int getHeight() {
    int leftHeight = 1;
    if (left != null) {
      leftHeight = left.getHeight() + 1;
    }

    int rightHeight = 0;
    if (right != null) {
      rightHeight = right.getHeight() + 1;
    }

    return (leftHeight > rightHeight) ? leftHeight : rightHeight;
  }
}
