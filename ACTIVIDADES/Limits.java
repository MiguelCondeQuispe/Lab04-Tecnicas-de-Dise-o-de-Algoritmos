package ACTIVIDADES;

public class Limits {
	public int[] a;
	public int prim;
	public int ult;

    public Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }

    int longitud() {
        return ult - prim + 1;
    }
}
