public class ArrayQueueADT {
    private int front = 0;
    private int rear = 0;
    private Object[] elements = new Object[8];

    public static void enqueue(ArrayQueueADT queue, Object element) {
        if ((queue.rear + 1) % queue.elements.length != queue.front){
            if (queue.front == -1){
                queue.front = queue.rear = 0;
                queue.elements[queue.front] = element;
            }
            else{
                queue.rear = (queue.rear + 1) % queue.elements.length;
                queue.elements[queue.rear] = element;
            }
        }
    }

    public static Object element(ArrayQueueADT queue) {
        if (!isEmpty(queue))
            return queue.elements[queue.front];
        return -1;
    }

    public static Object dequeue(ArrayQueueADT queue) {
        if (!isEmpty(queue)) {
            Object tmp = queue.elements[queue.front];
            if (queue.front == queue.rear)
                queue.front = queue.rear = -1;
            else
                queue.front = (queue.front + 1) % queue.elements.length;
            return tmp;
        }
        return -1;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.rear - queue.front + (queue.front > queue.rear ? queue.elements.length : 0);
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.front == -1;
    }

    public static void clear(ArrayQueueADT queue) {
        while (!isEmpty(queue)) {
            dequeue(queue);
        }
    }

    public static void main(String [] args){
        ArrayQueueADT check = new ArrayQueueADT();
        enqueue(check, 6);
        enqueue(check, 4);
        System.out.print(element(check) + " " + size(check));
        dequeue(check);
        clear(check);
    }
}
