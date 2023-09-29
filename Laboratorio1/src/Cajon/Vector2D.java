package Cajon;


public class Vector2D {
	public Integer x, y;
	
	Vector2D(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	

	Vector2D(Point p1, Point p2) {
		this.x = p2.x - p1.x;
		this.y = p2.y - p1.y;
	}
	
	/*
	 * Fallo en la multiplicación del segundo elemento del vector (multiplicaba el eje y por el x).
	 * */
	public int dotProducto(Vector2D v) {
		return (x * v.x) + (y * v.y);
	}
	
	/*
	 * Para que dos vectores sean ortogonales su producto escalar debe ser 0, antes de modificarlo, se comparaba con -1.
	 * */
	public boolean esOrtogonalA(Vector2D v) {
		return (dotProducto(v) == 0);
	}
}

