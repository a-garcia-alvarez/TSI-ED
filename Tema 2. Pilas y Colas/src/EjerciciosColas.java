public class EjerciciosColas {
    public void escribirCola(Cola cola) {
        int elemento;
        System.out.print("(Principio) ");
        for (int i = 1; i <= cola.getNumElementos(); i++) {
            elemento = cola.desencolar();
            System.out.print(elemento + " ");
            cola.encolar(elemento);
        }
        System.out.println("(Final)");
    }

    public boolean estaContenido(Cola cola, int valor) {
        boolean resultado = false;
        int elemento;
        for (int i = 1; i <= cola.getNumElementos(); i++) {
            elemento = cola.desencolar();
            if (elemento == valor)
                resultado = true;
            cola.encolar(elemento);
        }
        return resultado;
    }


    public Cola copiarCola(Cola colaOrigen) {
        Cola colaCopia = new Cola();
        int elemento, numero = colaOrigen.getNumElementos();
        for (int i = 0; i < numero; i++) {
            elemento = colaOrigen.desencolar();
            colaCopia.encolar(elemento);
            colaOrigen.encolar(elemento);
        }
        return colaCopia;
    }


}
