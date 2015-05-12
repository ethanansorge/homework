Public class MyHeap{
    public ArrayList values;
    public boolean max;

    public MyHeap(){
	this.myHeap(true);
    }
    public MyHeap(boolean isMax){
	values = new ArrayList();
	max = isMax;
    }
    public void add(int value){
	if values.size
	int i = 0;
	while (i < values.size()){
	    if (max){
		if (value > values[i]){

		    return;
		}
	    }else{
		if (value < values[i]){
		    
		    return;
		}
	    }
	}
    }
    public int remove(){
    }
    public int peek(){
    }
    public String toString(){
    }
    
}
    