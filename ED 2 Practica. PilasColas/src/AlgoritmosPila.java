public class AlgoritmosPila {

    public static Asignatura asignaturaNotaMáxima(Pila asignaturas) {
        Asignatura resultado = null;
        Asignatura aux;
        Asignatura aux2;
        if ( !asignaturas.vacia() ){
            aux = asignaturas.desapilar();
            resultado = aux;
            if ( !asignaturas.vacia()) {
                aux2 = asignaturaNotaMáxima(asignaturas);
                if (aux2.getCalificacion() > aux.getCalificacion())
                    resultado = aux2;
            }
            asignaturas.apilar(aux);
        }
        return resultado;
    }

    public static double notaMínima(Pila asignaturas) {
        double resultado = 0;
        Asignatura aux;
        if ( !asignaturas.vacia() ){
            aux = asignaturas.desapilar();
            resultado = aux.getCalificacion();
            if ( !asignaturas.vacia())
                resultado = Math.min(resultado, notaMínima(asignaturas));
            asignaturas.apilar(aux);
        }
        return resultado;
    }

    public static void mostrarAprobadas(Pila asignaturas) {
        Asignatura aux;
        if (!asignaturas.vacia()) {
            aux = asignaturas.desapilar();
            if ( aux.getCalificacion() >= 5)
                aux.mostrar();
            mostrarAprobadas(asignaturas);
            asignaturas.apilar(aux);
        }
    }

}
