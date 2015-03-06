import java.util.Arrays;
public class quicksort{
    public static int partition (int[] ary, int start, int end){
	int pivot = ary[end];
	start = start + 1;
	int [] d = new int[ary.length];
	int z = d.length -1;
	while (z > end){
	    d[z] = ary[z];
	    z = z -1;
	}
	while (start < ary.length -1){
	    if (ary[start] < pivot){
		d[start] = ary[start];
		start = start + 1;
	    }else{
		d[end] = ary[end];
		end = end - 1;
	    }
	    System.out.println(Arrays.toString(d));
	}
	return d[pivot];
    }
    public static void main (String [] args){
	int[] a = new int [7];
	a[0] = 5;
	a[1] = 2;
	a[2] = 3;
	a[3] = 8;
	a[4] = 9;
	a[5] = 1;
	a[6] = 6;
	partition(a, 0, 6);
	System.out.println(a);
    }
}
