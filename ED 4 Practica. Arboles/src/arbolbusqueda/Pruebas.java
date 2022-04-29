package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args)
	{
		System.out.println("-------------- Arbol binario de busqueda ------------");

		Alumno al1 = new Alumno("Felipe Garcia", 1253, 5.3);
		Alumno al2 = new Alumno("Adriana Torres", 2345,7.0);
		Alumno al3 = new Alumno("Alicia Blazquez Martín", 5622, 10.0);
		Alumno al4 = new Alumno("Diego Perez Gonzalez", 8135, 8.0);
		Alumno al5 = new Alumno("Mar Hernando Lopez", 8217, 6.3);
		Alumno al6 = new Alumno("Pedro Jimenez del Pozo", 8510, 3.0);
		Alumno al7 = new Alumno("Eduardo Parra Martín", 8765, 6.7);

		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.insertar(al3);	// Alicia
		arbol.insertar(al6);	// Pedro
		arbol.insertar(al2);	// Adriana
		arbol.insertar(al1);	// Felipe
		arbol.insertar(al7);	// Eduardo
		arbol.insertar(al4);	// Diego
		arbol.insertar(al5);	// Mar

		ListaOrdinalAlumnos lista = arbol.aLista();
		System.out.println("Lista de alumnos del arbol, en orden de matricula:");
		lista.mostrar();

		System.out.println("\n");

		System.out.printf("El alumno con la calificacion maxima cuya matricula esta comprendida entre 5000 y 8500 es: ");
		arbol.getCalificacionMaxima(5000, 8500).mostrar();
		System.out.printf("La calificación media de los alumnos cuya matricula esta comprendida entre 5000 y 8500 es: ");
		System.out.printf("%.1f\n", arbol.getCalificacionMedia(5000, 8500));

		System.out.printf("El alumno con la calificacion maxima cuya matricula esta comprendida entre 500 y 1000 es: ");
		System.out.println(arbol.getCalificacionMaxima(500, 1000));
		System.out.printf("La calificación media de los alumnos cuya matricula esta comprendida entre 500 y 1000 es: ");
		System.out.printf("%.1f\n", arbol.getCalificacionMedia(500, 1000));

		System.out.println();
		System.out.println("¿El arbol es equilibrado? " + arbol.esEquilibrado());

		System.out.println();
		arbol.borrar(1253);
		System.out.println("Se ha borrado al alumno con matricula 1253. Nueva lista de alumnos:");
		lista = arbol.aLista();
		lista.mostrar();

		System.out.println();
		System.out.println("¿El arbol es equilibrado? " + arbol.esEquilibrado());
	}
}
