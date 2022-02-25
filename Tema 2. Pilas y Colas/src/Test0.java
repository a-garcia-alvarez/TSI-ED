public class Test0 {
    public static void main(String[] args) {
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        int a1[] = {1,9,3,7,2,4,5,1};
        int a2[] = {20,2,4,5,1,};
        for (int i:a1)
            cola1.encolar(i);
        for (int i:a2)
            cola2.encolar(i);

        Cola res = mezclarColas(cola1, cola2);
        while (!res.vacia())
            System.out.println(res.desencolar());


    }
    public static Cola mezclarColas (Cola cola1, Cola cola2){
        Cola resultado = new Cola();
        while (!cola1.vacia() || !cola2.vacia()){
            if (!cola1.vacia())
                resultado.encolar(cola1.desencolar());
            if (!cola2.vacia())
                resultado.encolar(cola2.desencolar());
        }
        return resultado;
    }
}
