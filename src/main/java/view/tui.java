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
                    1. Registra una nueva cuenta.
                    2. Gestionar inventario.
                    3. Gestionar accesos (admins).
                    4. Salir.
                    ///////////////////////
                    """
        );
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public int menuGesInventarioMain() { /* Cambiar por menu de instalacion (condicinal)*/
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

    public void salirAgendaMenuPrincipal () {
        System.out.println("Estás saliendo del menu..");
    }
    public void opcionNoValida () { System.out.println("La opción que seleccionaste no es válida."); }

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
}
