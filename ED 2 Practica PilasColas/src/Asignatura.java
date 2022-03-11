public class Asignatura {
    private String nombre;
    private double calificacion;

    public Asignatura(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
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

    public void mostrar() {
        System.out.printf("\t%s (%.1f)%n", nombre, calificacion);
    }
}