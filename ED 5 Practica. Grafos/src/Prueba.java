
public class Prueba {
    public static void main (String [] args) {
        final int numeroContactos = 10;
        Persona[] contactos = new Persona[numeroContactos];
        // Insertar personas de la red
        Persona p0 = new Persona("Juan Nadie", "111111", "0");
        Persona p1 = new Persona("Jose Cuervo", "222222", "1");
        Persona p2 = new Persona("Eva Adan", "333333", "2");
        Persona p3 = new Persona("Alicia Maravillas", "777777", "3");
        Persona p4 = new Persona("Alan Turing", "999999", "4");
        Persona p5 = new Persona("Guillermo Tell", "159267", "5");
        Persona p6 = new Persona("Julio Catedrales", "123456", "6");
        Persona p7 = new Persona("Lucas Pato", "231465", "7");
        Persona p8 = new Persona("Paula Vazquez", "654321", "8");
        Persona p9 = new Persona("Clara Oscuro", "123654", "9");

        contactos[0] = p0;
        contactos[1] = p1;
        contactos[2] = p2;
        contactos[3] = p3;
        contactos[4] = p4;
        contactos[5] = p5;
        contactos[6] = p6;
        contactos[7] = p7;
        contactos[8] = p8;
        contactos[9] = p9;

        Seguir_AETSISI g = new Seguir_AETSISI(numeroContactos,contactos);
        // Insertar relaciones Seguir_A
        g.insertaRelacion(0,3);
        g.insertaRelacion(3,0);
        g.insertaRelacion(0,5);
        g.insertaRelacion(5,0);
        g.insertaRelacion(0,1);
        g.insertaRelacion(1,4);
        g.insertaRelacion(1,5);
        g.insertaRelacion(5,4);
        g.insertaRelacion(4,5);

        g.insertaRelacion(6,8);
        g.insertaRelacion(8,6);

        g.insertaRelacion(2,9);
        g.insertaRelacion(2,7);
        g.insertaRelacion(7,9);
        g.insertaRelacion(9,7);

        // Completar con todas las pruebas de los métodos del apartado 2.2.
        System.out.println("Apartado 2.2.1. Número de grupos:");
        System.out.println("Hay " + g.contarGrupos() + " grupos.");
        System.out.println();

        System.out.println("Apartado 2.2.2. Mostrar Seguidos por Guillermo directamente");
        g.mostrarSeguidosPorADirectamente("Guillermo Tell");
        System.out.println();

        System.out.println("Apartado 2.2.3. Mostrar Seguidores directos de Juan");
        g.mostrarSeguidoresDirectoDe("Juan Nadie");
        System.out.println();

        System.out.println("Apartado 2.2.4. pertenecen al mismo Grupo.");
        g.sonDelMismoGrupo(p7,p9);
        System.out.println();

        System.out.println("Apartado 2.2.5. Mostrar personas mismo Grupo de Clara 9");
        g.motrarMiembrosGrupo(p9);
        System.out.println();

        System.out.println("Apartado 2.2.6. Mostrar personas seguidas directa o\n indirectamente por Guillermo 5");
        g.motrarSeguidosPor(p5);
        System.out.println();

        System.out.println("Apartado 2.2.7. Juan 0 sigue a Alicia 3");
        System.out.println(g.mostrarEsSeguidaPor(p0.getNombre(), p3.getNombre()));
        System.out.println();

        System.out.println("Apartado 2.2.8. Seguidores de alicia");
        g.mostrarSeguidoresDe(p3.getNombre());
    }
}
