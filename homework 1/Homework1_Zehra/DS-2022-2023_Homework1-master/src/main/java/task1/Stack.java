package task1;

public class Stack<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;

    public Stack() {
        this.q1 = new Queue<Item>();
        this.q2 = new Queue<Item>();
    }

    public void push(Item data) {
        q2.enqueue(data);

        while(!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }

        while(!q2.isEmpty()) {
            q1.enqueue(q2.dequeue());
        }
    }

    public Item pop() {
        Item temp = q1.dequeue();
        return temp;
    }

    public Item peek() {
        Item firstElement = q1.dequeue();
        push(firstElement);
        return firstElement;
    }

    public int size() {
        if(q1.isEmpty())
            return 0;

        int sizeOfStack = q1.size();
        return sizeOfStack;
    }

    public boolean isEmpty() {
        if(q1.isEmpty())
            return true;
        return false;
    }
}
