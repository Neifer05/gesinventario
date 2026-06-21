package view;

import java.util.Scanner;

public class tui {
    Scanner sc = new Scanner(System.in);

    void mensajeErrorExcepcion(Exception e) {
        System.out.println(e.getMessage());
    }

    public int menuInicioMain() { /* Cambiar por menu de instalacion (condicinal)*/
        int opcion = 0;
        System.out.println("""
                    /////MENU DE INICIO/////
                    1. Crear cuenta.
                    2. Salir.
                    ///////////////////////
                    """
        );
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public void salirAgendaMenuPrincipal () {
        System.out.println("Estás saliendo de la agenda..");
    }

    public String[] datosFormulario () {
        System.out.println("Ingresa tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa tu apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingresa tu segundo apellido: ");
        String apellido2 = sc.nextLine();
        System.out.println("Ingresa tu correo electrónico: ");
        String email = sc.nextLine();
        System.out.println("Ingresa tu contraseña: ");
        String contraseña = sc.nextLine();

        String[] datos = {nombre, apellido, apellido2, email, contraseña};
        return datos;
    }
}
