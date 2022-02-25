public class EjerciciosPilas {

    public boolean estaContenido (Pila pila, int dato) {
        boolean resultado = false;
        if (!pila.vacia()) {
            int actual = pila.desapilar();
            if (actual == dato)
                resultado = true;
            else resultado = estaContenido(pila,dato);
            pila.apilar(actual);
        }
        return resultado;
    }
    public Pila copiarPila (Pila pilaOrigen) {
        Pila pilaCopia;
        if (!pilaOrigen.vacia()) {
            int elemento = pilaOrigen.desapilar();
            pilaCopia = copiarPila(pilaOrigen);
            pilaOrigen.apilar(elemento);
            pilaCopia.apilar(elemento);
        }
        else pilaCopia  = new Pila();
        return pilaCopia;
    }
    void escribirPila (Pila pila, int posicion) {
        if (!pila.vacia()) {
            int elemento = pila.desapilar ();
            System.out.println ("Elemento " + posicion + ": " + elemento);
            escribirPila (pila, posicion+1);
            pila.apilar (elemento);
        } else System.out.println ("FIN");
    }

}