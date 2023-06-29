package task2;

public class Node<Key extends Comparable<Key>, Value> {

    // Implement the required properties of a red-black tree node

    protected Key key;
    protected Value value;
    protected Node<Key, Value> left;
    protected Node<Key, Value> right;
    protected boolean isRed;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.isRed = true;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(Node<Key, Value> left) {
        this.left = left;
    }

    public Node<Key, Value> getRight() {
        return right;
    }

    public void setRight(Node<Key, Value> right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }


}
