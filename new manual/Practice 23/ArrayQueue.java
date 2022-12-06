public class ArrayQueue {
    private int front = 0;
    private int rear = 0;
    private Object[] elements = new Object[8];

    public  void enqueue(Object element) {
        if ((rear + 1) % elements.length != front){
            if (front == -1){
                front = rear = 0;
                elements[front] = element;
            }
            else{
                rear = (rear + 1) % elements.length;
                elements[rear] = element;
            }
        }
    }

    public  Object element() {
        if (!isEmpty())
            return elements[front];
        return -1;
    }

    public  Object dequeue() {
        if (!isEmpty()) {
            Object tmp = elements[front];
            if (front == rear)
                front = rear = -1;
            else
                front = (front + 1) % elements.length;
            return tmp;
        }
        return -1;
    }

    public  int size() {
        return rear - front + 1 + (front > rear ? elements.length : 0);
    }

    public  boolean isEmpty() {
        return front == -1;
    }

    public  void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public void print(){
        if (!isEmpty()) {
            if (rear >= front) {
                for (int i = front; i < rear + 1; ++i)
                    System.out.print(elements[i] + " ");
            } else {
                for (int i = front; i < elements.length; ++i)
                    System.out.print(elements[i] + " ");
                for (int i = 0; i < rear + 1; ++i)
                    System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String [] args){
        ArrayQueue tmp = new ArrayQueue();
        tmp.enqueue(6);
        tmp.enqueue(8);
        System.out.print(tmp.element());
        System.out.print(tmp.size());
        tmp.dequeue();
        tmp.print();
        tmp.clear();
        tmp.print();
    }
}
