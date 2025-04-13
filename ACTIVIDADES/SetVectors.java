package ACTIVIDADES;

import java.util.*;

public class SetVectors {
    private List<Limits> elementos = new ArrayList<>();

    public void insertar(Limits p) {
        elementos.add(p);
    }

    public Limits mayor() {
        if (elementos.isEmpty()) return null;
        Limits mayor = elementos.get(0);
        for (Limits p : elementos) {
            if (p.longitud() > mayor.longitud()) {
                mayor = p;
            }
        }
        elementos.remove(mayor);
        return mayor;
    }

    public int longMayor() {
        int max = 0;
        for (Limits p : elementos) {
            max = Math.max(max, p.longitud());
        }
        return max;
    }

    public boolean esVacio() {
        return elementos.isEmpty();
    }

    public void destruir() {
        elementos.clear();
    }
}

