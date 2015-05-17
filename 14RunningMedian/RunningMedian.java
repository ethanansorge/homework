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
    public static void main(String [] args){
	RunningMedian median = new RunningMedian();
	median.add(71);
	median.add(86);
	median.add(79);
	median.add(36);
	median.add(78);
	median.add(35);
	median.add(75);
	median.add(86);
	median.add(24);
	median.add(11); 
	median.add(0);
	median.add(-123);
	System.out.println(median.getMedian());
    }
}
