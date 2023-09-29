package Cajon;
/*
 * El fallo se encontraba en el +1 del caso deafult, tras borrarlo funciona y pasa los test.
 */
public class Fibonacci {
	public int fib(int n) {
		switch (n) {
			case 0: return 0;
			case 1: return 1;
			default: return (fib(n - 1) + fib(n - 2));
		}
	}
}
