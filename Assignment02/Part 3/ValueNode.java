/** 
* ValueNode implements TreeNode interface.
* ValueNode class holds double values to for the computation.
*/

public class ValueNode implements TreeNode {
    public double value;

    public ValueNode(double value) {
        this.value = value;
    }

    /**
    * Prints out values
    * @param depth correct depth for values to be placed and computed
    */
    public void print(int depth) {
        for (int i = 0; i <= depth-1; i++){
            System.out.print("\t");
        }
        System.out.println(this.value);
    }

    /**
    * @return double value of node
    */
    public double evaluate() {
        return this.value;
    }
}