/**
* Root class that contains root OpNode.
*/

public class ExpressionTree {
    public OpNode root;

    public ExpressionTree(OpNode root){
        this.root = root;
    }

    /**
    * Calls evaluate on root node and recursively computes result
    * @return final result of tree
    */
    public double evaluate(){
        double result = 0.0;
        result = this.root.evaluate();
        return result;
    }

    /**
    * Recursively prints out tree
    */      
    public void print(){
        this.root.print(0);
    }
}