/** 
* Abstract interface for OpNode and ValueNode
*/

interface TreeNode {
    public abstract void print(int depth);

    public abstract double evaluate();
}