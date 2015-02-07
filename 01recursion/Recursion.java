public class Recursion implements hw1 {

    public String name(){
	String s = "Ansorge,Ethan";
	return s;
    }
    public boolean checkIfValid(int n){
    	if (n < 0){
	    throw new IllegalArgumentException();
	} 
    }
    public int fact(int n){
    	checkIfValid(n);
	int x = 1;
	if (n >= 2){
	    x = n * fact(n - 1);
	}
	return x;
    }
    public int fib(int n){
    	checkIfValid(n);
    	if (n < 1){
    		return 0;
    	}else{
	if (n >= 3){
	    return fib(n-2) + fib(n-1);
	}
	return 1;
    	}
    }

    public double sqrt(double n){
    	checkIfValid(n);
	double guess = n / 2;
	return makeGuess(n, guess);
    }

    public double makeGuess(double n, double guess){
	if( Math.abs(n - guess * guess) < .0001){
	    return guess;
	}
	return makeGuess(n,((n / guess + guess) / 2));

    }
}
