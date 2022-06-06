package TreesAndGraphs;

public class NodeWithParent<T> {
    public NodeWithParent<T> left;
    public NodeWithParent<T> right;
    public NodeWithParent<T> parent;
    public T value;

    public NodeWithParent(T value) {
        this.value = value;
    }

    public void setLeft(NodeWithParent<T> left) {
        this.left = left;
    }

    public void setRight(NodeWithParent<T> right) {
        this.right = right;
    }

    public void setParent(NodeWithParent<T> parent) {this.parent = parent;}

    @Override
    public String toString() {
        return "(" + this.value.toString() + ")";
    }
}
