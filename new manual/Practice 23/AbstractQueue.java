public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    protected abstract void enqueueRealisation(Object element);

    protected abstract Object elementRealisation();

    protected abstract void dequeueRealisation();

    public void enqueue(Object element) {
        if (element != null){
            enqueueRealisation(element);
            size++;
        }
    }

    public Object element() {
        if (size > 0)
            return elementRealisation();
        return -1;
    }

    public Object dequeue() {
        if (size > 0){
            Object result = elementRealisation();
            dequeueRealisation();
            --size;
            return result;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}
