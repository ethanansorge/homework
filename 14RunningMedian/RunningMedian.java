public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
    }
    public void add(int value){
	if (value > getMedian()){
	    min.add(value);
	}else{
	    max.add(value);
	}
    }
    public double getMedian(){
	if (min.values.size() == max.values.size()){
	    return (min.values.get(1) + max.values.get(1)) / 2.0;
	}else{
	    if (min.values.size() > max.values.size()){
		return min.values.get(1);
	    }
	    return max.values.get(1);
	}
    }
}