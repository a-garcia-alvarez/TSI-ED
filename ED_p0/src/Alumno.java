public class Alumno {
    private String nombre;
    private String matricula;
    private double calificacion;
    private String[] asignaturas;
    private int numAsignaturas;

    private static int maxNumAsignaturas = 5;

    public Alumno(){
        this("","",0);
    }
    public Alumno(String nombre, String matricula, double calificacion){
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificacion = calificacion;
        this.numAsignaturas = 0;
        this.asignaturas = new String[this.maxNumAsignaturas];
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    void matricularAsignatura(String asignatura) {
        if (this.numAsignaturas <= this.maxNumAsignaturas) {
            this.asignaturas[this.numAsignaturas] = asignatura;
            this.numAsignaturas++;
        }else{
            System.err.println("Andelavergaconchetumadre no puedes ahcer eso!\n");
        }
    }

    void mostrarAsignaturas(){
        if (this.numAsignaturas != 0){
            System.out.printf("%s asignaturas\n", this.numAsignaturas);
            for (int i=0; i < this.numAsignaturas; i++){
                System.out.printf("\t- %s.\n", this.asignaturas[i]);
            }
        }else{
            System.out.printf("No está matriculado en ninguna asignatura\n");
        }
    }
    void mostrarAlumno(){
        System.out.printf("%s. Matr: %s (%s)%n",
                this.nombre, this.matricula, this.calificacion );
        this.mostrarAsignaturas();
    }
}
