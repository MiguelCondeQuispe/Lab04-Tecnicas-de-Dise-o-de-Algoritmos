package ACTIVIDADES;

public class moda{
	public static int moda1(int array[]) {
		int first = 0;
		int end = array.length-1;
		
		if(first==end)
			return array[first];
		int moda = array[first];
		int maxfrec = frecuencia(array,first,end,moda);
		
		for (int i = first+1;i<end;i++) {
			int frec = frecuencia(array,i,end,array[i]);
			if (frec > maxfrec) {
				maxfrec = frec;
				moda = array[i];
			}
		}
		return moda;
	}
	
	private static int frecuencia(int []array, int first, int end, int ele) {
		if(first > end)
			return 0;
		int suma = 0;
		for (int i = first;i<=end;i++)
			if (array[i] == ele)
				suma++;
		return suma;
	}
	
	public static int moda2(int array[]) {
		int first = 1;
		int p = 0;
		int end = array.length-1;
		int moda = array[0];
		int frec = 1;
		int maxfrec = 0;
		while (first <= end) {
			if (array[p] == array[first]) {
				frec++;
				first++;
			}
			else {
				if (frec > maxfrec) {
					maxfrec = frec;
					moda = array[p];
				}
				p = first;
				first = p+1;
				frec = 1;
			}
		}
		return moda;
	}

	public static int moda3(int []a, int prim, int ult ) {
		SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();

        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);
        
        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();  // Extrae el mayor subconjunto
            int mediana = a[(p.prim + p.ult) / 2];

            int[] izqDer = Pivote2(p.a, mediana, p.prim, p.ult);
            int izq = izqDer[0];
            int der = izqDer[1];

            Limits p1 = new Limits(p.a, p.prim, izq - 1);
            Limits p2 = new Limits(p.a, izq, der - 1);
            Limits p3 = new Limits(p.a, der, p.ult);

            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) {
            return a[prim];
        }

        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.a[p.prim];
	}
	
	public static int[] Pivote2(int[] a, int mediana, int prim, int ult) {
	    int izq = prim;
	    int der = ult;

	    for (int i = prim; i <= der;) {
	        if (a[i] < mediana) {
	            int temp = a[izq];
	            a[izq++] = a[i];
	            a[i++] = temp;
	        } else if (a[i] > mediana) {
	            int temp = a[i];
	            a[i] = a[der];
	            a[der--] = temp;
	        } else {
	            i++;
	        }
	    }
	    return new int[]{izq, der + 1};
	}
	
	public static void main(String[]args) {
		int Arreglo[] = {1,2,2,2,2,2,3,3};
		System.out.println(moda.moda1(Arreglo));
		System.out.println(moda.moda2(Arreglo));
		System.out.println(moda.moda3(Arreglo,0,Arreglo.length - 1));
	}	
}