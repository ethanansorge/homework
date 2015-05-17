public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
    }
    public void add(int value){
	if (max.getSize() >= 1 && value < max.peek()){
	    max.add(value);
	}else{
	    min.add(value);
	}
	int dif = max.getSize() - min.getSize();
	if (dif > 1){
	    min.add(max.remove());
	}else if(dif < - 1){
	    max.add(min.remove());
	}   
    }
    public double getMedian(){
	if (min.getSize() == max.getSize()){
	    return (min.peek() + max.peek()) / 2.0;
	}else{
	    if (min.getSize() > max.getSize()){
		return min.peek();
	    }
	    return max.peek();
	}
    }
}
