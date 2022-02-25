public class Principal {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[4];
        alumnos[0] = new Alumno("asd", "aa1253", 3.50);
        alumnos[1] = new Alumno("Manuel García Sacedón", "ax0074", 8.35);
        alumnos[2] = new Alumno("Margarita López Medina", "mj7726", 7.70);
        alumnos[3] = new Alumno("Estela Sánchez Arellano", "bc2658", 6.75);

        for (Alumno a : alumnos){
            a.matricularAsignatura("Estructuras de Datos");
        }
        alumnos[3].matricularAsignatura("Algebra");
        alumnos[3].matricularAsignatura("Estructuras de Computadores");

        alumnos[3].mostrarAsignaturas();

        alumnos[0].mostrarAlumno();
        alumnos[3].mostrarAlumno();

        System.out.print("\n\n\n====\n\n\n");

        GrupoAlumnos  grupoAlumnos = new GrupoAlumnos(20, "GX11");
        for (Alumno a : alumnos){
            grupoAlumnos.insertarAlumno(a);
        }
        grupoAlumnos.mostrarGrupo();
        System.out.println("\nooo\n");
        grupoAlumnos.getAlumno(1).mostrarAlumno();
        System.out.println("\nmedia:");
        System.out.printf("Media del grupo: %s%n", grupoAlumnos.mediaCalificaciones() );
        System.out.println("\nmejor;");
        grupoAlumnos.mejorAlumno().mostrarAlumno();

        System.out.println("\nborrar\n");

        grupoAlumnos.mostrarGrupo();
        System.out.println("\n");

        System.out.printf("Alumno %s\n",grupoAlumnos.eliminarAlumno("Manuel García Sacedón")? "eliminado correctamente" : "no eliminaod");
        grupoAlumnos.mostrarGrupo();
        System.out.println("\n");

        System.out.printf("Alumno %s\n",grupoAlumnos.eliminarAlumno("Estela Sánchez Arellano")? "eliminado correctamente" : "no eliminaod");
        grupoAlumnos.mostrarGrupo();
        System.out.println("\n");

        System.out.printf("Alumno %s\n",grupoAlumnos.eliminarAlumno("Felipe Segovia González")? "eliminado correctamente" : "no eliminaod");
        grupoAlumnos.mostrarGrupo();
        System.out.println("\n");

        System.out.println("AAAAAAAA");
        grupoAlumnos.eliminarAlumno("asd");
        grupoAlumnos.eliminarAlumno("Manuel García Sacedón");
        grupoAlumnos.mostrarGrupo();
    }
}
