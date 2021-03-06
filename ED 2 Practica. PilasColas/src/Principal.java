public class Principal {
    public static void main(String[] args) {
        System.out.println("Practica ED Pilas y Colas de: " + "------Nombre y Apellidos del alumno---------");
        System.out.println("Numero Matricula: " + "XXXXXXXXX");
        Principal pruebas = new Principal();

        Pila asignaturas = pruebas.prepararPila();
        pruebas.pruebasPila(asignaturas);

        System.out.println("\n===\n");

        Cola grupo = pruebas.prepararCola();
        pruebas.pruebasCola(grupo);
    }

    public Pila prepararPila() {
        Pila asignaturas = new Pila();
        Asignatura ffi = new Asignatura("Fundamentos Físicos de la Informática", 3.50);
        Asignatura ed = new Asignatura("Estructuras de Datos", 6.35);
        Asignatura aes = new Asignatura("Aspectos Éticos y Sociales", 7.70);
        Asignatura fs = new Asignatura("Fundamentos de seguridad", 6.75);
        asignaturas.apilar(ffi);
        asignaturas.apilar(ed);
        asignaturas.apilar(aes);
        asignaturas.apilar(fs);
        return asignaturas;
    }

    public void pruebasPila(Pila asignaturas) {
        asignaturas.mostrar();
        System.out.printf("Calificación mínima: %.1f\n", AlgoritmosPila.notaMínima(asignaturas));
        System.out.println("Asignatura con calificación máxima:");
        AlgoritmosPila.asignaturaNotaMáxima(asignaturas).mostrar();
        System.out.println("Asignaturas aprobadas:");
        AlgoritmosPila.mostrarAprobadas(asignaturas);
    }

    public Cola prepararCola() {
        Cola grupo = new Cola();
        Alumno a1 = new Alumno("Felipe Arias Gonzalez", "aa1253");
        Alumno a2 = new Alumno("Manuel Garcia Sacedón", "ax0074");
        Alumno a3 = new Alumno("Margarita Lopez Medina", "mj7726");
        Alumno a4 = new Alumno("Estela Sanchez Arellano", "bc2658");
        Asignatura ffi = new Asignatura("Fundamentos Físicos de la Informática", 3.50);
        Asignatura ed = new Asignatura("Estructuras de Datos", 6.35);
        Asignatura aes = new Asignatura("Aspectos Éticos y Sociales", 7.70);
        Asignatura fs = new Asignatura("Fundamentos de seguridad", 6.75);
        a1.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 4.35);
        a2.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 7.5);
        a3.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 2.5);
        Asignatura algebra = new Asignatura("Álgebra", 5);
        a4.anadirAsignatura(algebra);
        a4.anadirAsignatura(fs);
        grupo.encolar(a1);
        grupo.encolar(a2);
        grupo.encolar(a3);
        grupo.encolar(a4);
        return grupo;
    }

    public void pruebasCola(Cola grupo) {
        //System.out.println("Contenido del grupo:");
        //grupo.mostrar();
        AlgoritmosCola.mostrarGrupo(grupo);
        System.out.printf("Calificación media del grupo: %.5f\n", AlgoritmosCola.calificaciónMedia(grupo));
        System.out.println("\nAlumnos aprobados:");
        Cola grupo_aprobados = AlgoritmosCola.alumnosAprobados(grupo);
        grupo_aprobados.mostrar();
        System.out.printf("Calificación media de los aprobados: %s\n", AlgoritmosCola.calificaciónMedia(grupo_aprobados));
	}
}
