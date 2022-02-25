public class Principal2 {
    public int sumarPila (Pila pila) {
        int resultado = 0;
        if (!pila.vacia()) {
            int elemento = pila.desapilar();
            resultado = elemento + sumarPila (pila);
            pila.apilar (elemento);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Principal2 ejercicio = new Principal2 ();
        Pila pila = new Pila();
        pila.apilar (5);
        pila.apilar(3);
        pila.apilar(7);
        pila.mostrar ();
        System.out.println ("Los elementos suman: "+ ejercicio.sumarPila (pila));
        pila.mostrar ();
    }
}