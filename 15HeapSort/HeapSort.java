import java.util.Arrays;
public class HeapSort{
    public static void sort(int[] array){
	int i = 0;
	while (i < array.length){
	    int currIndex = i;
	    int parIndex = (currIndex + 1)/ 2 - 1;
	    while (parIndex >= 0 && array[currIndex] > array[parIndex]){
		int temp = array[currIndex];
		array[currIndex] = array[parIndex];
		array[parIndex] = temp;
		currIndex = parIndex;
		parIndex = (currIndex + 1) / 2 - 1;
		
	    }
	    i = i + 1;
	}
	while ( i > 0){
	    int temp = array[0];
	    array[0] = array[i - 1];
	    array[i - 1] = temp;

	    i = i - 1;

	    int currRootIndex = -1;
	    int newRoot = 0;
	    while(newRoot != currRootIndex){
		currRootIndex = newRoot;
		int leftIndex = currRootIndex * 2 + 1;
		if (leftIndex < i && array[leftIndex] > array[newRoot]){
		    newRoot = leftIndex;
		}
		int rightIndex = currRootIndex * 2 + 2;
		if (rightIndex < i && array[rightIndex] > array[newRoot]){
		    newRoot = rightIndex;
		}
		int tempInt = array[currRootIndex];
		array[currRootIndex] = array[newRoot];
		array[newRoot] = tempInt;
	    }
	}
	    
	    
    }
    public static void main (String [] args){
	int[] array = {71, 86, 79, 36, 78, 35, 75, 86, 24, 11};
	sort(array);
	System.out.println(Arrays.toString(array));
	
}
		
		
	    
}
