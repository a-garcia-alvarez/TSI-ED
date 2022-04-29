package arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL BINARIO DE EXPRESION **********");
        System.out.println("--------------------- Arbol de expresiones ----------------");
        Arbol arbol1 = new Arbol("52+83-*4/");
        System.out.printf("Expresion: ");    arbol1.mostrarExpresion();
        System.out.printf("Resultado: %.2f\n", arbol1.calcularValor());
        System.out.println();
        Arbol arbol2 = new Arbol("92+3+4*");
        System.out.printf("Expresion: ");    arbol2.mostrarExpresion();
        System.out.printf("Resultado: %.2f\n", arbol2.calcularValor());
        System.out.println();
        Arbol arbol3 = new Arbol("29*37-5*+8/");
        System.out.printf("Expresion: ");    arbol3.mostrarExpresion();
        System.out.printf("Resultado: %.2f\n", arbol3.calcularValor());
        System.out.println();
        Arbol arbol4 = new Arbol("9");
        System.out.printf("Expresion: ");    arbol4.mostrarExpresion();
        System.out.printf("Resultado: %.2f\n", arbol4.calcularValor());
        System.out.println();



    }
}

