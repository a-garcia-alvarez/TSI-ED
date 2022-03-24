public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");


        System.out.println();
        // 2.2 Definición de un TAD lista ordinal de objetos Evaluacion
        ListaOrdinal listaOrdinal = new ListaOrdinal();

        Evaluacion ev1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion ev2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion ev3 = new Evaluacion("ED", "Julio 20", 7.4);
        Evaluacion ev4 = new Evaluacion("Algebra", "Junio 18", 6.4);

        listaOrdinal.insertar(ev1);
        listaOrdinal.insertar(ev2);
        listaOrdinal.insertar(ev3);
        listaOrdinal.insertar(ev4);

        System.out.println("------------ EVALUACIONES EN LA LISTA -----------");
        IteradorListaOrdinal iterOrdinal = listaOrdinal.getIterador();
        while (iterOrdinal.hasNext())
            iterOrdinal.next().mostrar();


        System.out.println();
        // 2.3. Especialización del TAD Lista ordinal de evaluaciones.
        System.out.println("------------------------------- ");
        String asignaturas[] = {"ED", "Algebra", "Fundamentos de Programación"};
        for (String asig: asignaturas)
            System.out.printf("Convocatorias en %s: %s\n", asig, listaOrdinal.numConvocatorias(asig));


        System.out.println();
        // 3.5. Pruebas de los métodos añadidos.
        Alumno a1 = new Alumno("Felipe García Gómez", 1253);
        Alumno a2 = new Alumno("Alicia Blázquez Martín", 5622);
        a1.nuevaEvaluacion(ev1);
        a1.nuevaEvaluacion(ev2);
        a1.nuevaEvaluacion(ev3);
        a1.nuevaEvaluacion(ev4);

        System.out.println("----------- Asignaturas aprobadas por " + a1.getNombre() + " ----------");
        IteradorListaOrdinal a1_apro_iter = a1.asignaturasAprobadas().getIterador();
        while (a1_apro_iter.hasNext())
            a1_apro_iter.next().mostrar();
        System.out.println();

        System.out.println("----------- Asignaturas aprobadas por " + a2.getNombre() + " ----------");
        IteradorListaOrdinal a2_apro_iter = a2.asignaturasAprobadas().getIterador();
        while (a2_apro_iter.hasNext())
            a2_apro_iter.next().mostrar();
        System.out.println();

        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");
        a1.mostrar();
        System.out.println("---------------------------------");
        a2.mostrar();
        System.out.println("---------------------------------");


        System.out.println();
        // 3.6. Uso de la biblioteca estándar de Java
        AlumnoBib ab1 = new AlumnoBib("Eduardo Parra Martín", 8765);
        AlumnoBib ab2 = new AlumnoBib("Sonia Torres Pardo", 2345);
        ab1.nuevaEvaluacion(ev1);
        ab1.nuevaEvaluacion(ev2);
        ab1.nuevaEvaluacion(ev3);
        ab1.nuevaEvaluacion(ev4);
        System.out.println("----------- MOSTRAR LOS ALUMNOS BIBLIOTECA ------------");
        ab1.mostrar();
        System.out.println("---------------------------------");
        ab2.mostrar();
        System.out.println("---------------------------------");


        System.out.println();
        // 4.1. Definición de un TAD lista calificada de objetos Alumno y clave el número de matrícula.
        Alumno a3 = new Alumno("Pedro Jiménez del Pozo", 8510);
        Evaluacion ev5 = new Evaluacion("Fundamentos de Programación", "Enero 19", 8.8);
        a3.nuevaEvaluacion(ev5);
        ListaCalificada listaCalificada = new ListaCalificada();
        listaCalificada.insertar(a3);
        listaCalificada.insertar(a1);
        listaCalificada.insertar(a2);

        System.out.println("------------ ALUMNOS EN LA LISTA -------------");
        IteradorListaCalificada iterCalificada = listaCalificada.getIterador();
        while (iterCalificada.hasNext()){
            iterCalificada.next().mostrar();
            System.out.println("---------------------------------");
        }


        System.out.println();
        // 4.2.3. Pruebas de los métodos añadidos
        System.out.println("---------- Borramos las claves menores a 6000------------");
        listaCalificada.borrarMenores(6000);
        iterCalificada = listaCalificada.getIterador();
        while (iterCalificada.hasNext()){
            iterCalificada.next().mostrar();
            if (iterCalificada.hasNext()) System.out.println("---------------------------------");
            else System.out.println();
        }

        System.out.println("---------- Borramos las claves menores a 9000------------");
        listaCalificada.borrarMenores(9000);
        iterCalificada = listaCalificada.getIterador();
        while (iterCalificada.hasNext()){
            iterCalificada.next().mostrar();
            if (iterCalificada.hasNext()) System.out.println("---------------------------------");
            else System.out.println();
        }
        System.out.println();

        System.out.println("----- Metemos todos los alumnos y borramos las claves mayores a 7000 ------");
        listaCalificada.insertar(a1);
        listaCalificada.insertar(a2);
        listaCalificada.insertar(a3);
        listaCalificada.borrarMayores(7000);
        iterCalificada = listaCalificada.getIterador();
        while (iterCalificada.hasNext()){
            iterCalificada.next().mostrar();
            if (iterCalificada.hasNext()) System.out.println("---------------------------------");
            else System.out.println();
        }

        System.out.println("---------- Borramos las claves mayores a 1000------------");
        listaCalificada.borrarMayores(1000) ;
        iterCalificada = listaCalificada.getIterador();
        while (iterCalificada.hasNext()){
            iterCalificada.next().mostrar();
            if (iterCalificada.hasNext()) System.out.println("---------------------------------");
            else System.out.println();
        }


        System.out.println();
        // 5.5. Pruebas de los métodos insertados.
        GrupoAlumnos grupoAlumnos = new GrupoAlumnos("GX11");
        grupoAlumnos.nuevoAlumno(a1);
        grupoAlumnos.nuevoAlumno(a2);
        grupoAlumnos.nuevoAlumno(a3);
        System.out.println("------------ CREADO EL GRUPO GX11------------");
        System.out.printf("El grupo %s tiene %d alumnos\n", grupoAlumnos.getNombre(), grupoAlumnos.getNumAlumnos());

        System.out.println("------------ Grupo GX11. Alumno con matrícula 8510 ------------");
        grupoAlumnos.getAlumno(8510).mostrar();

        System.out.println("---------------------------------");
        System.out.printf("porcentaje de aprobados en %s el grupo %s: %s", "ED", grupoAlumnos.getNombre(), grupoAlumnos.porcentajeAprobados("ED"));

        /*
        System.out.println("\n\n-- Extra --\n");
        grupoAlumnos.mostrar();
        System.out.println();
        */

    }
}
