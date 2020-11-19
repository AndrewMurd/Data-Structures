/** 
* OpNode class implements TreeNode interface. 
* This class handles the operations btween ValueNodes.
*/

public class OpNode implements TreeNode {
    public String operation;
    public TreeNode left;
    public TreeNode right;

    public OpNode(TreeNode left, String operation, TreeNode right) {
        this.left = left;
        this.operation = operation;
        this.right = right;
    }

    /**
    * Recursively prints out trees operations and values
    * @param depth current depth of tree
    */
    public void print(int depth) {
        this.right.print(depth+1);

        for (int i = 0; i <= depth-1; i++){
            System.out.print("\t");
        }

        System.out.println(this.operation);
        this.left.print(depth+1);
    }

    /**
    * Evaluate OpNode expression recursively through the tree
    * @return result final result of the expression
    */
    public double evaluate() {
        double result = 0.0;
        switch (this.operation) {
            case "/":
                result = this.left.evaluate() / this.right.evaluate();
                break;
            case "*":
                result = this.left.evaluate() * this.right.evaluate();
                break;
            case "+":
                result = this.left.evaluate() + this.right.evaluate();
                break;
            case "-":
                result = this.left.evaluate() - this.right.evaluate();
                break;
        }
        return result;
    }
}