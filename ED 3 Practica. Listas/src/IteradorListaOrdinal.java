public class IteradorListaOrdinal {

	private NodoListaOrdinal actual;

	public IteradorListaOrdinal(NodoListaOrdinal comienzo) {
		actual = comienzo;
	}

	public boolean hasNext() {
		return actual != null;
	}

	public Evaluacion next() {
		Evaluacion resultado = actual.getDato();
		actual = actual.getSiguiente();
		return resultado;
	}
}
