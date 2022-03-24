public class GrupoAlumnos {

	private String nombre;
	private ListaCalificada listaAlumnos;

	public GrupoAlumnos(String nombre) {
		this.nombre = nombre;
		listaAlumnos = new ListaCalificada();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void nuevoAlumno(Alumno alumno) {
		listaAlumnos.insertar(alumno);
	}

	public int getNumAlumnos() {
		return listaAlumnos.getNumElementos();
	}

	public Alumno getAlumno(int matricula) {
		return listaAlumnos.getElemento(matricula);
	}

	public double porcentajeAprobados(String nombreAsignatura) {
		if (listaAlumnos.vacia())
			return 0.0;
		int aprobados = 0;
		IteradorListaCalificada it = listaAlumnos.getIterador();
		while (it.hasNext())
			if (it.next().estaAprobado(nombreAsignatura))
				aprobados++;
		return aprobados*100.0/getNumAlumnos();
	}

	public void mostrar() {
		System.out.printf("Grupo %s.\n", nombre);
		System.out.printf("El grupo tiene %d alumno%s\n", getNumAlumnos(), getNumAlumnos() != 1 ? "s" : "");
		System.out.println("---------------------------------");
		if (!listaAlumnos.vacia()) {
			IteradorListaCalificada it = listaAlumnos.getIterador();
			while (it.hasNext()) {
				it.next().mostrar();
				System.out.println("---------------------------------");
			}

		}
	}
}