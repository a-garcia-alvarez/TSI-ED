import java.util.Stack;

public class Principal3 {
    public static void main(String[] args) {
        Stack<Integer> pilaS = new Stack<Integer>();   //Se crea el objeto pilaS con valores enteros
        for (int i = 0; i < 5; i++)
            pilaS.push(i);
        pilaS.push(19);
        pilaS.push(24);
        pilaS.push(48);
        System.out.println("Contenido: " + pilaS.toString());
        System.out.println("El elemento sacado es " + pilaS.pop());
        int elemento = pilaS.pop(); //sacamos otro elemento
        System.out.println("La cima de la pila es " + pilaS.peek());
        System.out.println("Número de elementos:" + pilaS.size());
        System.out.println("Contenido: " + pilaS.toString());
    }
}