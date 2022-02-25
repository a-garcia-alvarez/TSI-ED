
    public class PrincipalC {

    public static void main(String[] args) {
        Cola cola1 = new Cola();                       // Se crea el objeto cola1
        EjerciciosColas ejercicios = new EjerciciosColas();
        cola1.encolar(19);
        for (int i = 0; i < 5; i++)
            cola1.encolar(i);
        cola1.encolar(19);
        cola1.encolar(24);
        cola1.encolar(48);
        ejercicios.escribirCola(cola1);
        cola1.mostrar();
        System.out.println();
        cola1.mostrar();
        System.out.println("¿Está el 3?: " + ejercicios.estaContenido(cola1, 3));
        System.out.println("¿Está el 14?: " + ejercicios.estaContenido(cola1, 14));
        ejercicios.escribirCola(cola1);
        System.out.println("Copiamos la cola en otra");
        Cola cola2 = ejercicios.copiarCola(cola1);
        System.out.println("Cola original:");
        ejercicios.escribirCola(cola1);
        System.out.println("Cola copia:");
        ejercicios.escribirCola(cola2);
    }
}
