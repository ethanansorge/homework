public class MyDeque{
    Object[] queue;
    int head;
    int tail;
    int size;

    public void addLast(T value){
    }

    public void addFirst(T value){
    }

    public T removeFirst(){
    }

    public T removeLast(){
	T temp = queue[tail];
	queue[tail] = null;
	size = size - 1;
	tail = tail - 1;
    }

    public T getFirst(){
	return (T) queue[head];
    }

    public T getLast(){
	return (T) queue[tail];
    }

    public void resize(){
	Object[] newQueue = new Object[size * 2];
	int i = 0;
	int x = 0;
	while (i < size - 1){
	    if (x > size){
		x = 0;
	    }
	    newQueue[i] = queue[x];
	    i = i + 1;
	    x = x + 1;
	}
	queue = newQueue;
	head = 0;
	tail = i - 1;
    }
}
