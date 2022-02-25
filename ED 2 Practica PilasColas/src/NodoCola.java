public class NodoCola {
    private Asignatura dato;
    private NodoCola siguiente;

    public NodoCola(Asignatura dato, NodoCola sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public Asignatura getDato() {
        return dato;
    }

    public void setDato(Asignatura dato) {
        this.dato = dato;
    }
}
