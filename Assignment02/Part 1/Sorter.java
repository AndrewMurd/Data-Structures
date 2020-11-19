public abstract class Sorter {
    private long opCount = 0L;

    public long getOpCount() {
        return this.opCount;
    }

    protected void resetOpCount() {
        this.opCount = 0L;
    }

    /**
    * @param num number of assigment operations to be added to total count
    */
    protected void countOp(int num) {
        this.opCount = this.opCount + num;
    }

    public abstract void sort(double[] list);
}