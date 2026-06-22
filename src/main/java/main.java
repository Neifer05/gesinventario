import controller.controladorDB;
import controller.controladorMemory;
import view.tui;

public class main {
    public static void main(String[] args) {
        controladorMemory cMemory = new controladorMemory();
        controladorDB c = new controladorDB(cMemory);
        tui t = new tui();
        c.connect();

        bucle_principal:
        while (true) {
            int opcionPrincipal = t.menuInicioMain();
            switch (opcionPrincipal) {
                case 1:
                    String[] datos = t.datosFormulario();
                    c.crearCuenta(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    break;
                case 2:
                    gestionarFlujoInventario(t);
                    break;
                case 4:
                    t.salirAgendaMenuPrincipal();
                    break bucle_principal;
                default:
                    t.opcionNoValida();
                    break;
            }
        }
    }
    private static void gestionarFlujoInventario (tui t) {
        while (true) {
            int opcionInventario = t.subMenuGesInventarioMain();

            switch (opcionInventario) {
                case 1:
                    int opcionAnadir = t.subMenuGesInvAñadir();
                    switch (opcionAnadir) {
                        case 1 -> System.out.println("Añadiendo nuevo producto...");
                        case 2 -> System.out.println("Añadiendo producto en venta...");
                        case 3 -> {} // Evitar que caiga en default.
                    }
                    break;
                case 2:
                    int opcionVer = t.subMenuGesVerExistencia();
                    switch (opcionVer) {
                        case 1 -> System.out.println("Mostrando todos los productos...");
                        case 2 -> System.out.println("Mostrando productos en venta...");
                        case 3 -> {}
                    }
                    break;
                case 9: {
                    System.out.println("Volviendo al menu principal."); //TODO: Cambiar para que la tui lo gestione.
                    return;
                }
                default:
                    t.opcionNoValida();
                    break;
            }
        }
    }
}