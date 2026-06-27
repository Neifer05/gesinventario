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

        return new String[]{nombre, apellido, apellido2, email, contraseña};
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
                    1. Añadir una nueva existencia.
                    2. Ver existencias.
                    3. Modificar existencia.
                    4. Añadir stock a existencia.
                    5. Quitar stock a existencia
                    6. Borrar existencia.
                    7. Exportar existencias (archivo .txt)
                    8. Importar existencias (archivo .txt)
                    9. Salir
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
