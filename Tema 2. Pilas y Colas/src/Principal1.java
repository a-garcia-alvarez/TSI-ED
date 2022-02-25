public class Principal1 {
    public static void main(String[] args) {
        Pila pila1 = new Pila();        //Se crea el objeto pila1
                                            //Si se desea usar PilaArray se sustituye por Pila pila1 = new PilaArray ();
        for (int i = 0; i < 5; i++)
            pila1.apilar(i);               //Se mandan mensajes al objeto pila1 con "."
        pila1.apilar(19);
        pila1.apilar(24);
        pila1.apilar(48);

        System.out.println("El elemento sacado es " + pila1.desapilar());

        pila1.quitarCima();            // se elimina un elemento de la pila (la cima)

        System.out.println("La cima de la pila es " + pila1.getCima());
        System.out.println("Número de elementos: " + pila1.getNumElementos());
        pila1.mostrar();
    }
}
