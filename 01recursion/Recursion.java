public class Recursion implements hw1 {

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
    public int fib(int n){
	if (n > 1){
	    return fib(n-2) + fib(n-1);
	}
	return n;
    }

    public double sqrt(double n){
	double guess = n / 2;
	return makeGuess(n, guess);
    }

    public double makeGuess(double n, double guess){
	if( Math.abs(n - guess * guess) < .001){
	    return guess;
	}
	return makeGuess(n,((n / guess + guess) / 2));

    }
}
