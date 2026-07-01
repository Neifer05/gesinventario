package view;

import models.enums.Role;
import java.util.Scanner;

public class tui {
    Scanner sc = new Scanner(System.in);

    public void mensajeErrorExcepcion(String e) {
        System.out.println(e);
    }

    public String[] formularioIngreso () {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        return new String[]{email, pass};
    }

    public String registroNombre () {
        System.out.println("Ingresa tu nombre: ");
        return sc.nextLine();
    }

    public String registroApellido () {
        System.out.println("Ingresa tu apellido: ");
        return sc.nextLine();
    }

    public String registroApellido2 () {
        System.out.println("Ingresa tu segundo apellido: ");
        return sc.nextLine();
    }

    public String registroCorreo () {
        System.out.println("Ingresa tu correo electrónico: ");
        return sc.nextLine();
    }

    public String registroContraseña () {
        System.out.println("Ingresa tu contraseña: ");
        return sc.nextLine();
    }


    public int formularioIngresoCabecera () {
        System.out.println("Estás en el apartado de ingreso..");
        System.out.println("""
                -> Ingrese [1] para iniciar sesión.
                -> Ingrese [2] para registrarse.
                """);
        return Integer.parseInt(sc.nextLine());
    }

    public int menuInicioMain(Role rolUsuario) {
        System.out.println("\n///// MENU DE INICIO /////");
        System.out.println("1. Ver inventario y existencias.");
        System.out.println("2. Gestionar inventario.");
        if (rolUsuario == Role.ADMIN) {
            System.out.println("3. Gestionar accesos (admins).");
        }
        System.out.println("4. Salir.");
        System.out.println("//////////////////////////");

        return Integer.parseInt(sc.nextLine());
    }

    public int subMenuGesInventarioMain() { /* Cambiar por menu de instalacion (condicinal)*/
        int opcion = 0;
        System.out.println("""
                    /////MENU DE INICIO/////
                    -> Ingrese [1] para añadir una nueva existencia.
                    -> Ingrese [2] para ver existencias.
                    -> Ingrese [3] para modificar existencia.
                    -> Ingrese [4] para añadir stock a existencia.
                    -> Ingrese [5] para quitar stock a existencia.
                    -> Ingrese [6] para borrar existencia.
                    -> Ingrese [7] para exportar existencias (archivo .txt).
                    -> Ingrese [8] para importar existencias (archivo .txt)
                    -> Ingrese [9] para salir del menú.
                    ///////////////////////
                    """
        );
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public int subMenuGesInvAñadir () {
        int opcion = 0;
        System.out.println("""
                    /////MENU DE INICIO/////
                    1. Añadir un nuevo producto.
                    2. Añadir producto en venta.
                    3. Salir.
                    ///////////////////////
                    """
        );
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public int subMenuGesVerExistencia () {
        int opcion = 0;
        System.out.println("""
                    /////MENU DE INICIO/////
                    1. Ver todos los productos.
                    2. Ver los productos en venta.
                    3. Salir.
                    ///////////////////////
                    """
        );
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public void salirAgendaMenuPrincipal () {
        System.out.println("Estás saliendo del menu..");
    }
    public void opcionNoValida () { System.out.println("La opción que seleccionaste no es válida."); }
}
