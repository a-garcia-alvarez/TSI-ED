import java.util.LinkedList;
import java.util.Iterator;

public class AlumnoBib {

	private String nombre;
	private int matricula;
	private LinkedList<Evaluacion> expediente;

	public AlumnoBib(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new LinkedList<Evaluacion>();
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
		expediente.add(evaluacion);
	}

	public boolean estaAprobado(String nombreAsig) {
		boolean aprobado = false;
		Iterator<Evaluacion> it = expediente.iterator();
		while (it.hasNext() && !aprobado) {
			Evaluacion evaluacion = it.next();
			if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
					evaluacion.getNota() >= 5.0) {
				aprobado = true;
			}
		}
		return aprobado;
	}

	public LinkedList<Evaluacion> asignaturasAprobadas() {
		Iterator<Evaluacion> it = expediente.iterator();
		LinkedList<Evaluacion> aprobadas = new LinkedList<Evaluacion>();
		while (it.hasNext()){
			Evaluacion aux = it.next();
			if (aux.getNota() >=5)
				aprobadas.add(aux);
		}
		return aprobadas;
	}

	public double mediaAprobadas() {
		LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();
		if (aprobadas.isEmpty())
			return 0.0;
		Iterator<Evaluacion> it = aprobadas.iterator();
		double sumatorio = 0;
		while (it.hasNext())
			sumatorio += it.next().getNota();
		return sumatorio / aprobadas.size();
	}

	public int getNumAprobadas() {
		LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();
		return aprobadas.size();
	}

	public void mostrar() {
		System.out.printf("%s. matricula: %s\n", nombre, matricula);
		if (expediente.isEmpty())
			System.out.println("No ha realizado ninguna evaluación.");
		else
		{
			Iterator<Evaluacion> it = expediente.iterator();
			while (it.hasNext())
				it.next().mostrar();
			System.out.printf(
					"%d evaluaciones y %d asignaturas aprobadas%s\n",expediente.size(), getNumAprobadas(),
						getNumAprobadas()>0 ? String.format(" con calificación media %.1f", mediaAprobadas()) : ""
					);
		}

	}

}


