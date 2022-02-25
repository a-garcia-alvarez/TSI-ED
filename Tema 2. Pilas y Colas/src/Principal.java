public class Principal {
    public static void main(String[] args) {
        EjerciciosPilas ejercicios = new EjerciciosPilas();
        Pila pila1= new Pila();
        pila1.apilar(5);
        pila1.apilar(20);
        pila1.apilar(3);
        pila1.apilar(6);
        pila1.mostrar();
        System.out.print ("¿está el elemento 4? ");
        System.out.println (ejercicios.estaContenido(pila1,4));
        System.out.print ("¿está el elemento 3? ");
        System.out.println (ejercicios.estaContenido(pila1,3));
        Pila nuevaPila = ejercicios.copiarPila(pila1);
        System.out.println("Pila copiada:");
        ejercicios.escribirPila(nuevaPila,1);
        System.out.println("Pila Origen:");
        pila1.mostrar();
    }
}
