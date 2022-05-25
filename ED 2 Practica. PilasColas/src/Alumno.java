public class Alumno {
    private String  nombre, matricula;
    private double  calificacionMedia;
    private int     numAsignaturas;
    private Pila    asignaturas;

    public Alumno (String nombre, String matricula){
        this.nombre = nombre;
        this.matricula = matricula;
        calificacionMedia = 0;
        asignaturas = new Pila();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacionMedia() {
        return calificacionMedia;
    }

    public void anadirAsignatura(Asignatura asignatura){
        asignaturas.apilar(asignatura);

        Pila p_aux = new Pila();
        double media = 0;
        while (!asignaturas.vacia()){
            asignatura = asignaturas.desapilar();
            media += asignatura.getCalificacion();
            p_aux.apilar(asignatura);
        }
        while (!p_aux.vacia())
            asignaturas.apilar(p_aux.desapilar());
        this.calificacionMedia = media / asignaturas.getNumElementos();
    }

    public int getNumAsignaturas(){
        return asignaturas.getNumElementos();

    }

    public void mostrar(){
        System.out.printf("%s: %s (%.1f)\n", nombre, matricula, calificacionMedia);
        if ( asignaturas.vacia() )
            System.out.println("No está matriculado en ninguna asignatura");
        else
            asignaturas.mostrar();
    }
}
