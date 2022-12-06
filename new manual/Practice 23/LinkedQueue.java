public class LinkedQueue {
    private Node rear;
    private Node front;

    private int size;

    protected void enqueueRealisation(Object element) {
        rear = new Node(element, null, rear);
        if (isEmpty())
            front = rear;
        else
            rear.next.prev = rear;
        size++;
    }

    protected Object elementRealisation() {
        return front.value;
    }

    protected void dequeueRealisation() {
        if (front.prev != null) front.prev.next = null;
        front = front.prev;
        size--;
    }

    protected int size(){
        return size;
    }

    protected boolean isEmpty(){
        return front == null;
    }

    private class Node {
        Object value;
        Node prev;
        Node next;

        Node(Object element, Node prev, Node next) {
            value = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue ans = new LinkedQueue();
        ans.enqueueRealisation(5);
        ans.enqueueRealisation(6);
        ans.enqueueRealisation(7);
        ans.dequeueRealisation();
        System.out.print(ans.elementRealisation());

    }
}
