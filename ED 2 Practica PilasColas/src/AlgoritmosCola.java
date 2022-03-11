public class AlgoritmosCola {

    public static void mostrarGrupo (Cola grupo) {
        Alumno aux;
        System.out.printf("El grupo contiene %s alumnos\n", grupo.getNumElementos());
        for (int i = 1; i<= grupo.getNumElementos(); i++){
            aux = grupo.desencolar();
            System.out.printf("%s. %s\n", i, aux.getNombre());
            grupo.encolar(aux);
        }
    }

    public static Cola alumnosAprobados (Cola grupo) {
        Cola resultado = new Cola();
        Alumno aux;
        for (int i = 1; i<= grupo.getNumElementos(); i++){
            aux = grupo.desencolar();
            if (aux.getCalificacionMedia() >= 5)
                resultado.encolar(aux);
            grupo.encolar(aux);
        }
        return resultado;
    }

    public static double calificaciónMedia (Cola grupo) {
        double resultado = 0;
        Alumno aux;
        for (int i = 1; i<= grupo.getNumElementos(); i++){
            aux = grupo.desencolar();
            resultado += aux.getCalificacionMedia();
            grupo.encolar(aux);
        }
        resultado /= grupo.getNumElementos();
        return resultado;
    }
}
