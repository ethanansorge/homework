public class Recursion{

    public String name(){
	String s = "Ansorge,Ethan";
	return s;
    }

    public int fact(int n){
	int x = 1;
	if (n > 1){
	    x = n * fact(n - 1);
	}
	return x;
    }
    
    public static void main (String [] args){
	Recursion r = new Recursion();
	//System.out.println(r.fact(4));
	//System.out.println(r.fact(0));
	//System.out.println(r.fact(2));
	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(2));
	System.out.println(r.fib(3));
	System.out.println(r.fib(4));
	System.out.println(r.fib(5));
	System.out.println(r.fib(6));
    }

    public int fib(int n){
	if (n > 1){
	    return fib(n-2) + fib(n-1);
	}
	return n;
    }

    public double sqrt(double n){
	double guess = n / 2;
	makeGuess(n / guess + guess) / 2;
    }

    public double makeGuess(double n, double guess){
	sqrt(guess);
    }
}
