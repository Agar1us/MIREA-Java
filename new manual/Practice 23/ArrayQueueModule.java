public class ArrayQueueModule {
    private static int front = -1;
    private static int rear = -1;
    private static Object[] elements = new Object[8];

    public static void enqueue(Object element) {
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

    public static Object element() {
        assert !isEmpty();
        return elements[front];
    }

    public static Object dequeue() {
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

    public static int size() {
        return rear - front  + (front > rear ? elements.length : 0);
    }

    public static boolean isEmpty() {
        return front == -1;
    }

    public static void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public static void print(){
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
        ArrayQueueModule el;
        enqueue(8);
        enqueue(6);
        enqueue(12);
        enqueue(39);
        print();
        dequeue();
        print();
        clear();
        print();
    }
}
