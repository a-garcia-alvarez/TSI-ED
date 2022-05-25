
public class Seguir_AETSISI {
    //NOMBRE  Y GRUPO DEL ALUMNO
    private GrafoMA miREd;
    private Persona[] contactos;


    public Seguir_AETSISI(int n, Persona[] contactos) { //construye una matriz de nxn sin aristas
        miREd= new GrafoMA(n,true);
        this.contactos = contactos;
    }

    public int getNumPersonas() {
        return miREd.getNumVertices();
    }


    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------
// método que inserta una relación de seguir_a directa (una arista en el grafo)
    public void insertaRelacion(int o, int d) {
            miREd.insertarArista(o,d);
    }
    // método que elimina una relación de seguir_a directa (una arista en el grafo)
    public void eliminaRelacion(int o, int d) {
        miREd.eliminarArista(o,d);
    }
    // método que indica si existe una relación de seguir_a directa (una arista en el grafo)
    public boolean existeRelacion(int o, int d) {
        return miREd.existeArista(o,d);
    }

    //Metodo que compara dos cadenas que representan dos nombres ignorando mayusculas y minusculas
    private boolean nombresIguales(String cad1, String cad2){
        return (cad1.equalsIgnoreCase(cad2));
    }


    // encuentra la posición asociado a un nombre de persona en la tabla de contactos que
    // ademas se corresponde con el vertice que le representa en el grafo

    public int devuelvePosNombre(String nombre){
        int i=0;
        boolean encontrado=false;
        while (i<contactos.length && !encontrado){
            encontrado= nombresIguales(nombre,contactos[i].getNombre());
            if (!encontrado) i++;
        }
       // if (!miREd.verticeEnRango(i)) i=-1;//si ha salido por i= contactos.length no esta el nombre en la tabla
        if (!encontrado) i=-1;
        return i;
    }

    // Imprime la Matriz del relaciones( Matriz de adyacencia del grafo) por consola
    public void imprimirRelaciones() {
        System.out.println("Contenido de la matriz: ");
        System.out.print("  ");
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+i +" ");
             else System.out.print(i+" " );
        }
        System.out.println();
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+i );
            else System.out.print(i );
        for (int j = 0; j < miREd.getNumVertices(); j++) {
                if (miREd.existeArista(i,j)) System.out.print(" S ");
                else System.out.print(" N ");
            }
            System.out.println();
        }
    }

    //Imprime la información de la red y la matriz de Relaciones por consola
    public void mostrarRed() {
        System.out.println("Existen " + miREd.getNumVertices() + " contactos: \n");
        for (int i = 0; i < miREd.getNumVertices(); i++)
            System.out.println(i + ": " + contactos[i].getNombre());
        imprimirRelaciones();
        System.out.println();
    }

// ------------------------------------

    // MÉTODOS A COMPLETAR

    // ------------------------------------


public void mostrar(){
        miREd.mostrar();
}


    // Apartado 2.2.1 Primer método


    public int contarGrupos () {
        int resul = 0;
       //Completar
        return resul;
    }






    // Apartado 2.2.2 Segundo método
    public void mostrarSeguidosPorADirectamente(String nombre) {
        //Completar
    }

    // Apartado 2.2.3 Tercer método
    public void mostrarSeguidoresDirectoDe(String nombre) {
        //Completar
    }
    // Apartado 2.2.4 Cuarto método
  public boolean sonDelMismoGrupo(Persona p, Persona p1){
      //Completar
      return true;
  }
    // Apartado 2.2.5 Quinto método
    public void motrarMiembrosGrupo(Persona p){
        //Completar
    }

    // Apartado 2.2.6 sexto método
    public void motrarSeguidosPor(Persona p){
        //Completar
    }

    // Apartado 2.2.7 séptimo método

    public boolean mostrarEsSeguidaPor(String nombre1, String nombre2){
        boolean resul= false;
        //Completar
        return resul;
    }


    // Apartado 2.2.8 octavo método (opcional)
   public void mostrarSeguidoresDe(String nombre1){
       //Completar

   }

}
	  




