package arbolbinario;

import java.util.ArrayDeque;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(char dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(char dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Recorrido en amplitud con una cola proporcionada por la clase ArrayDeque
     */
    public void amplitud2() {
        ArrayDeque<NodoArbol> cola = new ArrayDeque<NodoArbol>();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                NodoArbol nodo = cola.remove();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.add(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.add(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Ejemplo: método que recorre el árbol para determinar si contiene un dato.
     */
    public boolean contiene(char dato) {
        return this.contieneRec(raiz, dato);
    }

    private boolean contieneRec(NodoArbol nodo, char dato) {
        // Búsqueda por preorden
        boolean resul;
        if (nodo == null) {
            resul = false;
        } else if (nodo.getDato() == dato) {
            resul = true;
        } else {
            resul = this.contieneRec(nodo.getIzquierdo(), dato);
            if (!resul) {
                resul = this.contieneRec(nodo.getDerecho(), dato);
            }
        }
        return resul;
    }


    public int suma() {
        return this.sumaRec(raiz);
    }

    private int sumaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getDato() + this.sumaRec(nodo.getIzquierdo()) + this.sumaRec(nodo.getDerecho());
        }
    }


    public void preOrdenNivel() {
        System.out.println("Preorden con niveles: ");
        preOrdenNivelRec(raiz, 1);
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " en el nivel " + nivel);
            preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
            preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
        }
    }

    // ------------------------------------------------------------------------
    // 2.3
    private int pasarAEntero(char c) {
        return Character.getNumericValue(c);
    }

    private boolean esOperador(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private boolean esDigito(char c) {
        return (c >= '0' && c <= '9');
    }

    // ------------------------------------------------------------------------
    // 2.3
    public Arbol(String cadena) {
        Pila pila = new Pila();
        for ( char c:cadena.toCharArray() ) {
            if (esDigito(c)){
                NodoArbol node = new NodoArbol(c);
                pila.apilar(node);
            }
            else if (esOperador(c)){
                NodoArbol   der = pila.desapilar(),
                            izq = pila.desapilar();
                NodoArbol node = new NodoArbol(c, izq, der);
                pila.apilar(node);
            }
            else {
                System.err.println("Some BS just happened ¯\\_(ツ)_/¯\n");
                System.exit(1);
            }
        }
        raiz = pila.desapilar();
    }

    // ------------------------------------------------------------------------
    // 2.4
    public void mostrarExpresion() {
        System.out.println(mostrarExpresionRec(raiz));
    }
    // muy posiblemente contega errores, y es mejorable, pero bueno...
    // lo que tiene hacer los trabajos la noche anterior, lol
    // Podría usar una implementacion mas sencilla y menos cool? por supuesto
    // Sería divertido? Hell Nah!
    private String mostrarExpresionRec(NodoArbol arbol){
        if (arbol == null)
            return null;
        char c = arbol.getDato();
        String res, izq, der;

        izq = mostrarExpresionRec(arbol.getIzquierdo());
        der = mostrarExpresionRec(arbol.getDerecho());
        switch (c){
            case '*':
            case '/':
                if (izq.contains("+") || izq.contains("-"))
                izq = String.format("(%s)", izq);
                if (der.contains("+") || der.contains("-"))
                    der = String.format("(%s)", der);

            case '+':
            case '-':
                res = String.format("%s %c %s", izq, c, der );
                return res;
            default:
                return Character.toString(c);
        }
    }

    // ------------------------------------------------------------------------
    // 2.5
    public double calcularValor() {
        if (raiz != null){
            return calcularValorRec(raiz);
        }
        return 0.0;
    }
    private double calcularValorRec(NodoArbol nodo){
        char c = nodo.getDato();
        switch (c){
            case '+':
                return calcularValorRec(nodo.getIzquierdo()) + calcularValorRec(nodo.getDerecho());
            case '-':
                return calcularValorRec(nodo.getIzquierdo()) - calcularValorRec(nodo.getDerecho());
            case '*':
                return calcularValorRec(nodo.getIzquierdo()) * calcularValorRec(nodo.getDerecho());
            case '/':
                return calcularValorRec(nodo.getIzquierdo()) / calcularValorRec(nodo.getDerecho());
            default:
                return Character.getNumericValue(c);
        }
    }


}
