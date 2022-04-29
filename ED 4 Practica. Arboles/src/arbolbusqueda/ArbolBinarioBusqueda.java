package arbolbusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;
	private int numElementos;

	public ArbolBinarioBusqueda() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return raiz == null;
	}


	/**
	 * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
	 * y si no la encuentra devuelve NULL.
	 */
	public Alumno getElemento(int clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Alumno getElementoRec(NodoArbol nodo, int clave) {
		if (nodo == null) {    // No encontrado
			return null;
		} else if (clave == nodo.getClave()) {    // Encontrado
			return nodo.getDato();
		} else if (clave < nodo.getClave()) {     // Subárbol izquierdo
			return this.getElementoRec(nodo.getIzquierdo(), clave);
		} else {        // Subárbol izquierdo
			return this.getElementoRec(nodo.getDerecho(), clave);
		}
	}

	/**
	 * Inserta el alumno en la posición que le corresponde según la clave
	 */
	public boolean insertar(Alumno dato) {
		int previousNumElementos = numElementos;
		raiz = this.insertarRec(raiz, dato);
		return (previousNumElementos < numElementos);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {
			nodo = new NodoArbol(dato);   // Crear nuevo nodo
			numElementos++;
		} else if (dato.getMatricula() < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {
			System.out.println("Error inserción. La clave " + dato.getMatricula() + " ya existe");
			nodo = null;
		}
		return nodo;
	}


	/**
	 * Determina si la clave recibida como parámetro existe en la lista.
	 */
	public boolean contiene(int clave) {
		return this.getElemento(clave) != null;
	}

	/**
	 * Elimina de la lista el alumno con número de matrícula clave,
	 * en caso de existir.
	 */
	public boolean borrar(int clave) {
		int previousNumElementos = numElementos;
		raiz = this.borrarRec(raiz, clave);
		return (numElementos < previousNumElementos);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Buscar en subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Buscar en subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
			nodo.setDerecho(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoArbol nuevoIzq = this.cambiarPorMenor(nodo, nodo.getIzquierdo());
				nodo.setIzquierdo(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoArbol cambiarPorMenor(NodoArbol nodoBorrar, NodoArbol nodoMenor) {
		if (nodoMenor.getDerecho() != null) {   // Seguir en subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		} else {  // Encontrado nodo menor inmediato
			nodoBorrar.setDato(nodoMenor.getDato()); // Cambiar datos de nodos
			return nodoMenor.getIzquierdo();  // Devolver subarbol izquierdo de menor inmediato
		}
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void preOrdenNivel() {
		System.out.println("Preorden con niveles: ");
		preOrdenNivelRec(raiz, 1);
	}

	private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
		if (nodo != null) {
			System.out.println("Clave " + nodo.getClave() + ". En el nivel " + nivel);
			preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
			preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.2
	public ListaOrdinalAlumnos aLista() {
		ListaOrdinalAlumnos lista = new ListaOrdinalAlumnos();
		aListaRec(raiz, lista);
		return lista;
	}
	private void aListaRec(NodoArbol nodo, ListaOrdinalAlumnos lista) {
		if (nodo == null)
			return;
		aListaRec(nodo.getIzquierdo(), lista);
		lista.insertar(nodo.getDato());
		aListaRec(nodo.getDerecho(), lista);
	}

	// ------------------------------------------------------------------------
	// TODO 3.3
	public Alumno getCalificacionMaxima(int minimaMat, int maximaMat) {
		return getCalificacionMaximaRec(raiz, minimaMat, maximaMat);
	}
	private Alumno getCalificacionMaximaRec(NodoArbol nodo, int minimaMat, int maximaMat){
		if (nodo == null)
			return null;
		Alumno al = nodo.getDato();
		if (al.getMatricula()<minimaMat || al.getMatricula()>maximaMat) // fuera de los limites
			return null;

		// la unica forma de no recorrer el arbol completo es si encontramos un 10
		// ya que no está ordenado por notas, sino matricula
		// usemos el tipo de busqueda que sea, el alumno podría estar en "la otra punta"
		// si esta conclusion es incorrecta, por favor haganmelo saber en los comentarios
		if (al.getCalificacion() == 10.0)
			return al;

		Alumno izq_max, der_max;
		double izq_cal=0.0, der_cal=0.0, cen_cal = nodo.getDato().getCalificacion();

		izq_max = getCalificacionMaximaRec(nodo.getIzquierdo(), minimaMat, maximaMat);
		if (izq_max != null)	izq_cal = izq_max.getCalificacion();

		der_max = getCalificacionMaximaRec(nodo.getDerecho(), minimaMat, maximaMat);
		if (der_max != null)	der_cal = izq_max.getCalificacion();

		// en caso de igualdad de calificaciones, centro > izq > der
		if (izq_cal > cen_cal && izq_cal >= der_cal)
			return izq_max;
		else if (der_cal > cen_cal && der_cal >= izq_cal)
			return der_max;
		else
			return al;
	}

	// ------------------------------------------------------------------------
	// TODO 3.4
	public double getCalificacionMedia(int minimaMat, int maximaMat) {
		// We're gonna do what's called a pro-gamer move
		int[] numAl = {0};
		double SumCal;
		SumCal = getCalificacionMediaAux(raiz, numAl, minimaMat, maximaMat);
		//System.out.println(numAl[0]);
		if (numAl[0] > 0)
			return SumCal/numAl[0];
		return 0.0;
	}
	private double getCalificacionMediaAux(NodoArbol nodo, int[] numAl, int minimaMat, int maximaMat){
		if (nodo == null)
			return 0.0;
		Alumno al = nodo.getDato();
		if (al.getMatricula() < minimaMat)
			return getCalificacionMediaAux(nodo.getDerecho(), numAl, minimaMat, maximaMat);
		if (al.getMatricula() > maximaMat)
			return getCalificacionMediaAux(nodo.getIzquierdo(), numAl, minimaMat, maximaMat);

		numAl[0]++;
		return al.getCalificacion()
				+ getCalificacionMediaAux(nodo.getIzquierdo(), numAl, minimaMat, maximaMat)
				+ getCalificacionMediaAux(nodo.getDerecho(), numAl, minimaMat, maximaMat);
	}

	// ------------------------------------------------------------------------
	// TODO 3.5
	public boolean esEquilibrado() {
		return esEquilibradoRec(raiz);
	}
	private boolean esEquilibradoRec(NodoArbol nodo){
		if (nodo == null)
			return true;
		int altura_izq, altura_der, diff;
		altura_izq = getAltura(nodo.getIzquierdo());
		altura_der = getAltura(nodo.getDerecho());

		// valor absoluto de la diferencia de alturas de las subramas
		diff = Math.abs(altura_izq - altura_der);

		// devolvemos si el arbols está equilibrado o no, no ifs needed
		return diff <= 1
				&& esEquilibradoRec(nodo.getIzquierdo())
				&& esEquilibradoRec(nodo.getDerecho());
	}
	private int getAltura(NodoArbol nodo){
		if (nodo == null)
			return 0;
		return 1 + Math.max(getAltura(nodo.getIzquierdo()), getAltura(nodo.getDerecho()));
	}

}
