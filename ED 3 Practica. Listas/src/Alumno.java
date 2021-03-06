public class Alumno {

	private String nombre;
	private int matricula;
	private ListaOrdinal expediente;

	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new ListaOrdinal();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void nuevaEvaluacion(Evaluacion evaluacion) {
		expediente.insertar(evaluacion);
	}

	public boolean estaAprobado(String nombreAsig) {
		boolean aprobado = false;
		IteradorListaOrdinal it = expediente.getIterador();
		while (it.hasNext() && !aprobado) {
			Evaluacion evaluacion = it.next();
			if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
					evaluacion.getNota() >= 5.0) {
				aprobado = true;
			}
		}
		return aprobado;
	}

	public ListaOrdinal asignaturasAprobadas() {
		IteradorListaOrdinal iter = expediente.getIterador();
		ListaOrdinal aprobadas = new ListaOrdinal();
		while (iter.hasNext()){
			Evaluacion aux = iter.next();
			if (aux.getNota() >=5)
				aprobadas.insertar(aux);
		}
		return aprobadas;
	}

	public double mediaAprobadas() {
		ListaOrdinal aprobadas = asignaturasAprobadas();
		if (aprobadas.vacia())
			return 0.0;
		IteradorListaOrdinal iter = aprobadas.getIterador();
		double sumatorio = 0;
		while (iter.hasNext())
			sumatorio += iter.next().getNota();
		return sumatorio / aprobadas.getNumElementos();
	}

	public int getNumAprobadas() {
		ListaOrdinal aprobadas = asignaturasAprobadas();
		return aprobadas.getNumElementos();
	}

	public void mostrar() {
		System.out.printf("%s. matricula: %s\n", nombre, matricula);
		if (expediente.vacia())
			System.out.println("No ha realizado ninguna evaluación.");
		else
		{
			IteradorListaOrdinal iterExpediente = expediente.getIterador();
			while (iterExpediente.hasNext())
				iterExpediente.next().mostrar();
			System.out.printf(
					"%d evaluaciones y %d asignaturas aprobadas%s\n",expediente.getNumElementos(), getNumAprobadas(),
						getNumAprobadas()>0 ? String.format(" con calificación media %.1f", mediaAprobadas()) : ""
					);
		}

	}

}


