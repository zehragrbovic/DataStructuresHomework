package task2;

public class RedBlackTree <Key extends Comparable<Key>, Value> {
    // Implement the required properties of a red-black tree
    private Node<Key, Value> root;
    // track the number of iterations needed for the get() operation to complete
    public int numSteps = 0;

    public RedBlackTree() {
        this.root = null;
    }

    public Value get(Key key) {
        // implement the actual logic

        numSteps = 0;

        Node<Key, Value> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.getLeft();
            } else if (cmp > 0) {
                current = current.getRight();
            } else {
                numSteps++; // Increments the steps for the successful search
                return current.value;
            }
            numSteps++; // Increments the steps for each iteration
        }

    return null;
    }

    private Node<Key, Value> search(Node<Key, Value> node, Key key, int steps) {
        if (node == null || key.compareTo(node.getKey()) == 0) {
            numSteps = steps;
            return node;
        }

        //numSteps++;

        if (key.compareTo(node.getKey()) < 0) {
            return search(node.getLeft(), key, steps + 1);
        } else {
            return search(node.getRight(), key, steps + 1);
        }
    }

    public void put(Key key, Value value) {
        // implement the actual logic

        root = insert(root, key, value);
        root.setRed(false); // Sets the color of the root node to black
    }

    private Node<Key, Value> insert(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        // Performs rotations and color flips to maintain red-black tree properties
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        return node;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        newRoot.setRed(node.isRed());
        node.setRed(true);
        return newRoot;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        newRoot.setRed(node.isRed());
        node.setRed(true);
        return newRoot;
    }

    private void flipColors(Node<Key, Value> node) {
        node.setRed(!node.isRed());
        node.getLeft().setRed(!node.getLeft().isRed());
        node.getRight().setRed(!node.getRight().isRed());
    }

    private boolean isRed(Node<Key, Value> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    public int countRedLinks() {
        if (root == null) {
            return 0;
        }
        return countRedLinks(root);
    }

    private int countRedLinks(Node<Key, Value> node) {
        int count = 0;
        if (node.isRed()) {
            count++;
        }
        if (node.getLeft() != null) {
            count += countRedLinks(node.getLeft());
        }
        if (node.getRight() != null) {
            count += countRedLinks(node.getRight());
        }
        return count;
    }

    public int getNumSteps() {
        return numSteps;
    }
}
