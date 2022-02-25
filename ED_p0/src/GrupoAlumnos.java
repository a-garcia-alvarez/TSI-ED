public class GrupoAlumnos {
    private String nombre;
    private Alumno[] listaAlumnos;
    private int numAlumnos;
    private final int MAXIMO;


    public GrupoAlumnos (int tamaño, String nombre){
        this.nombre = nombre;
        this.MAXIMO = tamaño;
        this.numAlumnos = 0;
        this.listaAlumnos = new Alumno[this.MAXIMO];
    }
    public GrupoAlumnos() {
        this(10, "GrupoDesconocido");
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaximo() {
        return MAXIMO;
    }

    public boolean insertarAlumno(Alumno alumno){
        if (this.numAlumnos < this.MAXIMO){
            this.listaAlumnos[this.numAlumnos] = alumno;
            this.numAlumnos++;
        }else{
            System.out.printf("Grupo completo, te jodes\n");
        }
        return false;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public Alumno getAlumno(int i){
        return listaAlumnos[i];
    }

    public void mostrarGrupo(){
        System.out.printf("GRUPO %s: %s alumnos%n", this.nombre, this.numAlumnos);
        for(int i=0; i<numAlumnos; i++){
            listaAlumnos[i].mostrarAlumno();
        }
    }

    public double mediaCalificaciones(){
        if (numAlumnos == 0){
            System.out.println("Grupo vacío, no hay media posible.");
            return -1;
        }
        double sumatorio=0;
        for(int i=0; i<numAlumnos; i++){
            sumatorio += this.listaAlumnos[i].getCalificacion();
        }
        return sumatorio/numAlumnos;
    }

    public Alumno mejorAlumno(){
        if (numAlumnos == 0){
            System.out.println("Grupo vacío, no existe mejor alumno sin alumnos...");
            return null;
        }
        double nota = 0;
        int alumno_i = 0;

        for(int i=0; i<numAlumnos; i++){
            Alumno a = listaAlumnos[i];
            if (a.getCalificacion() > nota)
                alumno_i = i;
        }
        return listaAlumnos[alumno_i];
    }

    public boolean eliminarAlumno(String nombreAlumno){
        int i=-1;
        boolean found = false;
        for(i=0; i<numAlumnos && !found; i++){
            Alumno a = listaAlumnos[i];
            if (nombreAlumno.equals(a.getNombre())) {
                found = true;
            }
        }
        System.out.println(i);
        if (found){
            for (int j=i; j<numAlumnos-1; j++)
                listaAlumnos[j] = listaAlumnos[j+1];
            numAlumnos--;
            listaAlumnos[numAlumnos] = null;
            return true;
        }
        return false;
    }
}
