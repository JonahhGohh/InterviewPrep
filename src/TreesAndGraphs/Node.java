package TreesAndGraphs;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T value;

    public Node(T value) {
        this.value = value;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + this.value.toString() + ")";
    }
}
