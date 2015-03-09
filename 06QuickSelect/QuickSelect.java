import java.util.Arrays;
public class QuickSelect{

    public static int quickSelect(int[] ary, int n){
	return partition(ary, n, 0, ary.length);	
    }

    public static int partition (int[] ary, int n, int start, int end){
	int pivot = start + (int)(Math.random()*(end - start + 1));
	int [] d = new int[ary.length]; 
	int z = 0;
	while (z < ary.length){
	    if(z < start || z > end){
	    d[z] = ary[z];
	    }
	    z = z + 1;
	}
	System.out.println(Arrays.toString(ary));
	System.out.println ("Pivot = " + pivot + ", ary[" + pivot + "] = " + ary[pivot]);
	int x = start;
	int y = end;
	while (x <= y){
	    if (ary[x] < ary[pivot]){
		d[start] = ary[x];
		start = start + 1;
	    }else if (ary[x] > ary[pivot]){
		d[end] = ary[x];
		end = end - 1;
	    }
	    x = x + 1;
	}
	d[start] = ary[pivot];
	System.out.println(Arrays.toString(d));
	if (start == n){
	    return ary[pivot];
	}else{
	if (start < n){
	    return partition(ary, n, start, end);
	}else{
	    return partition(ary, n, 0, start);
	}
	}
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
	//partition(a, 6, 0, 6);
	//quickSelect (a, 3);
    }
}
