package view;

import java.util.Scanner;

public class tui {
    Scanner sc = new Scanner(System.in);

    void mensajeErrorExcepcion(Exception e) {
        System.out.println(e.getMessage());
    }

    public void menuInicioMain() { /* Cambiar por menu de instalacion (condicinal)*/
        int opcion = 0;
        do {
            System.out.println("""
                    /////MENU DE INICIO/////
                    1. Crear cuenta.
                    2. Salir.
                    ///////////////////////
                    """
            );
            opcion = Integer.parseInt(sc.nextLine()); /* Evitar salto de linea */
        } while (opcion !=2);
    }
}
