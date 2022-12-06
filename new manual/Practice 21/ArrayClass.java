import java.util.Arrays;
import java.util.Comparator;

public class ArrayClass <T>{
    private T[] arr;
    private int count;
    private int size;

    public ArrayClass(){
        this(8);
    }

    public ArrayClass(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        count = 0;
    }

    public ArrayClass(ArrayClass<T> other){
        this.count = other.count;
        this.size = other.size;
        this.arr = (T[]) new Object[size];
        System.arraycopy(other.arr, 0, arr, 0, count);
    }

    public void add(T o){
        if(size - count == 1) resize(size*2);
        arr[count++] = o;
    }
    public void sort(Comparator<? super T> comp){
        for (int i = 1; i < count; i++) {
            boolean ch = false;
            for(int j = count - 1; j > i; j--){
                if(comp.compare(arr[j], arr[j - 1]) < 0){
                    T tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    ch = true;
                }
            }
            if(!ch)
                break;
        }
    }
    public T remove(int index){
        if(index > count)
            throw new IndexOutOfBoundsException();
        T o = arr[index];
        System.arraycopy(arr, index+1, arr, index, count-index-1);
        arr[--count] = null;
        if(count < size / 2)
            resize(size / 2);
        return o;
    }


    private void resize(int newSize){
        if(newSize > size)
            arr = Arrays.copyOf(arr, newSize);
        else{
            T[] tmp = (T[])new Object[newSize];
            System.arraycopy(arr, 0, tmp, 0, newSize);
            arr = tmp;
        }
        this.size = newSize;

    }

    public T get(int index){
        if(index > count)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public String toString() {
        return "Созданной мною массив:" +
                "\n    Элементы: " + Arrays.toString(arr) +
                "\n    Размер массива" + size +
                "\n    Количество элементов=" + count + "\n";
    }
}
